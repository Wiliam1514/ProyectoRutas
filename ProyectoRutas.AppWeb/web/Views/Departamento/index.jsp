<%-- 
    Document   : index
    Created on : 28 ago 2023, 9:06:18
    Author     : MINEDUCYT
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Departamento"%>
<%@page import="java.util.ArrayList" %>
<%ArrayList<Departamento> departamentos = (ArrayList<Departamento>) request.getAttribute("departamentos");
    int numPage = 1;
    int numReg = 10;
    int countReg = 0;
    if(departamentos == null)
    {
        departamentos = new ArrayList();
    }
    else
        if(departamentos.size() > numReg)
        {
            double divNumPage = (double) departamentos.size() / (double) numReg;
            numPage = (int) Math.ceil(divNumPage);
        }
    String strTop_aux = request.getParameter("top_aux");
    int top_aux = 10;
    if(strTop_aux != null && strTop_aux.trim().length() > 0)
    {
        top_aux = Integer.parseInt(strTop_aux);
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Buscar Departamento</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" /> 
        <main class="container">
           <h5>Buscar Departamento</h5>
           <form action="Departamento" method="post">
               <input type="hidden" name="accion" value="<%request.getAttribute("accion");%>">
               <div class="row">
                   <div class="input-field col 16 s12">
                       <input type="text" id="txtNombre" name="nombre">
                       <label for="txtNombre">Nombre</label>
                   </div>
                   <div class="input-field col 13 s12">
                       <jsp:include page="/Views/Shared/selectTop.jsp">
                           <jsp:param name="top_aux" value="<%=top_aux%>"/>
                       </jsp:include>
                   </div>
               </div>
               <div class="row">
                   <div class="input-field col 16 s12">
                       <button type="submit" class="waves-effect waves-ligth btn blue">Buscar</button>
                       <a href="Departamento?accion=create" class="waves-effect waves-ligth btn blue">Nuevo</a>
                   </div>
               </div>
           </form>
               
            <div class="row">
                <div class="col 112 s12">
                    <div style="overflow: auto;">
                        <table class="paginationjs">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                for(Departamento departamento:departamentos)
                                {
                                   int tempNumPage = numPage;
                                   if(numPage > 1)
                                   {
                                        countReg++;
                                        double divTempNumPage = (double) countReg / (double) numReg;
                                        tempNumPage = (int) Math.ceil(divTempNumPage);
                                   }
                                %>
                                    <tr data-page="<%=tempNumPage%>">
                                        <td><%=departamento.getNombreDepartamento()%></td>
                                        <td>
                                            <div style="display: flex">
                                                <a href="Departamento?accion=edit&id=<%=departamento.getId()%>" 
                                                   title="Mofificar" class="waves-effect waves-light btn green">
                                                    <i class="material-icons">edit</i>
                                                </a>
                                                <a href="Departamento?accion=details&id=<%=departamento.getId()%>" 
                                                   title="Ver" class="waves-effect waves-light btn blue">
                                                    <i class="material-icons">description</i>
                                                </a>
                                                <a href="Departamento?accion=delete&id=<%=departamento.getId()%>" 
                                                   title="Eliminar" class="waves-effect waves-light btn red">
                                                    <i class="material-icons">delete</i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr> 
                                <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col 112 s12">
                    <jsp:include page="/Views/Shared/paginacion.jsp">
                        <jsp:param name="numPage" value="<%=numPage%>"/>
                    </jsp:include> 
                </div>
            </div>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
    </body>
</html>


