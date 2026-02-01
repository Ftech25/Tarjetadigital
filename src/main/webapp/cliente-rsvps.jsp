<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirmaciones del Evento</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        th { background-color: #f9f9f9; }
        .confirmados { color: green; font-weight: bold; }
        .pendientes { color: red; font-weight: bold; }
    </style>
</head>
<body>
    <h2>📊 Confirmaciones del Evento</h2>

    <div>
        <p>Total confirmados: <span class="confirmados">${confirmados}</span></p>
        <p>Pendientes: <span class="pendientes">${pendientes}</span></p>
        <p>Total: ${total}</p>
    </div>

    <table>
        <tr>
            <th>Asiste</th>
            <th>Acompañantes</th>
            <th>Comentario</th>
            <th>Fecha</th>
        </tr>
        <c:forEach var="r" items="${listaRsvp}">
            <tr>
                <td>${r.asiste}</td>
                <td>${r.acompanantes}</td>
                <td>${r.comentario}</td>
                <td>${r.fechaRespuestaString}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
