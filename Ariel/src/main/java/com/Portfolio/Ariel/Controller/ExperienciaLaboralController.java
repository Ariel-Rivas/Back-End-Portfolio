
package com.Portfolio.Ariel.Controller;



import com.Portfolio.Ariel.Dto.dtoExperienciaLaboral;
import com.Portfolio.Ariel.Entity.ExperienciaLaboral;
import com.Portfolio.Ariel.SecurityController.Mensaje;
import com.Portfolio.Ariel.Service.ImpExperienciaLaboralService;
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
@RequestMapping("/explab")
@CrossOrigin(origins = "https://apparifront.web.app")
public class ExperienciaLaboralController { 
    
@Autowired ImpExperienciaLaboralService impexperienciaLaboralService;
    

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = impexperienciaLaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") int id){
        if(impexperienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experienciaLaboral = impexperienciaLaboralService.getOne(id).get();
        return new ResponseEntity(experienciaLaboral, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impexperienciaLaboralService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
       impexperienciaLaboralService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperienciaLaboral dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(impexperienciaLaboralService.existsByNombre(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral(dtoexp.getNombre(), dtoexp.getLugar(),dtoexp.getFecha(),dtoexp.getTarea());
       impexperienciaLaboralService.save(experienciaLaboral);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperienciaLaboral dtoexp){
        //Validamos si existe el ID
        if(! impexperienciaLaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if( impexperienciaLaboralService.existsByNombre(dtoexp.getNombre()) &&  impexperienciaLaboralService.getByNombre(dtoexp.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        ExperienciaLaboral experienciaLaboral = impexperienciaLaboralService.getOne(id).get();
        experienciaLaboral.setNombre(dtoexp.getNombre());
        experienciaLaboral.setLugar(dtoexp.getLugar());
        experienciaLaboral.setFecha(dtoexp.getFecha());
        experienciaLaboral.setTarea((dtoexp.getTarea()));
        
       impexperienciaLaboralService.save(experienciaLaboral);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }  
    
}