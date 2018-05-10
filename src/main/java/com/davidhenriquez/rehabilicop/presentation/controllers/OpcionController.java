package com.davidhenriquez.rehabilicop.presentation.controllers;

import java.util.List;

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

import com.davidhenriquez.rehabilicop.business_logic.services.OpcionService;
import com.davidhenriquez.rehabilicop.business_logic.services.RolService;
import com.davidhenriquez.rehabilicop.business_logic.services.TipoDocumentoService;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.data_access.domain.Opcion;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.domain.TipoDocumento;
import com.davidhenriquez.rehabilicop.presentation.config.JwtTokenUtil;

@RestController
@RequestMapping("/api/opciones")
public class OpcionController {

	@Autowired
	private OpcionService opcionService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getOpcion() {
    	try{
    		List<Opcion> opciones = opcionService.findAll();
    		return ResponseEntity.ok(opciones);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOpcion(Long idOpcion){
		try {
			Opcion opcion = opcionService.findById(idOpcion);
			return ResponseEntity.ok(opcion);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear opcion')")
	public ResponseEntity<?> create(@RequestBody Opcion opcion) throws Exception {
		try {
			return ResponseEntity.ok(opcionService.create(opcion));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar opcion')")
	public ResponseEntity<?> update(@RequestBody Opcion opcion) throws Exception {
		try {
			return ResponseEntity.ok(opcionService.update(opcion));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar opcion')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			opcionService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Opcion());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
