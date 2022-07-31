
package com.Portfolio.Ariel.Dto;

import javax.validation.constraints.NotBlank;


public class dtoPersona {

    @NotBlank
    private String nombre;

    @NotBlank
    private String telefono;
    @NotBlank
    private String email;

    @NotBlank
    private String about;
    @NotBlank
    private String foto;
    @NotBlank
    private String direccion;
    @NotBlank
    private String CP;

    @NotBlank
    private String ciudad;  

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String telefono, String email, String about, String foto, String direccion, String CP, String ciudad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.about = about;
        this.foto = foto;
        this.direccion = direccion;
        this.CP = CP;
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

   
    
    
}
