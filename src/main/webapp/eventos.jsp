<%-- 
    Document   : eventos
    Created on : 17 ene 2026, 20:38:43
    Author     : Facundo
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin.css">
<a href="${pageContext.request.contextPath}/admin/rsvps?idEvento=${e.idEvento}">
    👥 RSVPs
</a>


<div class="admin-container">

    <div class="header">
        <h2>📋 Panel de Eventos</h2>

        <a href="${pageContext.request.contextPath}/eventos?accion=nuevo"
           class="btn btn-primary">
            ➕ Nuevo Evento
        </a>
    </div>

    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Título</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="e" items="${listaEventos}">
                <tr>
                    <td>${e.idEvento}</td>
                    <td>${e.titulo}</td>
                    <td>${e.fechaEvento}</td>

                    <td>
                        <c:choose>
                            <c:when test="${e.activo}">
                                <span class="badge badge-active">Activo</span>
                            </c:when>
                            <c:otherwise>
                                <span class="badge badge-inactive">Inactivo</span>
                            </c:otherwise>
                        </c:choose>
                    </td>

                    <td>
                        <div class="actions">

                            <!-- EDITAR -->
                            <a class="icon edit"
                               href="${pageContext.request.contextPath}/eventos?accion=editar&id=${e.idEvento}"
                               title="Editar">
                                ✏️
                            </a>

                            <!-- ACTIVAR / DESACTIVAR -->
                            <form method="post"
                                  action="${pageContext.request.contextPath}/eventos">
                                <input type="hidden" name="accion" value="estado">
                                <input type="hidden" name="id" value="${e.idEvento}">
                                <button class="icon toggle"
                                        title="Cambiar estado">
                                    ${e.activo ? '⛔' : '✅'}
                                </button>
                            </form>

                            <!-- ELIMINAR -->
                            <form method="post"
                                  action="${pageContext.request.contextPath}/eventos"
                                  onsubmit="return confirm('¿Eliminar evento?');">
                                <input type="hidden" name="accion" value="eliminar">
                                <input type="hidden" name="id" value="${e.idEvento}">
                                <button class="icon delete"
                                        title="Eliminar">
                                    🗑️
                                </button>
                            </form>

                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
