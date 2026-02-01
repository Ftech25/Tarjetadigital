package com.ftech.tarjetadigital.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ftech.tarjetadigital.dao.EventoDAO;
import com.ftech.tarjetadigital.model.Evento;

import java.io.IOException;

@WebServlet("/e/*")
public class EventoPublicoServlet extends HttpServlet {

    private EventoDAO eventoDAO = new EventoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo(); // /facu-lilyan

        if (path == null || path.equals("/")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String slug = path.substring(1); // facu-lilyan

        Evento evento = eventoDAO.buscarPorSlug(slug);

        if (evento == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        request.setAttribute("evento", evento);
        request.getRequestDispatcher("/evento-publico.jsp")
                .forward(request, response);
    }

}
