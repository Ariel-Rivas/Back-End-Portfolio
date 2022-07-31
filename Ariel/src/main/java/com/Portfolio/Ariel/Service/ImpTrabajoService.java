
package com.Portfolio.Ariel.Service;


import com.Portfolio.Ariel.Entity.Trabajo;
import com.Portfolio.Ariel.Repository.ItrabajoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class ImpTrabajoService {
   @Autowired ItrabajoRepository itrabajoRepository; 
    public List<Trabajo> list(){
         return itrabajoRepository.findAll();
     }
     
     public Optional<Trabajo> getOne(int id){
         return itrabajoRepository.findById(id);
     }
     
     public Optional<Trabajo> getByNombre(String nombre){
         return itrabajoRepository.findByNombre(nombre);
     }
     
     public void save(Trabajo trab){
        itrabajoRepository.save(trab);
     }
     
     public void delete(int id){
         itrabajoRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return itrabajoRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return itrabajoRepository.existsByNombre(nombre);
     }
}