package com.davidhenriquez.rehabilicop.listas.estado_conciencia;

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
@RequestMapping("/api/estados-conciencias")
public class EstadoConcienciaController {

	@Autowired
	private EstadoConcienciaService estadoConcienciaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getEstadosConcienciaes() {
    	try{
    		List<EstadoConciencia> estadosConciencia = estadoConcienciaService.findAll();
    		return ResponseEntity.ok(estadosConciencia);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEstadoConciencia(UUID id){
		try {
			EstadoConciencia estadoConciencia = estadoConcienciaService.findById(id);
			return ResponseEntity.ok(estadoConciencia);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear estado conciencia')")
	public ResponseEntity<?> create(@RequestBody EstadoConciencia estadoConciencia) throws Exception {
		try {
			return ResponseEntity.ok(estadoConcienciaService.create(estadoConciencia));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar estado conciencia')")
	public ResponseEntity<?> update(@RequestBody EstadoConciencia estadoConciencia) throws Exception {
		try {
			return ResponseEntity.ok(estadoConcienciaService.update(estadoConciencia));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar estado conciencia')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			estadoConcienciaService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new EstadoConciencia());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
