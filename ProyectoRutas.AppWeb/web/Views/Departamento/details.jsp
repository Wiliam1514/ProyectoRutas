<%-- 
    Document   : details
    Created on : 28 ago 2023, 9:06:02
    Author     : MINEDUCYT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Departamento" %>
<% Departamento departamento = (Departamento) request.getAttribute("departamento");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Detalle Departamento</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main>
            <h5>Datelle Departamento</h5>
            <form action="Departamento" method="post">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <input type="hidden" name="id" value="<%=departamento.getId()%>" />
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" disabled id="txtNombre" name ="nombre" required 
                               class="validate" maxlength="30" 
                               value="<%=departamento.getNombreDepartamento()%>">
                        <label for="txtNombre">Nombre</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col 112 s12">
                        <a href="Departamento?accion=edit&id=<%=departamento.getId()%>" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">edit</i>Ir a Editar
                        </a>
                        <a href="Departamento" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">list</i>Cancelar
                        </a>
                    </div>
                </div>
            </form>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
    </body>
</html>


