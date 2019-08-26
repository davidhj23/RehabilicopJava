package com.davidhenriquez.rehabilicop.procesos.epicrisis;

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
import com.davidhenriquez.rehabilicop.procesos.orden_medica.OrdenMedica;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/epicrisis")
public class EpicrisisController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EpicrisisService epicrisisService;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getEpicrisis() {
    	try{
    		return ResponseEntity.ok(epicrisisService.findAll());
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }    
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear epicrisis')")
	public ResponseEntity<?> create(HttpServletRequest request, @RequestBody Epicrisis epicrisis) throws Exception {
		try {			
			return ResponseEntity.ok(epicrisisService.create(epicrisis));		
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)	
	public ResponseEntity<?> getEpicrisis(@PathVariable UUID id) throws Exception {
		try {
			return ResponseEntity.ok(epicrisisService.findById(id));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}/medicamentos", method = RequestMethod.GET)
	public ResponseEntity<?> getMedicamentos(@PathVariable UUID id){
		try {			
			return ResponseEntity.ok(epicrisisService.findMedicamentosByIdEpicrisis(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar epicrisis')")
	public ResponseEntity<?> update(@RequestBody Epicrisis epicrisis) throws Exception {
		try {
			return ResponseEntity.ok(epicrisisService.update(epicrisis));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/reporte/{idAdmision}", method = RequestMethod.GET)	
    @PreAuthorize("hasRole('crear epicrisis')")
    public ResponseEntity<byte[]> report(@PathVariable String idAdmision) throws SQLException {      
      byte[] bytes = epicrisisService.generateReport(idAdmision);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + ".pdf\"")
        .body(bytes);      
    }
}