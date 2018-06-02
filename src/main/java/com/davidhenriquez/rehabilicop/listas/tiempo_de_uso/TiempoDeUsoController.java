package com.davidhenriquez.rehabilicop.listas.tiempo_de_uso;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
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
import com.davidhenriquez.rehabilicop.listas.tiempo_de_uso.TiempoDeUso;
import com.davidhenriquez.rehabilicop.listas.tiempo_de_uso.TiempoDeUsoService;
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumento;
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumentoService;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolService;

@RestController
@RequestMapping("/api/tiempos-de-usos")
public class TiempoDeUsoController {
	
	@Autowired
	private TiempoDeUsoService tiempoDeUsoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTiempoDeUsos() {
    	try{
    		List<TiempoDeUso> tiemposDeUsos = tiempoDeUsoService.findAll();
    		return ResponseEntity.ok(tiemposDeUsos);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTiempoDeUso(UUID id){
		try {
			TiempoDeUso tiempoDeUso = tiempoDeUsoService.findById(id);
			return ResponseEntity.ok(tiempoDeUso);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear tiempo de uso')")
	public ResponseEntity<?> create(@RequestBody TiempoDeUso tiempoDeUso) throws Exception {
		try {
			return ResponseEntity.ok(tiempoDeUsoService.create(tiempoDeUso));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar tiempo de uso')")
	public ResponseEntity<?> update(@RequestBody TiempoDeUso tiempoDeUso) throws Exception {
		try {
			return ResponseEntity.ok(tiempoDeUsoService.update(tiempoDeUso));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar tiempo de uso')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			tiempoDeUsoService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new TiempoDeUso());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
