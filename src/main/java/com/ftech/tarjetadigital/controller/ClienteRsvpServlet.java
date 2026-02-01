package com.ftech.tarjetadigital.controller;

import com.ftech.tarjetadigital.dao.RsvpDAO;
import com.ftech.tarjetadigital.model.Rsvp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/evento/rsvps")
public class ClienteRsvpServlet extends HttpServlet {

    private RsvpDAO rsvpDAO;

    @Override
    public void init() { rsvpDAO = new RsvpDAO(); }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("idEvento");
        if (idParam == null || idParam.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "idEvento es obligatorio");
            return;
        }

        int idEvento = Integer.parseInt(idParam);
        List<Rsvp> lista = rsvpDAO.listarPorEvento(idEvento);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        lista.forEach(r -> {
            if (r.getFechaRespuesta() != null) {
                r.setFechaRespuestaString(r.getFechaRespuesta().format(formatter));
            } else {
                r.setFechaRespuestaString("-");
            }
        });

        long total = lista.size();
        long confirmados = lista.stream().filter(r -> "Sí".equalsIgnoreCase(r.getAsiste())).count();
        long pendientes = lista.stream().filter(r -> "No".equalsIgnoreCase(r.getAsiste())).count();

        request.setAttribute("listaRsvp", lista);
        request.setAttribute("total", total);
        request.setAttribute("confirmados", confirmados);
        request.setAttribute("pendientes", pendientes);

        request.getRequestDispatcher("/cliente-rsvps.jsp").forward(request, response);
    }
}
