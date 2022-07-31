
package com.Portfolio.Ariel.Security.Service;

import com.Portfolio.Ariel.Security.Entity.Usuario;
import com.Portfolio.Ariel.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
  
    @Autowired 
    iUsuarioRepository   iusuarioRepository; 
    
    public Optional <Usuario> getByNombreUsuario(String nombreUsuario){
        
       return iusuarioRepository.findByNombreUsuario(nombreUsuario);  
        
    }  
    
    public boolean existsByNombreUsuario(String nombreUsuario){
        
        return iusuarioRepository.existsBynombreUsuario(nombreUsuario); 
    } 
    
     public boolean existsByEmail(String email){
        
        return iusuarioRepository.existsByEmail(email); 
} 
     public void save(Usuario usuario){
         iusuarioRepository.save(usuario); 
     }
     
    
} 