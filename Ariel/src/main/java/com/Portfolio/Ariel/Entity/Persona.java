package com.Portfolio.Ariel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity 
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String telefono;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String email;

    @NotNull
    @Size(min = 1, max = 2000, message = "No cumple con la longitud ")
    private String about;

    @NotNull
    @Size(min = 1, max = 200, message = "No cumple con la longitud ")
    private String foto;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String direccion;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String CP;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String ciudad;

    public Persona() {
    }

    public Persona(String nombre, String telefono, String email, String about, String foto, String direccion, String CP, String ciudad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.about = about;
        this.foto = foto;
        this.direccion = direccion;
        this.CP = CP;
        this.ciudad = ciudad;
    }

}