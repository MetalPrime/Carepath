package com.example.carepath;

public class Inquilino {

    private String id;
    private String nombre;
    private String numero;
    private String tipoIdentificacion;
    private String identificacion;
    private String torre;
    private String departamento;
    private String userName;

    public Inquilino() {
    }

    public Inquilino(String id, String nombre, String numero, String tipoIdentificacion, String identificacion, String torre, String departamento, String userName) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.torre = torre;
        this.departamento = departamento;
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

