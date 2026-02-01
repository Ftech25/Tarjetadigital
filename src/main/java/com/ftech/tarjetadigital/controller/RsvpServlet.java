package com.ftech.tarjetadigital.controller;

import com.ftech.tarjetadigital.dao.RsvpDAO;
import com.ftech.tarjetadigital.model.Rsvp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/rsvp")
public class RsvpServlet extends HttpServlet {

    private RsvpDAO rsvpDAO;

    @Override
    public void init() {
        rsvpDAO = new RsvpDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Rsvp r = new Rsvp();

        r.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
        r.setAsiste(request.getParameter("asiste"));
        r.setAcompanantes(
            Integer.parseInt(
                request.getParameter("acompanantes").isEmpty() ? "0"
                : request.getParameter("acompanantes")
            )
        );
        r.setCancion(request.getParameter("cancion"));
        r.setComentario(request.getParameter("comentario"));

        rsvpDAO.guardar(r);

        response.sendRedirect(
            request.getContextPath() + "/Gracias.jsp"
        );
    }
}

