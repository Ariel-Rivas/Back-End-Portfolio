
package com.Portfolio.Ariel.Security.Repository;

import com.Portfolio.Ariel.Security.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUsuarioRepository extends JpaRepository<Usuario, Integer>{
  Optional<Usuario>  findByNombreUsuario(String nombreUsuario);
  
  boolean existsBynombreUsuario(String nombreUsuario);
  boolean existsByEmail(String email);
}
