
package com.Portfolio.Ariel.Service;


import com.Portfolio.Ariel.Entity.Curso;
import com.Portfolio.Ariel.Repository.IcursoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class ImpCursoService {
    
      @Autowired IcursoRepository icursoRepository; 
   
      public List<Curso> list(){
         return icursoRepository.findAll();
     }
     
     public Optional<Curso> getOne(int id){
         return icursoRepository.findById(id);
     }
     
     public Optional<Curso> getByNombre(String nombre){
         return icursoRepository.findByNombre(nombre);
     }
     
     public void save(Curso curs){
         icursoRepository.save(curs);
     }
     
     public void delete(int id){
         icursoRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return icursoRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return icursoRepository.existsByNombre(nombre);
     }
}