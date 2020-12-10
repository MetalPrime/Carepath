package com.example.carepath;

public class Administrador {

    private String id;
    private String nombre;
    private String numero;
    private String estado;
    private String identificacion;

    public Administrador() {
    }

    public Administrador(String id, String nombre, String numero, String estado, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.estado = estado;
        this.identificacion = identificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
