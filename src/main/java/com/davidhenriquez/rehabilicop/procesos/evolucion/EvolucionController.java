package com.davidhenriquez.rehabilicop.procesos.evolucion;

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
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/evoluciones")
public class EvolucionController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioService usuarioService;
        
    @Autowired
    private EvolucionService evolucionService; 
        
    @Autowired
    private UserDetailsService userDetailsService;
        
    @RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('evolucion')")
	public ResponseEntity<?> create(HttpServletRequest request, @RequestBody Evolucion evolucion) throws Exception {
		try {
			String token = request.getHeader(tokenHeader);
	        String username = jwtTokenUtil.getUsernameFromToken(token);
			Usuario usuario = usuarioService.findUserByUsername(username);
			evolucion.setUsuario(usuario);
			return ResponseEntity.ok(evolucionService.create(evolucion));		
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/tipos-evoluciones", method = RequestMethod.GET)    
    public ResponseEntity<?> getAuthenticatedUser(HttpServletRequest request) {
    	try {
	        String token = request.getHeader(tokenHeader);
	        String username = jwtTokenUtil.getUsernameFromToken(token);
	        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
	        return ResponseEntity.ok(evolucionService.findTipoEvolucionbyIdRol(user.getRoles()));    	
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
    }
    
    @RequestMapping(value = "/aseguradora/{id}/anio/{anio}/mes/{mes}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('auditar')")
	public ResponseEntity<?> getAllEvoluciones(
			@PathVariable String id,
			@PathVariable int anio,
			@PathVariable int mes) throws Exception {
		try {
			return ResponseEntity.ok(evolucionService.getAllEvoluciones(id, anio, mes));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/empleado", method = RequestMethod.GET)
	@PreAuthorize("hasRole('evolucion')")
	public ResponseEntity<?> getEvolucionesPorMesYEmpleado(HttpServletRequest request) throws Exception {
		try {
			String token = request.getHeader(tokenHeader);
	        String username = jwtTokenUtil.getUsernameFromToken(token);
	        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
			return ResponseEntity.ok(evolucionService.getEvolucionesEmpleado(user.getIdentificacion()));
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}