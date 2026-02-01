package com.ftech.tarjetadigital.model;

import java.time.LocalDateTime;

public class Rsvp {
    private int idRsvp;
    private int idEvento;
    private String asiste;
    private int acompanantes;
    private String restricciones;
    private String cancion;
    private String comentario;
    private LocalDateTime fechaRespuesta;

    // NUEVO CAMPO para el JSP
    private String fechaRespuestaString;

    // Getters y Setters existentes...
    public LocalDateTime getFechaRespuesta() { return fechaRespuesta; }
    public void setFechaRespuesta(LocalDateTime fechaRespuesta) { this.fechaRespuesta = fechaRespuesta; }

    // Nuevo getter/setter
    public String getFechaRespuestaString() { return fechaRespuestaString; }
    public void setFechaRespuestaString(String fechaRespuestaString) { this.fechaRespuestaString = fechaRespuestaString; }

    // resto de getters y setters...

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
}
