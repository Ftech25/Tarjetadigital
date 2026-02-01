<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${evento.titulo}</title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- CSS BASE (común a todos los modelos) -->
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/base.css">

        <!-- CSS DEL MODELO -->
        <link rel="stylesheet"
              href="${pageContext.request.contextPath}/css/modelo-${evento.modelo}.css">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;600&family=Montserrat:wght@300;500&display=swap" rel="stylesheet">
    </head>

    <body>

        <div class="invitation fade-in">

            <!-- TIPO DE EVENTO -->
            <span class="event-type">
                ${evento.tipoEvento}
            </span>

            <!-- TITULO -->
            <h1 class="event-title">
                ${evento.titulo}
            </h1>

            <!-- COUNTDOWN -->
            <div id="countdown" class="countdown"></div>

            <div class="divider"></div>

            <!-- FECHA -->
            <div class="event-date">
                ? ${evento.fechaEvento}
            </div>

            <!-- MENSAJE -->
            <p class="welcome-text">
                ${evento.mensajeBienvenida}
            </p>

            <!-- UBICACIÓN -->
            <div class="location">
                ? ${evento.direccion}
            </div>

            <!-- BOTÓN RSVP -->
            <a class="btn-primary" href="#rsvp">
                Confirmar asistencia
            </a>

        </div>


        <!-- FORM RSVP -->
        <form method="post"
              action="${pageContext.request.contextPath}/rsvp"
              class="rsvp-form">

            <!-- ID EVENTO OCULTO -->
            <input type="hidden" name="idEvento" value="${evento.idEvento}">

            <input type="text"
                   name="nombre"
                   placeholder="Tu nombre"
                   required>

            <select name="asiste">
                <option value="SI">Asistiré</option>
                <option value="NO">No podré asistir</option>
                <option value="TAL_VEZ">Tal vez</option>
            </select>

            <input type="number"
                   name="acompanantes"
                   min="0"
                   placeholder="Acompañantes">

            <input type="text"
                   name="cancion"
                   placeholder="Canción sugerida ?">

            <textarea name="comentario"
                      placeholder="Comentario"></textarea>

            <button type="submit" class="btn-primary">
                Confirmar asistencia
            </button>
        </form>



        <!-- MAPA -->
    <c:if test="${not empty evento.mapasUrl}">
        <div class="map">
            <iframe
                src="${evento.mapasUrl}"
                width="100%" height="220"
                style="border:0;"
                loading="lazy">
            </iframe>
        </div>
    </c:if>

    <!-- GALERÍA -->
    <div class="gallery">
        <img src="${pageContext.request.contextPath}/uploads/eventos/${evento.slug}/1.jpg">
        <img src="${pageContext.request.contextPath}/uploads/eventos/${evento.slug}/2.jpg">
        <img src="${pageContext.request.contextPath}/uploads/eventos/${evento.slug}/3.jpg">
    </div>

    <!-- SCRIPT COUNTDOWN -->
    <script>
        const eventDate = new Date("${evento.fechaEvento} 00:00:00").getTime();

        setInterval(() => {
            const now = new Date().getTime();
            const diff = eventDate - now;

            if (diff <= 0) {
                document.getElementById("countdown").innerHTML =
                        "? ¡Hoy es el gran día!";
                return;
            }

            const days = Math.floor(diff / (1000 * 60 * 60 * 24));
            const hours = Math.floor((diff / (1000 * 60 * 60)) % 24);

            document.getElementById("countdown").innerHTML =
                    `Faltan ${days} días y ${hours} hs`;
        }, 1000);

    </script>

</body>
</html>
