package com.davidhenriquez.rehabilicop.listas.expresion_facial3;

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
@RequestMapping("/api/expresion-facial3")
public class ExpresionFacial3Controller {

	@Autowired
	private ExpresionFacial3Service expresionFacial3Service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getExpresionFacial3s() {
    	try{
    		List<ExpresionFacial3> expresionFacial3s = expresionFacial3Service.findAll();
    		return ResponseEntity.ok(expresionFacial3s);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getExpresionFacial3(UUID idExpresionFacial3){
		try {
			ExpresionFacial3 expresionFacial3 = expresionFacial3Service.findById(idExpresionFacial3);
			return ResponseEntity.ok(expresionFacial3);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear expresion facial3')")
	public ResponseEntity<?> create(@RequestBody ExpresionFacial3 expresionFacial3) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial3Service.create(expresionFacial3));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar expresion facial3')")
	public ResponseEntity<?> update(@RequestBody ExpresionFacial3 expresionFacial3) throws Exception {
		try {
			return ResponseEntity.ok(expresionFacial3Service.update(expresionFacial3));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar expresion facial3')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			expresionFacial3Service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ExpresionFacial3());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
