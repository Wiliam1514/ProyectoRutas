
<%@page import="proyectorutas.appweb.utils.SessionUser" %>
<%
    String rolUsuario = SessionUser.getRol(request);
    out.println("Rol del usuario: " + rolUsuario); // Muestra el valor del rol en la consola o página.
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Ruta" %>
<% Ruta ruta = (Ruta) request.getAttribute("ruta"); %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Detalle Ruta</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main class="container">
            <h5>Detalle Ruta</h5>
            
            <form action="Ruta" method="post" >
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
                        <input type="text" id="txtLogin" name ="horaInicio" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getHoraInicio()%>" disabled>
                        <label for="txtLogin">Hora Inicio</label>
                    </div>
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="horaFin" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getHoraFin()%>" disabled>
                        <label for="txtLogin">Hora Inicio</label>
                    </div>
                        
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="codigoBus" required 
                               class="validate" maxlength="100"
                               value="<%=ruta.getCodigoBus()%>" disabled>
                        <label for="txtLogin">Codigo bus</label>
                    </div>
                        
                   
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtIdRol" 
                              value="<%=ruta.getDepartamento().getNombreDepartamento()%>"
                              disabled>
                        <label for="txtIdRol">Departamento</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col 112 s12">
                        <% if ("Administrador".equals(rolUsuario)) { %>
                            <a href="Ruta?accion=edit&id=<%=ruta.getId()%>" class="waves-effect waves-light btn blue">
                                <i class="material-icons right">edit</i>Ir a Editar
                            </a>
                        <% } %>
                        <a href="Ruta" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">
                                <% if ("Usuario".equals(rolUsuario)) { %>keyboard_arrow_left<% }
                                   else { %>list<% } %>
                            </i>
                            <% if ("Usuario".equals(rolUsuario)) { %>Atrás<% }
                               else { %>Cancelar<% } %>
                        </a>
                    </div>
                </div>
            </form>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
    </body>
</html>
