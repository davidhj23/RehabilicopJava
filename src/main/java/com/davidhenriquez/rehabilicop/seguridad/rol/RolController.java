package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.ArrayList;
import java.util.Collection;
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
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.seguridad.permiso.Permiso;
import com.davidhenriquez.rehabilicop.seguridad.permiso.PermisoService;

@RestController
@RequestMapping("/api/roles")
public class RolController {

	@Autowired
	private RolService rolService;
	
	@Autowired
	private PermisoService permisoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getRoles() {
    	try{
    		List<Rol> roles = rolService.findAll();
    		return ResponseEntity.ok(roles);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRol(UUID idRol){
		try {
			Rol rol = rolService.findById(idRol);
			return ResponseEntity.ok(rol);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear rol')")
	public ResponseEntity<?> create(@RequestBody Rol rol) throws Exception {
		try {
			return ResponseEntity.ok(rolService.create(rol));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar rol')")
	public ResponseEntity<?> update(@RequestBody Rol rol) throws Exception {
		try {
			return ResponseEntity.ok(rolService.update(rol));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar rol')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			rolService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Rol());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/permisos", method = RequestMethod.GET)
	public ResponseEntity<?> getPermisos(@PathVariable UUID id){
		try {
			Rol rol = rolService.findById(id);
			return ResponseEntity.ok(rol.getPermisos());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/permisos", method = RequestMethod.POST)	
	@PreAuthorize("hasRole('crear rol')")
	public ResponseEntity<?> createPermiso(@PathVariable UUID id,
			@RequestBody Permiso permiso) throws Exception {
		try {
			Rol rol = rolService.findById(id);
			Collection<Permiso> permisos = rol.getPermisos();
			permisos.add(permiso);
			return ResponseEntity.ok(rolService.create(rol));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}/permisos/{idPermiso}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar rol')")
	public ResponseEntity<?> deletePermiso(@PathVariable UUID id,
			@PathVariable UUID idPermiso) {
		try {
			Rol rol = rolService.findById(id);
			Collection<Permiso> permisos = rol.getPermisos();
			permisos.removeIf(x -> x.getIdPermiso().equals(idPermiso));			
			return ResponseEntity.ok(rolService.create(rol));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
