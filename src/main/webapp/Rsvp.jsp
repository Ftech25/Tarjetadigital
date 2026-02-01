

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>📋 Confirmaciones</h2>

<table class="table">
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
            <td>${r.fechaRespuesta}</td>
        </tr>
    </c:forEach>
</table>

    </body>
</html>
