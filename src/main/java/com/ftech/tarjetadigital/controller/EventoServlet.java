package com.ftech.tarjetadigital.controller;

import com.ftech.tarjetadigital.dao.EventoDAO;
import com.ftech.tarjetadigital.model.Evento;
import com.ftech.tarjetadigital.model.ModeloEvento;
import com.ftech.tarjetadigital.model.EstadoEvento;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/eventos")
public class EventoServlet extends HttpServlet {

    private EventoDAO eventoDAO;

    @Override
    public void init() {
        eventoDAO = new EventoDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null || accion.equals("listar")) {
            listar(request, response);
        } else if (accion.equals("nuevo")) {
            mostrarFormulario(request, response);
        } else if (accion.equals("editar")) {
            editar(request, response);
        } else {
            response.sendRedirect("eventos");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("guardar".equals(accion)) {
            guardar(request, response);
        } else if ("estado".equals(accion)) {
            cambiarEstado(request, response);
        } else if ("eliminar".equals(accion)) {
            eliminar(request, response);
        }

    }

    // =========================
    // MÉTODOS PRIVADOS LISTAR
    // =========================
    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Evento> listaEventos = eventoDAO.listarEventos();
        request.setAttribute("listaEventos", listaEventos);

        request.getRequestDispatcher("/eventos.jsp")
                .forward(request, response);
    }
    // =========================
    // MÉTODOS PRIVADOS MOSTRARFORM
    // =========================

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/eventoform.jsp")
                .forward(request, response);

    }

    // =========================
    // MÉTODOS PRIVADOS EDIT
    // =========================
    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Evento evento = eventoDAO.buscarPorId(id);

        request.setAttribute("evento", evento);
        request.getRequestDispatcher("/eventoform.jsp")
                .forward(request, response);

    }

    // =========================
    // MÉTODOS PRIVADOS GUARDAR
    // =========================
    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        Evento evento = new Evento();
        evento.setIdCliente(1);

        evento.setTitulo(request.getParameter("titulo"));
        evento.setTipoEvento("GENERAL");
        evento.setFechaEvento(LocalDate.parse(request.getParameter("fechaEvento")));
        evento.setHoraEvento(LocalTime.MIDNIGHT);
        evento.setModelo(ModeloEvento.ESTANDAR);
        evento.setEstado(EstadoEvento.BORRADOR);
        evento.setActivo(true);
        evento.setEliminado(false);
        evento.setMensajeBienvenida(request.getParameter("mensajeBienvenida"));
        evento.setDireccion("");
        evento.setMapasUrl("");

        String slugBase = evento.getTitulo()
                .toLowerCase()
                .trim()
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("(^-|-$)", "");

        String slug = slugBase;
        int contador = 1;

        while (eventoDAO.existeSlug(slug)) {
            slug = slugBase + "-" + contador;
            contador++;
        }

        evento.setSlug(slug);

        boolean ok;

        String idParam = request.getParameter("id");

        if (idParam != null && !idParam.isEmpty()) {
            evento.setIdEvento(Integer.parseInt(idParam));
            ok = eventoDAO.actualizarEvento(evento);
        } else {
            ok = eventoDAO.crearEvento(evento);
        }

        System.out.println("GUARDADO = " + ok);

        response.sendRedirect(request.getContextPath() + "/eventos");
    }

    // =========================
    // MÉTODOS PRIVADOS CAMBIAR ESTADO
    // =========================
    private void cambiarEstado(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        eventoDAO.cambiarEstado(id);

        response.sendRedirect(request.getContextPath() + "/eventos");
    }

    // =========================
    // MÉTODOS PRIVADOS ELIMINAR
    // =========================
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        eventoDAO.eliminarLogico(id);

        response.sendRedirect(request.getContextPath() + "/eventos");
    }

}
