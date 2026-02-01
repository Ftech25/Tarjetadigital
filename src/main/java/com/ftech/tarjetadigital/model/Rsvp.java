package com.ftech.tarjetadigital.model;

import java.time.LocalDateTime;

public class Rsvp {

    private int idRsvp;
    private int idEvento;
    private int idInvitado;
    private String asiste;
    private int acompanantes;
    private String restricciones;
    private String cancion;
    private String comentario;
    private LocalDateTime fechaRespuesta;

    // =========================
    // GETTERS Y SETTERS
    // =========================

    public int getIdRsvp() {
        return idRsvp;
    }

    public void setIdRsvp(int idRsvp) {
        this.idRsvp = idRsvp;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public String getAsiste() {
        return asiste;
    }

    public void setAsiste(String asiste) {
        this.asiste = asiste;
    }

    public int getAcompanantes() {
        return acompanantes;
    }

    public void setAcompanantes(int acompanantes) {
        this.acompanantes = acompanantes;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getCancion() {
        return cancion;
    }

    public void setCancion(String cancion) {
        this.cancion = cancion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaRespuesta() {
        return fechaRespuesta;
    }

    public void setFechaRespuesta(LocalDateTime fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
}
