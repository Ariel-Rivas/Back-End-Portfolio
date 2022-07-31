
package com.Portfolio.Ariel.Service;


import com.Portfolio.Ariel.Entity.Persona;
import com.Portfolio.Ariel.Repository.IpersonaRepository;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ImpPersonaService {
    @Autowired IpersonaRepository ipersonaRepository;

    public List <Persona> list(){
        return ipersonaRepository.findAll();
    }
    
    public Optional<Persona> getOne (Long id){
        return ipersonaRepository.findById(id);
    }
    
    public Optional<Persona> getByNombre(String nombre){
        return ipersonaRepository.findByNombre(nombre);
    }
    
    public void save (Persona pers){
        ipersonaRepository.save(pers);
    } 
    public boolean existsById(Long id){
        return ipersonaRepository.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return ipersonaRepository.existsByNombre(nombre);
    }
}
    
   