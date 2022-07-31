
package com.Portfolio.Ariel.Repository;

import com.Portfolio.Ariel.Entity.Trabajo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItrabajoRepository extends JpaRepository <Trabajo, Integer>{
  
    public Optional<Trabajo> findByNombre(String nombre);
    public boolean existsByNombre(String nombre); 
    
    
}
