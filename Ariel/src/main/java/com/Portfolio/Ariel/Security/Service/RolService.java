
package com.Portfolio.Ariel.Security.Service;

import com.Portfolio.Ariel.Security.Entity.Rol;
import com.Portfolio.Ariel.Security.Enum.RolNombre;
import com.Portfolio.Ariel.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
@Transactional
public class RolService {
   
    
    @Autowired 
    iRolRepository irolRepository; 
    
    
    public Optional<Rol> getByRolNombe(RolNombre rolNombre){
    return irolRepository.findByRolNombre(rolNombre);
    
} 
    
    public void save(Rol rol){
        
        irolRepository.save(rol);
    }
}