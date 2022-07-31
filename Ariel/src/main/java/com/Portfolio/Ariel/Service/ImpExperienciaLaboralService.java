
package com.Portfolio.Ariel.Service;

import com.Portfolio.Ariel.Entity.ExperienciaLaboral;
import com.Portfolio.Ariel.Repository.IexperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpExperienciaLaboralService  {

    
    @Autowired IexperienciaLaboralRepository iexperienciaLaboralRepository; 
   
    public List<ExperienciaLaboral> list(){
         return iexperienciaLaboralRepository.findAll();
     }
     
     public Optional<ExperienciaLaboral> getOne(int id){
         return iexperienciaLaboralRepository.findById(id);
     }
     
     public Optional<ExperienciaLaboral> getByNombre(String nombre){
         return iexperienciaLaboralRepository.findByNombre(nombre);
     }
     
     public void save(ExperienciaLaboral expe){
         iexperienciaLaboralRepository.save(expe);
     }
     
     public void delete(int id){
         iexperienciaLaboralRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return iexperienciaLaboralRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return iexperienciaLaboralRepository.existsByNombre(nombre);
     }
}