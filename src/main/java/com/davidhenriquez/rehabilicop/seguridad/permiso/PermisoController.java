package com.davidhenriquez.rehabilicop.seguridad.permiso;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

	@Autowired
	private PermisoService permisoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getPermisos() {
    	try{
    		List<Permiso> permisos = permisoService.findAll();
    		return ResponseEntity.ok(permisos);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
}
