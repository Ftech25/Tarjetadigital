package com.ftech.tarjetadigital.dao;

import com.ftech.tarjetadigital.config.ConexionBD;
import com.ftech.tarjetadigital.model.Evento;
import com.ftech.tarjetadigital.model.ModeloEvento;
import com.ftech.tarjetadigital.model.EstadoEvento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

// =========================
// EVENTO DAO
// =========================
public class EventoDAO {

    // =========================
    // CREAR EVENTOO
    // =========================
    public boolean crearEvento(Evento e) {

        String sql = "INSERT INTO eventos "
                + "(id_cliente, titulo, tipo_evento, fecha_evento, hora_evento, slug, modelo, "
                + "mensaje_bienvenida, direccion, mapas_url, estado, activo, eliminado) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, e.getIdCliente());
            ps.setString(2, e.getTitulo());
            ps.setString(3, e.getTipoEvento());
            ps.setDate(4, Date.valueOf(e.getFechaEvento()));
            ps.setTime(5, Time.valueOf(e.getHoraEvento()));
            ps.setString(6, e.getSlug());
            ps.setString(7, e.getModelo().name());
            ps.setString(8, e.getMensajeBienvenida());
            ps.setString(9, e.getDireccion());
            ps.setString(10, e.getMapasUrl());
            ps.setString(11, e.getEstado().name());
            ps.setBoolean(12, e.isActivo());
            ps.setBoolean(13, e.isEliminado());

            return ps.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // =========================
    // ACTUALIZAR EVENTO
    // =========================
    public boolean actualizarEvento(Evento e) {

        String sql = "UPDATE eventos SET "
                + "titulo = ?, "
                + "tipo_evento = ?, "
                + "fecha_evento = ?, "
                + "hora_evento = ?, "
                + "modelo = ?, "
                + "mensaje_bienvenida = ?, "
                + "direccion = ?, "
                + "mapas_url = ? "
                + "WHERE id_evento = ?";

        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, e.getTitulo());
            ps.setString(2, e.getTipoEvento());
            ps.setDate(3, java.sql.Date.valueOf(e.getFechaEvento()));
            ps.setTime(4, java.sql.Time.valueOf(e.getHoraEvento()));
            ps.setString(5, e.getModelo().name());
            ps.setString(6, e.getMensajeBienvenida());
            ps.setString(7, e.getDireccion());
            ps.setString(8, e.getMapasUrl());
            ps.setInt(9, e.getIdEvento());

            return ps.executeUpdate() > 0;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // =========================
    // LISTAR EVENTOS
    // =========================
    public List<Evento> listarEventos() {

        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM eventos WHERE eliminado = 0 ORDER BY fecha_evento DESC";

        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                eventos.add(mapEvento(rs));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return eventos;
    }

    // =========================
    // BUSCAR POR ID
    // =========================
    public Evento buscarPorId(int id) {

    String sql = "SELECT * FROM eventos WHERE id_evento = ?";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return mapEvento(rs);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }

    return null;
}

    // =========================
    // BUSCAR POR SLUG
    // =========================
    public Evento buscarPorSlug(String slug) {

    String sql = "SELECT * FROM eventos WHERE slug = ? AND activo = 1 AND eliminado = 0";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, slug);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return mapEvento(rs); // 👈 CLAVE
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}


    // =========================
    // SI EXISTE SLUG
    // =========================
    
    public boolean existeSlug(String slug) {

    String sql = "SELECT COUNT(*) FROM eventos WHERE slug = ?";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, slug);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) > 0;
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

   



    // =========================
// CAMBIAR ESTADO ACTIVO
// =========================
    public boolean cambiarEstado(int idEvento) {

        String sql = "UPDATE eventos SET activo = NOT activo WHERE id_evento = ?";

        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEvento);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // SOFT DELETE
    // =========================
    public boolean eliminarLogico(int idEvento) {

        String sql = "UPDATE eventos SET eliminado = 1 WHERE id_evento = ?";

        try (Connection con = ConexionBD.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEvento);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // =========================
    // MAPEAR EVENTO
    // =========================
    private Evento mapEvento(ResultSet rs) throws SQLException {
        Evento e = new Evento();
        e.setIdEvento(rs.getInt("id_evento"));
        e.setIdCliente(rs.getInt("id_cliente"));
        e.setTitulo(rs.getString("titulo"));
        e.setTipoEvento(rs.getString("tipo_evento"));
        e.setFechaEvento(rs.getDate("fecha_evento").toLocalDate());
        e.setHoraEvento(rs.getTime("hora_evento").toLocalTime());
        e.setSlug(rs.getString("slug"));
        e.setModelo(ModeloEvento.valueOf(rs.getString("modelo")));
        e.setMensajeBienvenida(rs.getString("mensaje_bienvenida"));
        e.setDireccion(rs.getString("direccion"));
        e.setMapasUrl(rs.getString("mapas_url"));
        e.setEstado(EstadoEvento.valueOf(rs.getString("estado")));
        e.setActivo(rs.getBoolean("activo"));
        e.setEliminado(rs.getBoolean("eliminado"));
        e.setFechaCreacion(rs.getTimestamp("fecha_creacion").toLocalDateTime());
        return e;
    }

}
