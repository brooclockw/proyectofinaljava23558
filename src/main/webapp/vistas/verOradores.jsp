

<%@page import="com.dao.OradoresDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.Orador"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Oradores</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Lista de Oradores</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Tema</th>
            <th>Fecha Alta</th>
        </tr>
        </thead>
        <tbody>
        <%

            OradoresDAO oradoresDAO = new OradoresDAO();


            List<Orador> oradores = oradoresDAO.obtenerTodos();

            if (oradores != null && !oradores.isEmpty()) {

                for (Orador orador : oradores) {
        %>
        <tr>
            <td><%= orador.getIdOrador()%></td>
            <td><%= orador.getNombre()%></td>
            <td><%= orador.getApellido()%></td>
            <td><%= orador.getTema()%></td>
            <td><%= orador.getFechaAlta()%></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">No hay oradores registrados.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <!-- Botón para volver al índice -->
    <a href="../index.html" class="btn btn-success">Volver</a>
</div>
</body>
</html>