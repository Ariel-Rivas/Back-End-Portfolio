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
public class dtoTrabajo {

    @NotBlank
    private String nombre;

    @NotBlank
    private String comentario;
    @NotBlank
    private String posicion;
    @NotBlank
    private String foto;   

    public dtoTrabajo() {
    }

    public dtoTrabajo(String nombre, String comentario, String posicion, String foto) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.posicion = posicion;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
}
