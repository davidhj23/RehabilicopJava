package com.davidhenriquez.rehabilicop.listas.expresion_facial1;

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
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumento;
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumentoService;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolService;

@RestController
@RequestMapping("/api/expresion-facial1")
public class ExpresionFacial1Controller {

	@Autowired
	private ExpresionFacial1Service expresionFacial1Service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getExpresionFacial1s() {
    	try{
    		List<ExpresionFacial1> expresionFacial1s = expresionFacial1Service.findAll();
    		return ResponseEntity.ok(expresionFacial1s);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getExpresionFacial1(UUID idExpresionFacial1){
		try {
			ExpresionFacial1 expresionFacial1 = expresionFacial1Service.findById(idExpresionFacial1);
			return ResponseEntity.ok(expresionFacial1);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear expresion facial1')")
	public ResponseEntity<?> create(@RequestBody ExpresionFacial1 expresionFacial1) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial1Service.create(expresionFacial1));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar expresion facial1')")
	public ResponseEntity<?> update(@RequestBody ExpresionFacial1 expresionFacial1) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial1Service.update(expresionFacial1));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar expresion facial1')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			expresionFacial1Service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ExpresionFacial1());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
