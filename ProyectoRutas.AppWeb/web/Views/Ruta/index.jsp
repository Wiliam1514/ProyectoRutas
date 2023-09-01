<%-- 
    Document   : index
    Created on : 28 ago 2023, 18:52:44
    Author     : MINEDUCYT
--%>
 import="proyectorutas.appweb.utils.SessionUser" %>
<%
    String rolUsuario = SessionUser.getRol(request);
    out.println("Rol del usuario: " + rolUsuario); // Muestra el valor del rol en la consola o página.
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Ruta" %>
<%@page import="proyectorutas.en.Departamento"%>
<%@page import="java.util.ArrayList" %>
<% ArrayList<Ruta> rutas = (ArrayList<Ruta>) request.getAttribute("rutas");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if (rutas == null) {
        rutas = new ArrayList();
    } else if (rutas.size() > numReg) {
        double divNumPage = (double) rutas.size() / (double) numReg;
        numPage = (int) Math.ceil(divNumPage);
    }
    String strTop_aux = request.getParameter("top_aux");
    int top_aux = 10;
    if (strTop_aux != null && strTop_aux.trim().length() > 0) {
        top_aux = Integer.parseInt(strTop_aux);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/Views/Shared/title.jsp" />
    <title>Buscar Ruta</title>
</head>
<body>
    <jsp:include page="/Views/Shared/headerBody.jsp" /> 
    <main class="container">
       <h5>Buscar Ruta</h5>
       <form action="Ruta" method="post">
           <input type="hidden" name="accion" value="<% request.getAttribute("accion"); %>">
           <div class="row">
               <div class="input-field col 14 s12">
                   <input type="text" id="txtNombreRuta" name="nombreRuta">
                   <label for="txtNombreRuta">Ruta</label>
               </div>
               <div class="input-field col 14 s12">
                   <input type="text" id="txtRecorrido" name="recorrido">
                   <label for="txtRecorrido">Recorrido</label>
               </div>
               
               
               <div class="input-field col 14 s12">
                   <jsp:include page="/Views/Departamento/select.jsp">
                       <jsp:param name="id" value="0"/>
                   </jsp:include>
               </div>
               <div class="input-field col 14 s12">
                   <jsp:include page="/Views/Shared/selectTop.jsp">
                       <jsp:param name="top_aux" value="<%= top_aux %>"/>
                   </jsp:include>
               </div>
           </div>
           <div class="row">
               <div class="input-field col 16 s12">
                   <button type="submit" class="waves-effect waves-light btn blue">Buscar</button>
                   <% if ("Administrador".equals(rolUsuario)) { %>
    <a href="Ruta?accion=create" class="waves-effect waves-light btn blue">Nuevo</a>
<% } %>

               </div>
           </div>
       </form>
       <div class="row">
           <div class="col 112 s12">
               <div style="overflow: auto;">
                   <table class="paginationjs">
                       <thead>
                           <tr>
                               <th>Departamento</th>
                               <th>Nombre</th>
                               <!-- <th>Punto de Salida</th> -->
                               <th>Recorrido</th>
                               <!-- <th>Punto de Llegada</th> -->
                               <!-- <th>Hora de Inicio</th> -->
                               <!-- <th>Hora de Fin</th> -->
                               <!-- <th>Código de Bus</th> -->
                           </tr>
                       </thead>
                       <tbody>
                           <%
                           for (Ruta ruta : rutas) {
                               int tempNumPage = numPage;
                               if (numPage > 1) {
                                   countReg++;
                                   double divTempNumPage = (double) countReg / (double) numReg;
                                   tempNumPage = (int) Math.ceil(divTempNumPage);
                               }
                           %>
                           <tr data-page="<%= tempNumPage %>">
                                <td><%=ruta.getDepartamento().getNombreDepartamento()%></td>
                               <td><%=ruta.getNombreRuta()%></td>
                               <td><%=ruta.getRecorrido()%></td>
                               
                               <td>
                                            <div style="display: flex">
    <a href="Ruta?accion=details&id=<%=ruta.getId()%>" 
        title="Ver" class="waves-effect waves-light btn blue">
        <i class="material-icons">description</i>
    </a>
    <% if ("Administrador".equals(rolUsuario)) { %>
        <a href="Ruta?accion=edit&id=<%=ruta.getId()%>" 
            title="Modificar" class="waves-effect waves-light btn green">
            <i class="material-icons">edit</i>
        </a>
        <a href="Ruta?accion=delete&id=<%=ruta.getId()%>" 
            title="Eliminar" class="waves-effect waves-light btn red">
            <i class="material-icons">delete</i>
        </a>
    <% } %>
</div>

                                        </td>
                           </tr>
                           <%
                           }
                           %>
                       </tbody>
                   </table>
               </div>
           </div>
       </div>
       <div class="row">
           <div class="col 112 s12">
               <jsp:include page="/Views/Shared/paginacion.jsp">
                   <jsp:param name="numPage" value="<%= numPage %>"/>
               </jsp:include> 
           </div>
       </div>
   </main>
   <jsp:include page="/Views/Shared/footerBody.jsp" />
</body>
</html>
