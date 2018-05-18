package com.davidhenriquez.rehabilicop.listas.estado_civil;

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
@RequestMapping("/api/estados-civiles")
public class EstadoCivilController {

	@Autowired
	private EstadoCivilService estadoCivilService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getEstadosCiviles() {
    	try{
    		List<EstadoCivil> estadosCiviles = estadoCivilService.findAll();
    		return ResponseEntity.ok(estadosCiviles);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEstadoCivil(UUID id){
		try {
			EstadoCivil estadoCivil = estadoCivilService.findById(id);
			return ResponseEntity.ok(estadoCivil);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear estado civil')")
	public ResponseEntity<?> create(@RequestBody EstadoCivil estadoCivil) throws Exception {
		try {
			return ResponseEntity.ok(estadoCivilService.create(estadoCivil));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar estado civil')")
	public ResponseEntity<?> update(@RequestBody EstadoCivil estadoCivil) throws Exception {
		try {
			return ResponseEntity.ok(estadoCivilService.update(estadoCivil));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar estado civil')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			estadoCivilService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new EstadoCivil());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
