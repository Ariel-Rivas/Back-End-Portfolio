package com.Portfolio.Ariel.Controller;

import com.Portfolio.Ariel.Dto.dtoCurso;
import com.Portfolio.Ariel.Entity.Curso;
import com.Portfolio.Ariel.SecurityController.Mensaje;
import com.Portfolio.Ariel.Service.ImpCursoService;
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
@RequestMapping("/curs")
@CrossOrigin(origins = "https://apparifront.web.app")
public class CursoController {

@Autowired ImpCursoService ipmCursoService;
    

    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> list(){
        List<Curso> list =  ipmCursoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id") int id){
        if(! ipmCursoService.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
       Curso curso =  ipmCursoService.getOne(id).get();
        return new ResponseEntity(curso, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (! ipmCursoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        ipmCursoService.delete(id);
        return new ResponseEntity(new Mensaje("Curso eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCurso dtocurs){      
        if(StringUtils.isBlank(dtocurs.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if( ipmCursoService.existsByNombre(dtocurs.getNombre())){
            return new ResponseEntity(new Mensaje("Ese curso existe"), HttpStatus.BAD_REQUEST);
        }
       Curso curso = new Curso(dtocurs.getNombre(), dtocurs.getLugar(),dtocurs.getFecha());
       ipmCursoService.save(curso);
        
        return new ResponseEntity(new Mensaje("Curso agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCurso dtocurs){
        //Validamos si existe el ID
        if(! ipmCursoService.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de experiencias
        if( ipmCursoService.existsByNombre(dtocurs.getNombre()) &&  ipmCursoService.getByNombre(dtocurs.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("El curso ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if(StringUtils.isBlank(dtocurs.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
       Curso curso = ipmCursoService.getOne(id).get();
        curso.setNombre(dtocurs.getNombre());
        curso.setLugar(dtocurs.getLugar());
        curso.setFecha((dtocurs.getFecha()));
       
        
      ipmCursoService.save(curso);
        return new ResponseEntity(new Mensaje("Curso actualizada"), HttpStatus.OK);
             
    }  
    
}  