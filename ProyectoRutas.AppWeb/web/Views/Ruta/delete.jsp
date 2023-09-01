<%-- 
    Document   : delete
    Created on : 28 ago 2023, 18:52:20
    Author     : MINEDUCYT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Ruta" %>
<% Ruta ruta = (Ruta) request.getAttribute("ruta");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Eliminar Ruta</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main class="container">
            <h5>Eliminar Ruta</h5>
            <form action="Ruta" method="post">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <input type="hidden" name="id" value="<%=ruta.getId()%>">
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtNombre" name ="nombreRuta" required 
                               class="validate" maxlength="30"
                               value="<%=ruta.getNombreRuta()%>" disabled>
                        <label for="txtNombre">Nombre</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtApellido" name ="recorrido" required 
                               class="validate" maxlength="30"
                               value="<%=ruta.getRecorrido()%>" disabled>
                        <label for="txtApellido">Recorrido</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="puntoSalida" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getPuntoSalida()%>" disabled>
                        <label for="txtLogin">Salida</label>
                    </div>
                   <div class="input-field col 14 s12">
                       <input type="text" id="txtDpartamento" 
                              value="<%=ruta.getDepartamento().getNombreDepartamento()%>" disabled>
                       <label for="slEstado">Departameto</label>
                   </div>
                </div>
                <div class="row">
                    <div class="col 112 s12">
                        <button type="submit" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">delete</i>Eliminar
                        </button>
                        <a href="Ruta" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">list</i>Cancelar
                        </a>
                    </div>
                </div>
            </form>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
    </body>
</html>


