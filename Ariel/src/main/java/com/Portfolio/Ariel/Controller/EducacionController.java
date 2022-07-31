
package com.Portfolio.Ariel.Controller;


import com.Portfolio.Ariel.Dto.dtoEducacion;
import com.Portfolio.Ariel.Entity.Educacion;
import com.Portfolio.Ariel.SecurityController.Mensaje;
import com.Portfolio.Ariel.Service.ImpEducacionService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educ")
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {
 
    @Autowired ImpEducacionService impeducacionService;
    

   @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list =  impeducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if( impeducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
       Educacion educacion =  impeducacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (! impeducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        impeducacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoeduc){      
        if(StringUtils.isBlank(dtoeduc.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if( impeducacionService.existsByNombre(dtoeduc.getNombre()))
            return new ResponseEntity(new Mensaje("Esa educacion existe"), HttpStatus.BAD_REQUEST);
        
       Educacion educacion = new Educacion(dtoeduc.getNombre(), dtoeduc.getLugar(),dtoeduc.getEstado());
       impeducacionService.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeduc){
        //Validamos si existe el ID
        if(! impeducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if( impeducacionService.existsByNombre(dtoeduc.getNombre()) &&  impeducacionService.getByNombre(dtoeduc.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("La educacion  ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoeduc.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
       Educacion educacion = impeducacionService.getOne(id).get();
        educacion.setNombre(dtoeduc.getNombre());
        educacion.setLugar(dtoeduc.getLugar());
        educacion.setEstado((dtoeduc.getEstado()));
       
        
      impeducacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }  
    
}  