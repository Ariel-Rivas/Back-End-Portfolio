package com.Portfolio.Ariel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String nombre;

    @NotNull

    private String comentario;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String posicion;

    @NotNull

    private String foto;

    public Trabajo(String nombre, String comentario, String posicion, String foto) {

        this.nombre = nombre;
        this.comentario = comentario;
        this.posicion = posicion;
        this.foto = foto;
    }

    public Trabajo() {
    }

}
