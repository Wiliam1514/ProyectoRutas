<%-- 
    Document   : select
    Created on : 28 ago 2023, 9:06:26
    Author     : MINEDUCYT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="proyectorutas.en.Departamento" %>
<%@page import="proyectorutas.accesoadatos.DepartamentoDAL" %>
<%@page import="java.util.ArrayList" %>
<%
ArrayList<Departamento> departamentos = DepartamentoDAL.obtenerTodos();
int id = Integer.parseInt(request.getParameter("id"));
%>
<select id="slDepartamento" name="idDepartamento">
    <option <%= (id == 0) ? "selected" : "" %> value="0">Seleccionar</option>
    <% for (Departamento departamento : departamentos) { %>
        <option <%= (id == departamento.getId()) ? "selected" : "" %> 
            value="<%= departamento.getId() %>">
            <%= departamento.getNombreDepartamento() %>
        </option>
    <% } %>
</select>
<label for="slDepartamento">Departamento</label>
