package com.davidhenriquez.rehabilicop.seguridad.usuario;

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

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private UsuarioService usuarioService; 
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios() {
    	try{
    		List<Usuario> usuarios = usuarioService.findAll();
    		return ResponseEntity.ok(usuarios);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getUsuario(@PathVariable UUID id){
		try {
			Usuario usuario = usuarioService.findById(id);
			return ResponseEntity.ok(usuario);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear usuario')")
	public ResponseEntity<?> create(@RequestBody Usuario usuario) throws Exception {
		try {
			return ResponseEntity.ok(usuarioService.create(usuario));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());			
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar usuario')")
	public ResponseEntity<?> update(@RequestBody Usuario usuario) throws Exception {
		try {
			return ResponseEntity.ok(usuarioService.update(usuario));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar usuario')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			usuarioService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Usuario());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
    
    @RequestMapping(value = "/me", method = RequestMethod.GET)    
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "/permisos", method = RequestMethod.GET)
    public ResponseEntity<?> validarPermisos() {
    	try{
    		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    		Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
    		
    		List<String> permisos = grantedAuthorities.stream()
                    .map(a -> a.getAuthority().substring(5))                    
                    .collect(Collectors.toList());
    		
    		return ResponseEntity.ok(permisos);      	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/password", method = RequestMethod.POST)    
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordModel chanagePasswordModel,
    		HttpServletRequest request) {
    	try{
	        String token = request.getHeader(tokenHeader);
	        String username = jwtTokenUtil.getUsernameFromToken(token);	        
	        usuarioService.changePassword(username, chanagePasswordModel);
	        return ResponseEntity.ok("");     
    	} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());		
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/{idUsuario}/password", method = RequestMethod.POST)    
    @PreAuthorize("hasRole('restablecer clave')")
    public ResponseEntity<?> restablecerPassword(@PathVariable UUID idUsuario, 
    		@RequestBody RestablecerPasswordModel restablecerPasswordModel) {
    	try{	        
	        usuarioService.restablecerPassword(idUsuario, restablecerPasswordModel);
	        return ResponseEntity.ok("");     
    	} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());    		
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/medicos", method = RequestMethod.GET)
    public ResponseEntity<?> getMedicos() {
    	try{
    		List<Usuario> medicos = usuarioService.findAllMedicos();
    		return ResponseEntity.ok(medicos);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/psiquiatras", method = RequestMethod.GET)
    public ResponseEntity<?> getPsiquiatras() {
    	try{
    		List<Usuario> psiquiatras = usuarioService.findAllPsiquiatras();
    		return ResponseEntity.ok(psiquiatras);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/medicos-y-psiquiatras", method = RequestMethod.GET)
    public ResponseEntity<?> getMedicosyPsiquiatras() {
    	try{
    		List<Usuario> todos = usuarioService.findAllMedicosyPsiquiatras();
    		return ResponseEntity.ok(todos);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/jefes-enfermerias", method = RequestMethod.GET)
    public ResponseEntity<?> getJefesEnfermerias() {
    	try{
    		List<Usuario> jefes = usuarioService.findAllJefesEnfermerias();
    		return ResponseEntity.ok(jefes);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/enfermeros", method = RequestMethod.GET)
    public ResponseEntity<?> getEnfermeros() {
    	try{
    		List<Usuario> enfermeros = usuarioService.findAllEnfermeros();
    		return ResponseEntity.ok(enfermeros);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/auditores", method = RequestMethod.GET)
    public ResponseEntity<?> getAuditores() {
    	try{
    		List<Usuario> auditores = usuarioService.findAllAuditores();
    		return ResponseEntity.ok(auditores);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/auxiliares-farmacia", method = RequestMethod.GET)
    public ResponseEntity<?> getAuxiliaresFarmacia() {
    	try{
    		List<Usuario> auxiliares = usuarioService.findAllAuxiliaresFarmacia();
    		return ResponseEntity.ok(auxiliares);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
}