package com.Portfolio.Ariel.Service;

import com.Portfolio.Ariel.Entity.Educacion;
import com.Portfolio.Ariel.Repository.IeducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class ImpEducacionService  {

    @Autowired
    IeducacionRepository ieducacionRepository;

     public List<Educacion> list(){
         return ieducacionRepository.findAll();
     }
     
     public Optional<Educacion> getOne(int id){
         return ieducacionRepository.findById(id);
     }
     
     public Optional<Educacion> getByNombre(String nombre){
         return ieducacionRepository.findByNombre(nombre);
     }
     
     public void save(Educacion educ){
         ieducacionRepository.save(educ);
     }
     
     public void delete(int id){
        ieducacionRepository.deleteById(id);
     }
     
     public boolean existsById(int id){
         return ieducacionRepository.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return ieducacionRepository.existsByNombre(nombre);
     }
}