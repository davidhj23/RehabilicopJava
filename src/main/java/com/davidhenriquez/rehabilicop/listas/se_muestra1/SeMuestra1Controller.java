package com.davidhenriquez.rehabilicop.listas.se_muestra1;

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
@RequestMapping("/api/se-muestra1")
public class SeMuestra1Controller {

	@Autowired
	private SeMuestra1Service seMuestra1Service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getSeMuestra1s() {
    	try{
    		List<SeMuestra1> seMuestra1s = seMuestra1Service.findAll();
    		return ResponseEntity.ok(seMuestra1s);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getSeMuestra1(UUID idSeMuestra1){
		try {
			SeMuestra1 seMuestra1 = seMuestra1Service.findById(idSeMuestra1);
			return ResponseEntity.ok(seMuestra1);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear se muestra1')")
	public ResponseEntity<?> create(@RequestBody SeMuestra1 seMuestra1) throws Exception {
		try {
			return ResponseEntity.ok(seMuestra1Service.create(seMuestra1));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar se muestra1')")
	public ResponseEntity<?> update(@RequestBody SeMuestra1 seMuestra1) throws Exception {
		try {
			return ResponseEntity.ok(seMuestra1Service.update(seMuestra1));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar se muestra1')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			seMuestra1Service.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new SeMuestra1());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
