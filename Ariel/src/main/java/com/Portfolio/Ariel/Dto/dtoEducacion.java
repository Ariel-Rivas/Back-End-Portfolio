/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Portfolio.Ariel.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author ariel
 */
public class dtoEducacion {

    @NotBlank
    private String nombre;
    @NotBlank
    private String lugar;
    @NotBlank
    private String estado;

    public dtoEducacion() {
    }

    public dtoEducacion(String nombre, String lugar, String estado) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
