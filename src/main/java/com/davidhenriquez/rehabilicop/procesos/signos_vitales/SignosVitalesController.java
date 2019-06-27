package com.davidhenriquez.rehabilicop.procesos.signos_vitales;

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
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/signos-vitales")
public class SignosVitalesController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioService usuarioService;
        
    @Autowired
    private SignosVitalesService signosVitalesService; 
    	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear signos vitales')")
	public ResponseEntity<?> create(
			HttpServletRequest request, 
			@RequestBody SignosVitales signosVitales) throws Exception {
		try {
			String token = request.getHeader(tokenHeader);
	        String username = jwtTokenUtil.getUsernameFromToken(token);
	        Usuario usuario = usuarioService.findUserByUsername(username);	        
	        signosVitales.setUsuario(usuario);
			return ResponseEntity.ok(signosVitalesService.create(signosVitales));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());			
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/paciente/{identificacion}", method = RequestMethod.GET)
	public ResponseEntity<?> getAdmisionActivaByIdentificacionPaciente(@PathVariable String identificacion){
		try {
			List<SignosVitales> signosVitales = signosVitalesService.getSignosVitalesByPaciente(identificacion);
			return ResponseEntity.ok(signosVitales);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}