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

import com.davidhenriquez.rehabilicop.business_logic.services.SedeService;
import com.davidhenriquez.rehabilicop.business_logic.services.RolService;
import com.davidhenriquez.rehabilicop.business_logic.services.TipoDocumentoService;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.data_access.domain.Sede;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.domain.TipoDocumento;
import com.davidhenriquez.rehabilicop.presentation.config.JwtTokenUtil;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

	@Autowired
	private SedeService sedeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getSede() {
    	try{
    		List<Sede> sedes = sedeService.findAll();
    		return ResponseEntity.ok(sedes);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSede(Long idSede){
		try {
			Sede sede = sedeService.findById(idSede);
			return ResponseEntity.ok(sede);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear sede')")
	public ResponseEntity<?> create(@RequestBody Sede sede) throws Exception {
		try {
			return ResponseEntity.ok(sedeService.create(sede));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar sede')")
	public ResponseEntity<?> update(@RequestBody Sede sede) throws Exception {
		try {
			return ResponseEntity.ok(sedeService.update(sede));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar sede')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			sedeService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Sede());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
