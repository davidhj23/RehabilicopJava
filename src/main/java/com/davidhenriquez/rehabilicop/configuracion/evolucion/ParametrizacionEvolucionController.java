package com.davidhenriquez.rehabilicop.configuracion.evolucion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

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

@RestController
@RequestMapping("/api/parametrizacion-evoluciones")
public class ParametrizacionEvolucionController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private ParametrizacionEvolucionService parametrizacionEvolucionService; 
    
    @RequestMapping(value = "/tipos-evoluciones", method = RequestMethod.GET)
    public ResponseEntity<?> getTiposEvolucones() {
    	try{
    		List<TipoEvolucion> tiposEvoluciones = parametrizacionEvolucionService.findAllTiposEvoluciones();
    		return ResponseEntity.ok(tiposEvoluciones);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
    	try{
    		List<ParametrizacionEvolucion> parametrizacionEvoluciones = parametrizacionEvolucionService.findAll();
    		return ResponseEntity.ok(parametrizacionEvoluciones);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear parametrizacion evolucion')")
	public ResponseEntity<?> create(@RequestBody ParametrizacionEvolucion parametrizacionEvolucion) throws Exception {
		try {
			return ResponseEntity.ok(parametrizacionEvolucionService.create(parametrizacionEvolucion));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar parametrizacion evolucion')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			parametrizacionEvolucionService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ParametrizacionEvolucion());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/anio/{anio}/mes/{mes}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('auditar')")
	public ResponseEntity<?> getAllEvoluciones(			
			@PathVariable int anio,
			@PathVariable int mes) throws Exception {
		try {			
			return ResponseEntity.ok(parametrizacionEvolucionService.getAllByAnioAndMes(anio, mes));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}