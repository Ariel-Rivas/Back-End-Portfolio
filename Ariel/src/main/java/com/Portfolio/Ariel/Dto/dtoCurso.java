package com.Portfolio.Ariel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoCurso {

    @NotBlank
    private String nombre;
    @NotBlank
    private String lugar;
    @NotBlank
    private String fecha;

    public dtoCurso(String nombre, String lugar, String fecha) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public dtoCurso() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
