package com.ftech.tarjetadigital.dao;

import com.ftech.tarjetadigital.config.ConexionBD;
import com.ftech.tarjetadigital.model.Evento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;


public class EventoDAO {

    public boolean crearEvento(Evento e) {

        String sql = "INSERT INTO eventos " +
                "(id_cliente, titulo, tipo_evento, fecha_evento, hora_evento, slug, modelo, mensaje_bienvenida, direccion, mapas_url) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getIdCliente());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getTipoEvento());
            ps.setDate(4, Date.valueOf(e.getFechaEvento()));
            ps.setTime(5, Time.valueOf(e.getHoraEvento()));
            ps.setString(6, e.getSlug());
            ps.setString(7, e.getModelo());
            ps.setString(8, e.getMensajeBienvenida());
            ps.setString(9, e.getDireccion());
            ps.setString(10, e.getMapasUrl());

            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Evento> listarEventos() {

    List<Evento> eventos = new ArrayList<>();
    String sql = "SELECT * FROM eventos";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            Evento e = new Evento();
            e.setIdEvento(rs.getInt("id_evento"));
            e.setTitulo(rs.getString("titulo"));
            e.setTipoEvento(rs.getString("tipo_evento"));
            e.setFechaEvento(rs.getDate("fecha_evento").toLocalDate());
            e.setHoraEvento(rs.getTime("hora_evento").toLocalTime());
            e.setSlug(rs.getString("slug"));
            e.setModelo(rs.getString("modelo"));

            eventos.add(e);
            
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return eventos;
}

}
