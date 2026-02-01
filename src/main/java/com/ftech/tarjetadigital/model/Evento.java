package com.ftech.tarjetadigital.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Evento {

    private int idEvento;
    private int idCliente;
    private String titulo;
    private String tipoEvento;
    private LocalDate fechaEvento;
    private LocalTime horaEvento;
    private String slug;

    private ModeloEvento modelo;
    private EstadoEvento estado;

    private String mensajeBienvenida;
    private String direccion;
    private String mapasUrl;
    private LocalDateTime fechaCreacion;

    private boolean activo;
    private boolean eliminado;

    // GETTERS & SETTERS
    public int getIdEvento() { return idEvento; }
    public void setIdEvento(int idEvento) { this.idEvento = idEvento; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipoEvento() { return tipoEvento; }
    public void setTipoEvento(String tipoEvento) { this.tipoEvento = tipoEvento; }

    public LocalDate getFechaEvento() { return fechaEvento; }
    public void setFechaEvento(LocalDate fechaEvento) { this.fechaEvento = fechaEvento; }

    public LocalTime getHoraEvento() { return horaEvento; }
    public void setHoraEvento(LocalTime horaEvento) { this.horaEvento = horaEvento; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public ModeloEvento getModelo() { return modelo; }
    public void setModelo(ModeloEvento modelo) { this.modelo = modelo; }

    public EstadoEvento getEstado() { return estado; }
    public void setEstado(EstadoEvento estado) { this.estado = estado; }

    public String getMensajeBienvenida() { return mensajeBienvenida; }
    public void setMensajeBienvenida(String mensajeBienvenida) { this.mensajeBienvenida = mensajeBienvenida; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getMapasUrl() { return mapasUrl; }
    public void setMapasUrl(String mapasUrl) { this.mapasUrl = mapasUrl; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public boolean isEliminado() { return eliminado; }
    public void setEliminado(boolean eliminado) { this.eliminado = eliminado; }
}
