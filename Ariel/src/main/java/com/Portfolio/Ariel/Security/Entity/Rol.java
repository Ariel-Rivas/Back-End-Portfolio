

package com.Portfolio.Ariel.Security.Entity;

import com.Portfolio.Ariel.Security.Enum.RolNombre;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Rol { 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    @NotNull 
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre; 

    public Rol() {
    }

    public Rol(int id, RolNombre rolNombre) {
      
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
}
