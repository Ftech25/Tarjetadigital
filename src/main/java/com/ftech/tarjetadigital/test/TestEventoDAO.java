package com.ftech.tarjetadigital.test;

import com.ftech.tarjetadigital.dao.EventoDAO;
import com.ftech.tarjetadigital.model.Evento;
import com.ftech.tarjetadigital.model.ModeloEvento;
import com.ftech.tarjetadigital.model.EstadoEvento;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class TestEventoDAO {

    public static void main(String[] args) {

        Evento evento = new Evento();

        evento.setIdCliente(1); // debe existir en la tabla cliente
        evento.setTitulo("Boda Facu y Ana");
        evento.setTipoEvento("BODA");
        evento.setFechaEvento(LocalDate.of(2026, 5, 20));
        evento.setHoraEvento(LocalTime.of(20, 30));
        evento.setSlug("boda-facu-ana");
        evento.setModelo(ModeloEvento.ESTANDAR);
        evento.setEstado(EstadoEvento.BORRADOR);

        evento.setMensajeBienvenida("¡Te esperamos para celebrar con nosotros!");
        evento.setDireccion("Salón Los Robles");
        evento.setMapasUrl("https://maps.google.com/?q=salon");

        EventoDAO dao = new EventoDAO();

        boolean creado = dao.crearEvento(evento);

        if (creado) {
            System.out.println("✅ Evento insertado correctamente");
        } else {
            System.out.println("❌ Error al insertar evento");
        }
        List<Evento> eventos = dao.listarEventos();
        for (Evento e : eventos) {
            System.out.println(e.getIdEvento() + " - " + e.getTitulo());
        }

    }
}
