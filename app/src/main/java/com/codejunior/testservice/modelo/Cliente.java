package com.codejunior.testservice.modelo;

public class Cliente {

    private String cedula;
    private String nombre;
    private String  categoria;
    private String sexo;

    public Cliente(String cedula, String nombre, String categoria, String sexo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.categoria = categoria;
        this.sexo = sexo;
    }

    public Cliente() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
