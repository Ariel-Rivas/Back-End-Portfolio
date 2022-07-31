
package com.Portfolio.Ariel.Repository;


import com.Portfolio.Ariel.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IeducacionRepository extends JpaRepository <Educacion, Integer>{
     public Optional<Educacion> findByNombre(String nombre);
     public boolean existsByNombre(String nombre);
}
