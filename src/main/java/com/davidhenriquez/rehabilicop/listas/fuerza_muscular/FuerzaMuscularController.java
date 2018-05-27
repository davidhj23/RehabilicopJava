package com.davidhenriquez.rehabilicop.listas.fuerza_muscular;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.rehabilicop.core.config.JwtTokenUtil;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

@RestController
@RequestMapping("/api/fuerza-muscular")
public class FuerzaMuscularController {

	@Autowired
	private FuerzaMuscularService fuerzaMuscularService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getFuerzasMusculales() {
    	try{
    		List<FuerzaMuscular> fuerzasMusculales = fuerzaMuscularService.findAll();
    		return ResponseEntity.ok(fuerzasMusculales);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getFuerzaMuscular(UUID id){
		try {
			FuerzaMuscular fuerzaMuscular = fuerzaMuscularService.findById(id);
			return ResponseEntity.ok(fuerzaMuscular);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear fuerza muscular')")
	public ResponseEntity<?> create(@RequestBody FuerzaMuscular fuerzaMuscular) throws Exception {
		try {
			return ResponseEntity.ok(fuerzaMuscularService.create(fuerzaMuscular));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar fuerza muscular')")
	public ResponseEntity<?> update(@RequestBody FuerzaMuscular fuerzaMuscular) throws Exception {
		try {
			return ResponseEntity.ok(fuerzaMuscularService.update(fuerzaMuscular));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar fuerza muscular')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			fuerzaMuscularService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new FuerzaMuscular());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
