<%@page import="proyectorutas.appweb.utils.SessionUser" %>
<%
    String rolUsuario = SessionUser.getRol(request);
    out.println("Rol del usuario: " + rolUsuario); // Muestra el valor del rol en la consola o página.
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.appweb.utils.*"%>
<nav>
    <div class="nav-wrapper blue">
        <a href="Home" class="brand-logo">ProyectoRutas</a>
        <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>       
        <ul class="right hide-on-med-and-down">
            
            <% if ("Administrador".equals(rolUsuario)) { %>
            <!-- Mostrar elementos para el administrador -->
            <li><a href="Home">Inicio</a></li>
            <li><a href="Usuario">Usuario</a></li>
            <li><a href="Rol">Rol</a></li>
            <li><a href="Ruta">Ruta</a></li>
            <li><a href="Usuario?accion=cambiarpass">Cambiar password</a></li>
            <li><a href="Departamento">Departamento</a></li>
            <li><a href="Usuario?accion=login">Cerrar sesión</a></li>
            
            <% } else if ("Usuario".equals(rolUsuario)) { %>
            <!-- Mostrar elementos para el usuario -->
            <li><a href="Ruta">Ruta</a></li>
            <li><a href="Usuario?accion=login">Cerrar sesión</a></li>
            <% } %>
            
        </ul>
    </div>
</nav>

<ul class="sidenav" id="mobile-demo">
    <% if ("Administrador".equals(rolUsuario)) { %>
    <!-- Mostrar elementos para el administrador en el menú lateral -->
    <li><a href="Home">Inicio</a></li>
    <li><a href="Departamento">Departamento</a></li>
    <li><a href="Usuario">Usuario</a></li>
    <li><a href="Rol">Rol</a></li>
    <li><a href="Ruta">Ruta</a></li>
    <li><a href="Usuario?accion=cambiarpass">Cambiar password</a></li>
    <li><a href="Usuario?accion=login">Cerrar sesión</a></li>
    <% } else if ("Usuario".equals(rolUsuario)) { %>
    <!-- Mostrar elementos para el usuario en el menú lateral -->
    <li><a href="Ruta">Ruta</a></li>
    <li><a href="Usuario?accion=login">Cerrar sesión</a></li>
    <% } %>
</ul>
