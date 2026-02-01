package com.ftech.tarjetadigital.dao;

import com.ftech.tarjetadigital.config.ConexionBD;
import com.ftech.tarjetadigital.model.Rsvp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RsvpDAO {

    public List<Rsvp> listarPorEvento(int idEvento) {

        List<Rsvp> lista = new ArrayList<>();

        String sql = "SELECT * FROM rsvp WHERE id_evento = ? ORDER BY fecha_respuesta DESC";

        try (Connection con = ConexionBD.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Rsvp r = new Rsvp();
                r.setIdRsvp(rs.getInt("id_rsvp"));
                r.setIdEvento(rs.getInt("id_evento"));
                r.setAsiste(rs.getString("asiste"));
                r.setAcompanantes(rs.getInt("acompanantes"));
                r.setRestricciones(rs.getString("restricciones_alimentarias"));
                r.setCancion(rs.getString("cancion_sugerida"));
                r.setComentario(rs.getString("comentario"));

                if (rs.getTimestamp("fecha_respuesta") != null) {
                    r.setFechaRespuesta(
                        rs.getTimestamp("fecha_respuesta").toLocalDateTime()
                    );
                }

                lista.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public boolean guardar(Rsvp r) {

    String sql = "INSERT INTO rsvp "
               + "(id_evento, asiste, acompanantes, cancion_sugerida, comentario, fecha_respuesta) "
               + "VALUES (?, ?, ?, ?, ?, NOW())";

    try (Connection con = ConexionBD.getConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setInt(1, r.getIdEvento());
        ps.setString(2, r.getAsiste());
        ps.setInt(3, r.getAcompanantes());
        ps.setString(4, r.getCancion());
        ps.setString(5, r.getComentario());

        return ps.executeUpdate() > 0;

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

}
