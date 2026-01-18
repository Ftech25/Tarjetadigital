<%-- 
    Document   : eventos
    Created on : 17 ene 2026, 20:38:43
    Author     : Facundo
--%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<h2>Listado de Eventos</h2>

<table border="1">
    <thead>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Tipo</th>
            <th>Modelo</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="e" items="${listaEventos}">
            <tr>
                <td>${e.idEvento}</td>
                <td>${e.titulo}</td>
                <td>${e.tipoEvento}</td>  <!-- ? CLAVE -->
                <td>${e.modelo}</td>      <!-- ? CLAVE -->
            </tr>
        </c:forEach>
    </tbody>
</table>
