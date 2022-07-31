
package com.Portfolio.Ariel.Security.Repository;

import com.Portfolio.Ariel.Security.Entity.Rol;
import com.Portfolio.Ariel.Security.Enum.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol,Integer>{
   Optional<Rol>  findByRolNombre(RolNombre rolNombre);
}
