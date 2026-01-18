package com.ftech.tarjetadigital.controller;

import com.ftech.tarjetadigital.dao.EventoDAO;
import com.ftech.tarjetadigital.model.Evento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/eventos")
public class EventoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EventoDAO dao = new EventoDAO();
        List<Evento> listaEventos = dao.listarEventos();
        

        System.out.println("EVENTOS EN SERVLET: " + listaEventos.size());

        request.setAttribute("listaEventos", listaEventos);
        request.getRequestDispatcher("/eventos.jsp").forward(request, response);
    }
}
