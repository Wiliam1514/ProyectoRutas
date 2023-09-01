<%-- 
    Document   : create
    Created on : 28 ago 2023, 18:52:09
    Author     : MINEDUCYT
--%>
<%@page import="proyectorutas.appweb.utils.SessionUser" %>
<%
    String rolUsuario = SessionUser.getRol(request);
    out.println("Rol del usuario: " + rolUsuario); // Muestra el valor del rol en la consola o página.
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Ruta" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Crear Ruta</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main>
            <h5>Crear Ruta</h5>
            <form action="Ruta" method="post" onsubmit="return validarFormulario()">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtNombreRuta" name ="nombreRuta" required 
                               class="validate" maxlength="30">
                        <label for="txtNombreRuta">Nombre</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtRecorrido" name ="recorrido" required 
                               class="validate" maxlength="30">
                        <label for="txtRecorrido">Recorrido</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtPuntoSalida" name ="puntoSalida" required 
                               class="validate" maxlength="25">
                        <label for="txtPuntoSalida">Salida</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtPuntoLlegada" name ="puntoLlegada" required 
                               class="validate" minlength="5" maxlength="32">
                        <label for="txtPuntoLlegada">Llegada</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtHoraInicio" name ="horaInicio" required 
                               class="validate" minlength="5" maxlength="32">
                        <label for="txtHoraInicio">HORA INICIO</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtHoraFin" name ="horaFin" required 
                               class="validate" minlength="5" maxlength="32">
                        <label for="txtHoraFin">HORA FIN</label>
                        
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtCodigoBus" name ="codigoBus" required 
                               class="validate" minlength="5" maxlength="32">
                        <label for="txtCodigoBus">CODIGO BUS</label>
                    </div>
                   <div class="input-field col 14 s12">
                       <jsp:include page="/Views/Departamento/select.jsp">
                           <jsp:param name="id" value="0"/>
                       </jsp:include>
                       <span id="slDepartamento_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                   </div>
                </div>
                <div class="row">
                    <div class="row">
                        <div class="col 112 s12">
                        <button type="submit" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">save</i>Guardar
                        </button>
                        <a href="Ruta" class="waves-effect waves-light btn blue">
                            <i class="material-icons right">list</i>Cancelar
                        </a>
                    </div>  
                    </div>
                </div>
            </form>
        </main>
        <jsp:include page="/Views/Shared/footerBody.jsp" />
        <script>
            function validarFormulario()
            {
                var result = true;
                var slDepartamento = $("#slDepartamento").val();
                
                if(parseInt(slDepartamento) == 0)
                {
                    $("#slDepartamento_error")
                            .empty();
                   $("#slDepartamento_error")
                    .append("El Departamento es obligatorio");
                    result = false;
                }
                else
                {
                    $("#slDepartamento_error")
                            .empty();
                }
                return result;
            }   
            
             <%--function validarFormulario() {
                var result = true;
                var txtPassword = document.getElementById("txtPassword");
                var txtConfirm_password = document.getElementById("txtConfirmPassword_aux");
                var txtConfirm_password_error = document.getElementById("txtConfirmPassword_aux_error");
                var slEstatus = document.getElementById("slEstatus");
                var slEstatus_error = document.getElementById("slEstatus_error");
                var slRol = document.getElementById("slRol");
                var slRol_error = document.getElementById("slRol_error");
                if (txtPassword.value != txtConfirm_password.value) {
                    txtConfirm_password_error.innerHTML = "El password y confirmar password debe ser iguales";
                    result = false;
                } else {
                    txtConfirm_password_error.innerHTML = "";
                }
                if (slEstatus.value == 0) {
                    slEstatus_error.innerHTML = "El estatus es obligatorio";
                    result = false;
                } else {
                    slEstatus_error.innerHTML = "";
                }
                if (slRol.value == 0) {
                    slRol_error.innerHTML = "El Rol es obligatorio";
                    result = false;
                } else {
                    slRol_error.innerHTML = "";
                }

                return result;
            }--%>
        </script>
    </body>
</html>

