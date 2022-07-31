package com.Portfolio.Ariel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperienciaLaboral {

    @NotBlank
    private String nombre;
    @NotBlank
    private String lugar;
    @NotBlank
    private String fecha;
    @NotBlank
    private String tarea; 

    public dtoExperienciaLaboral() {
    }

    public dtoExperienciaLaboral(String nombre, String lugar, String fecha, String tarea) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.tarea = tarea;
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

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    
    
}
