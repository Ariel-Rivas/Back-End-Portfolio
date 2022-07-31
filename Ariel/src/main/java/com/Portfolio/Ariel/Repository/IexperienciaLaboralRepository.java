
package com.Portfolio.Ariel.Repository;

import com.Portfolio.Ariel.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IexperienciaLaboralRepository extends JpaRepository <ExperienciaLaboral,Integer>{
   
     public Optional<ExperienciaLaboral> findByNombre(String nombre);
     public boolean existsByNombre(String nombre);
 
}
