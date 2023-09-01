/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package proyectorutas.appweb.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import proyectorutas.accesoadatos.DepartamentoDAL;
import proyectorutas.accesoadatos.RutaDAL;
import proyectorutas.appweb.utils.Utilidad;
import proyectorutas.en.Departamento;
import proyectorutas.en.Ruta;


/**
 *
 * @author MINEDUCYT
 */
@WebServlet(name = "RutaServlet", urlPatterns = {"/Ruta"})
public class RutaServlet extends HttpServlet {
     private Ruta obtenerRuta(HttpServletRequest request)
    {
        String accion = Utilidad.getParameter(request, "accion", 
                "index");
        Ruta ruta = new Ruta();
        
        
        ruta.setIdDepartamento(Integer.parseInt(Utilidad.getParameter(request, 
                "idDepartamento", "0")));
        ruta.setNombreRuta(Utilidad.getParameter(request, "nombreRuta", 
                ""));
        
        ruta.setRecorrido(Utilidad.getParameter(request, 
                "recorrido", ""));
        
        ruta.setPuntoSalida(Utilidad.getParameter(request, 
                "puntoSalida", ""));
        ruta.setPuntoLlegada(Utilidad.getParameter(request, 
                "puntoLlegada", ""));
        
        ruta.setHoraInicio(Utilidad.getParameter(request, 
                "horaInicio", "0"));
        
         ruta.setHoraFin(Utilidad.getParameter(request, 
                "horaFin", "0"));
         
         ruta.setCodigoBus(Utilidad.getParameter(request,
                 "codigoBus", "0"));
      
            ruta.setId(Integer.parseInt(Utilidad.getParameter(request, 
                "id", "0")));
     
        return ruta;
    }
     protected void doGetRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = new Ruta();
            ruta.setTop_aux(10);
            ArrayList<Ruta> rutas = RutaDAL.buscarIncluirDepartamento(
                                    ruta);
            request.setAttribute("rutas", rutas);
            request.setAttribute("top_aux", ruta.getTop_aux());
            request.getRequestDispatcher("Views/Ruta/index.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
     protected void doPostRequestIndex(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = new Ruta();
            ruta.setTop_aux(10);
            ArrayList<Ruta> rutas = RutaDAL.buscarIncluirDepartamento(
                                    ruta);
            request.setAttribute("rutas", rutas);
            request.setAttribute("top_aux", ruta.getTop_aux());
            request.getRequestDispatcher("Views/Ruta/index.jsp").forward(request, response);
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
     protected void doGetRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            request.getRequestDispatcher("Views/Ruta/create.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestCreate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = obtenerRuta(request);
            int result = RutaDAL.crear(ruta);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Guardar el Regisgtro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void requestObtenerPorId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = obtenerRuta(request);
            Ruta ruta_result = RutaDAL.obtenerPorId(ruta);
            if(ruta.getId() > 0)
            {
                Departamento departamento = new Departamento();
                departamento.setId(ruta_result.getIdDepartamento());
                ruta_result.setDepartamento(DepartamentoDAL.obtenerPorId(departamento));
                request.setAttribute("ruta", ruta_result);
            }
            else
            {
                Utilidad.enviarError("El Id: " + ruta_result.getId() 
                + " no existe en la base de datos", request, response);
            }
        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Ruta/edit.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = obtenerRuta(request);
            int result = RutaDAL.modificar(ruta);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Actualizar el Registro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    
    protected void doGetRequestDetails(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Ruta/details.jsp")
                    .forward(request, response);
    }
    
    protected void doGetRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            requestObtenerPorId(request,response);
            request.getRequestDispatcher("Views/Ruta/delete.jsp")
                    .forward(request, response);
    }
    
    protected void doPostRequestDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            Ruta ruta = obtenerRuta(request);
            int result = RutaDAL.eliminar(ruta);
            if(result != 0)
            {
                request.setAttribute("accion", "index");
                doGetRequestIndex(request, response);
            }
            else
            {
                Utilidad.enviarError("Error al Eliminar el Regisgtro", request, response);
            }

        }
        catch(Exception ex)
        {
            Utilidad.enviarError(ex.getMessage(), request, response);
        }
    }
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String accion = Utilidad.getParameter(request, "accion", "index");
   
        request.setAttribute("accion", accion);
        
     
        switch (accion) {
            case "index":
                request.setAttribute("accion", accion);
                doGetRequestIndex(request, response);
                break;
                
            case "create":
                request.setAttribute("accion", accion);
                doGetRequestCreate(request, response);
                break;
            case "edit":
                request.setAttribute("accion", accion);
                doGetRequestEdit(request, response);
                break;
            case "details":
                request.setAttribute("accion", accion);
                doGetRequestDetails(request, response);
                break;
            case "delete":
                request.setAttribute("accion", accion);
                doGetRequestDelete(request, response);
                break;
        }
    }
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String accion = Utilidad.getParameter(request, "accion", "index");
    
        request.setAttribute("accion", accion);
        
     {
        switch (accion) {
            case "index":
                request.setAttribute("accion", accion);
                doPostRequestIndex(request, response);
                break;
            case "create":
                request.setAttribute("accion", accion);
                doPostRequestCreate(request, response);
                break;
            case "edit":
                request.setAttribute("accion", accion);
                doPostRequestEdit(request, response);
                break;
            case "delete":
                request.setAttribute("accion", accion);
                doPostRequestDelete(request, response);
                break;
            
        }
    }
}

}

    

    
   

