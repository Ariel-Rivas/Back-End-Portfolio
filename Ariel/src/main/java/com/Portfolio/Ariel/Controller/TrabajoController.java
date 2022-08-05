package com.Portfolio.Ariel.Controller;

import com.Portfolio.Ariel.Dto.dtoTrabajo;
import com.Portfolio.Ariel.Entity.Trabajo;
import com.Portfolio.Ariel.SecurityController.Mensaje;
import com.Portfolio.Ariel.Service.ImpTrabajoService;
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
@RequestMapping("/trab")
@CrossOrigin(origins = "https://apparifront.web.app")
public class TrabajoController {

    @Autowired ImpTrabajoService imptrabajoService;
    

  @GetMapping("/lista")
    public ResponseEntity<List<Trabajo>> list(){
        List<Trabajo> list =  imptrabajoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Trabajo> getById(@PathVariable("id") int id){
        if( imptrabajoService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
       Trabajo trabajo =  imptrabajoService.getOne(id).get();
        return new ResponseEntity(trabajo, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (! imptrabajoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
       imptrabajoService.delete(id);
        return new ResponseEntity(new Mensaje("Trabajo eliminada"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoTrabajo dtotrab){      
        if(StringUtils.isBlank(dtotrab.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if( imptrabajoService.existsByNombre(dtotrab.getNombre())){
            return new ResponseEntity(new Mensaje("Ese trabajo existe"), HttpStatus.BAD_REQUEST);
        }
       Trabajo trabajo = new Trabajo(dtotrab.getNombre(), dtotrab.getComentario(),dtotrab.getPosicion(),dtotrab.getFoto());
     imptrabajoService.save(trabajo);
        
        return new ResponseEntity(new Mensaje("Trabajo agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoTrabajo dtotrab){
        //Validamos si existe el ID
        if(!  imptrabajoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if( imptrabajoService.existsByNombre(dtotrab.getNombre()) &&   imptrabajoService.getByNombre(dtotrab.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El trabajo  ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(dtotrab.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
      Trabajo trabajo = imptrabajoService.getOne(id).get();
        trabajo.setNombre(dtotrab.getNombre());
        trabajo.setComentario(dtotrab.getComentario());
        trabajo.setPosicion(dtotrab.getPosicion());
        trabajo.setFoto((dtotrab.getFoto()));
       
        
      imptrabajoService.save(trabajo);
        return new ResponseEntity(new Mensaje("Trabajo actualizada"), HttpStatus.OK);
             
    }  
    
}  