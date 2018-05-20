package com.davidhenriquez.rehabilicop.listas.expresion_facial2;

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
@RequestMapping("/api/expresion-facial2")
public class ExpresionFacial2Controller {

	@Autowired
	private ExpresionFacial2Service expresionFacial2Service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getExpresionFacial2s() {
    	try{
    		List<ExpresionFacial2> expresionFacial2s = expresionFacial2Service.findAll();
    		return ResponseEntity.ok(expresionFacial2s);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getExpresionFacial2(UUID idExpresionFacial2){
		try {
			ExpresionFacial2 expresionFacial2 = expresionFacial2Service.findById(idExpresionFacial2);
			return ResponseEntity.ok(expresionFacial2);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear expresion facial2')")
	public ResponseEntity<?> create(@RequestBody ExpresionFacial2 expresionFacial2) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial2Service.create(expresionFacial2));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar expresion facial2')")
	public ResponseEntity<?> update(@RequestBody ExpresionFacial2 expresionFacial2) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial2Service.update(expresionFacial2));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar expresion facial2')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			expresionFacial2Service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ExpresionFacial2());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
