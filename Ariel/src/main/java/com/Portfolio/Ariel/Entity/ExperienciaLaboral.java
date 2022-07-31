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
public class ExperienciaLaboral {

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

    @NotNull
   
    private String tarea;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(String nombre, String lugar, String fecha, String tarea) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.tarea = tarea;
    }

    
    
    }


