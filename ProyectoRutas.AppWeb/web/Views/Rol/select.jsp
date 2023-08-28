<%-- 
    Document   : select
    Created on : 26 ago 2023, 11:43:04
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Rol" %>
<%@page import="proyectorutas.accesoadatos.RolDAL" %>
<%@page import="java.util.ArrayList" %>
<% ArrayList<Rol> roles = RolDAL.obtenerTodos();
   int id = Integer.parseInt(request.getParameter("id"));
%>
<select id="slRol" name="idRol">
    <option <%=(id == 0) ? "selected" : "" %> value="0">Seleccionar</option>
    <%for(Rol rol: roles)
    {
    %>
    <option <%=(id==rol.getId()) ? "selected" : "" %>
        value="<%=rol.getId()%>">
        <%=rol.getNombreRol()%>
    </option>
    <%
    }%>
</select>
<label for="slRol">Rol</label>

