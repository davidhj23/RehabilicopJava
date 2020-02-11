package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.rehabilicop.core.config.JwtTokenUtil;
import com.davidhenriquez.rehabilicop.core.model.JwtUser;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/orden-medica")
public class OrdenMedicaController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private OrdenMedicaService ordenMedicaService;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getOrdenesMedicas() {
    	try{
    		List<OrdenMedica> ordenesMedicas = ordenMedicaService.findAll();
    		return ResponseEntity.ok(ordenesMedicas);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear orden medica')")
	public ResponseEntity<?> create(HttpServletRequest request, @RequestBody OrdenMedica ordenMedica) throws Exception {
		try {
			if(ordenMedica.getSolicitante() == null){
				String token = request.getHeader(tokenHeader);
		        String username = jwtTokenUtil.getUsernameFromToken(token);
				Usuario usuario = usuarioService.findUserByUsername(username);
				ordenMedica.setSolicitante(usuario);	
			}
			return ResponseEntity.ok(ordenMedicaService.create(ordenMedica));		
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public ResponseEntity<?> getOrdeneMedica(@PathVariable UUID id) throws Exception {
		try {
			return ResponseEntity.ok(ordenMedicaService.findById(id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}/medicamentos", method = RequestMethod.GET)
	public ResponseEntity<?> getMedicamentos(@PathVariable UUID id){
		try {			
			return ResponseEntity.ok(ordenMedicaService.findMedicamentosByIdOrdenMedica(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar orden medica')")
	public ResponseEntity<?> update(@RequestBody OrdenMedica ordenMedica) throws Exception {
		try {
			return ResponseEntity.ok(ordenMedicaService.update(ordenMedica));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/medicamentos/{id}/administraciones", method = RequestMethod.GET)
	public ResponseEntity<?> getAdministraciones(@PathVariable UUID id){
		try {			
			return ResponseEntity.ok(ordenMedicaService.findAdministracionesByIdMedicamento(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	//@PreAuthorize("hasRole('eliminar admision')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			ordenMedicaService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Admision());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}