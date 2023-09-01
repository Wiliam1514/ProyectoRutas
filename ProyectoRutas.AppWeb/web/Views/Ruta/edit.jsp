<%-- 
    Document   : edit
    Created on : 28 ago 2023, 18:52:36
    Author     : MINEDUCYT
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Ruta" %>
<% Ruta ruta = (Ruta) request.getAttribute("ruta");%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/Views/Shared/title.jsp" />
        <title>Editar Ruta</title>
    </head>
    <body>
        <jsp:include page="/Views/Shared/headerBody.jsp" />
        <main class="container">
            <h5>Editar Ruta</h5>
            <form action="Ruta" method="post" onsubmit="return validarFormulario()">
                <input type="hidden" name="accion" 
                       value="<%=request.getAttribute("accion")%>" id="txtHidden">
                <input type="hidden" name="id" value="<%=ruta.getId()%>">
                <div class="row">
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtNombre" name ="nombreRuta" required 
                               class="validate" maxlength="30"
                               value="<%=ruta.getNombreRuta()%>">
                        <label for="txtNombre">Nombre</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtApellido" name ="recorrido" required 
                               class="validate" maxlength="30"
                               value="<%=ruta.getRecorrido()%>">
                        <label for="txtApellido">Recorrido</label>
                    </div>
                    <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="puntoSalida" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getPuntoSalida()%>">
                        <label for="txtLogin">Punto de salida</label>
                    </div>
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="puntoLlegada" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getPuntoLlegada()%>">
                        <label for="txtLogin">Punto de llegada</label>
                    </div>
                        
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="horaInicio" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getHoraInicio()%>">
                        <label for="txtLogin">Hora de inicio</label>
                    </div>
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="horaFin" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getHoraFin()%>">
                        <label for="txtLogin">Hora fin</label>
                        <div class="input-field col 14 s12">
                        <input type="text" id="txtLogin" name ="codigoBus" required 
                               class="validate" maxlength="25"
                               value="<%=ruta.getCodigoBus()%>">
                        <label for="txtLogin">Codigo de bus</label>
                    </div>
                        
                        
                    
                   <div class="input-field col 14 s12">
                       <jsp:include page="/Views/Departamento/select.jsp">
                           <jsp:param name="id" value="<%=ruta.getIdDepartamento()%>"/>
                       </jsp:include>
                       <span id="slDepartamento_error" 
                              style="color:red;font-weight: bold" class="helper-text">
                        </span>
                   </div>
                </div>
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


