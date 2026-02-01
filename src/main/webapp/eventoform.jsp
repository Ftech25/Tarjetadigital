<%-- 
    Document   : eventoform
    Created on : 18 ene 2026, 0:36:12
    Author     : Facundo
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<h2>
    <c:if test="${evento == null}">Nuevo Evento</c:if>
    <c:if test="${evento != null}">Editar Evento</c:if>
</h2>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

<form action="/TarjetaDigital/eventos" method="post">


    <input type="hidden" name="accion" value="guardar" />

    <c:if test="${evento != null}">
        <input type="hidden" name="id" value="${evento.idEvento}" />
    </c:if>

    <!-- CAMPOS VISIBLES -->
    <label>Título</label><br>
    <input type="text" name="titulo"
           value="${evento.titulo}" required /><br><br>

    <label>Fecha</label><br>
    <input type="date" name="fechaEvento"
           value="${evento.fechaEvento}" required /><br><br>

    <label>Descripción</label><br>
    <textarea name="mensajeBienvenida">${evento.mensajeBienvenida}</textarea><br><br>

    <!-- CAMPOS OCULTOS -->
    <input type="hidden" name="tipoEvento" value="GENERAL" />
    <input type="hidden" name="horaEvento" value="00:00" />
    <input type="hidden" name="modelo" value="default" />
    <input type="hidden" name="direccion" value="" />
    <input type="hidden" name="mapasUrl" value="" />

    <button type="submit">Guardar</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/eventos">⬅ Volver</a>
