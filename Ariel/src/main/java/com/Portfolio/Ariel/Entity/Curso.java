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
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String nombre;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String lugar;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud ")
    private String fecha;

    public Curso() {
    }

    public Curso(String nombre, String lugar, String fecha) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
    }

  

    }

  
   


