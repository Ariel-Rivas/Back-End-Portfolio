
package com.Portfolio.Ariel.Controller;



import com.Portfolio.Ariel.Dto.dtoPersona;
import com.Portfolio.Ariel.Entity.Persona;
import com.Portfolio.Ariel.SecurityController.Mensaje;
import com.Portfolio.Ariel.Service.ImpPersonaService;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
@RequestMapping("/perso")

public class PersonaController {
    @Autowired ImpPersonaService impPersonaService;
    
     @GetMapping("/lista")
    public ResponseEntity<List< Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = impPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
   

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopers) {
        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impPersonaService.existsByNombre(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa persona existe"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = new Persona(dtopers.getNombre(), dtopers.getTelefono(), dtopers.getEmail(), dtopers.getAbout(), dtopers.getFoto(), dtopers.getDireccion(),dtopers.getCP(),dtopers.getCiudad());
        impPersonaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona agregada!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoPersona dtopers) {
        //validamos ID
        if (! impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombres de experiencias
        if ( impPersonaService.existsByNombre(dtopers.getNombre()) &&  !Objects.equals(impPersonaService.getByNombre(dtopers.getNombre()).get().getId(), id)) {
            return new ResponseEntity(new Mensaje("Esa Persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        // no puede estar vacio
        if (StringUtils.isBlank(dtopers.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona =  impPersonaService.getOne(id).get();
        persona.setNombre(dtopers.getNombre());
        persona.setTelefono(dtopers.getTelefono());
        persona.setEmail(dtopers.getEmail());
        persona.setAbout(dtopers.getAbout());
        persona.setFoto(dtopers.getFoto());
        persona.setDireccion(dtopers.getDireccion());
        persona.setCP(dtopers.getCP());
        persona.setCiudad(dtopers.getCiudad());

      impPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizado"), HttpStatus.OK);
    }

}
