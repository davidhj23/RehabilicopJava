package com.davidhenriquez.base.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.base.business_logic.services.UsuarioService;
import com.davidhenriquez.base.business_logic.validation.ValidationException;
import com.davidhenriquez.base.business_logic.validation.ValidationResult;
import com.davidhenriquez.base.data_access.domain.Usuario;
import com.davidhenriquez.base.presentation.config.JwtTokenUtil;
import com.davidhenriquez.base.presentation.models.JwtUser;
import com.davidhenriquez.base.presentation.models.RegistroViewModel;

import java.util.Collection;
import java.util.List;
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
    
    @RequestMapping(value = "/me", method = RequestMethod.GET)    
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)    
    @PreAuthorize("hasRole('consultar cliente')")
    public ResponseEntity<?> findAll() {
    	try{
    		List<Usuario> usuarios = usuarioService.findAllClientes();
    		return ResponseEntity.ok(usuarios);    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.GET)    
    @PreAuthorize("hasRole('consultar cliente')")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id){    
    	try{
    		return ResponseEntity.ok(usuarioService.findOneCliente(id));    		
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }    
    
    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    @PreAuthorize("hasRole('crear cliente')")
    public ResponseEntity<?> save(@RequestBody RegistroViewModel registroViewModel) throws Exception {
    	try{
    		Usuario usuario = registroViewModel.ToUsuario();
    		return ResponseEntity.ok(usuarioService.registerCliente(usuario));    
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('editar cliente')")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Usuario usuario) throws Exception{
    	try{
    		return ResponseEntity.ok(usuarioService.updateCliente(usuario));    
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}  	
    }
    
    @RequestMapping(value = "/clientes/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('eliminar cliente')")
    public ResponseEntity delete(@PathVariable("id") Long id){
    	try{
    		usuarioService.deleteCliente(id);
    		return new ResponseEntity(HttpStatus.OK);  
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	} 
    }
    
    @RequestMapping(value = "/promotores", method = RequestMethod.GET)    
    @PreAuthorize("hasRole('consultar promotor')")
    public ResponseEntity<?> findAllPromotores() {
    	try{
    		List<Usuario> usuarios = usuarioService.findAllPromotores();
    		return ResponseEntity.ok(usuarios);    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/promotores/{id}", method = RequestMethod.GET)    
    @PreAuthorize("hasRole('consultar promotor')")
    public ResponseEntity<?> findOnePromotor(@PathVariable("id") Long id){    
    	try{
    		return ResponseEntity.ok(usuarioService.findOnePromotor(id));    		
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/promotores", method = RequestMethod.POST)    
    public ResponseEntity<?> savePromotor(@RequestBody Usuario usuario) throws Exception {
    	try{
    		return ResponseEntity.ok(usuarioService.registerPromotor(usuario));
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
    
    @RequestMapping(value = "/promotores/{id}", method = RequestMethod.PUT)
    @PreAuthorize("hasRole('editar promotor')")
    public ResponseEntity<?> updatePromotor(@PathVariable("id") Long id, @RequestBody Usuario usuario) throws Exception{
    	try{
    		return ResponseEntity.ok(usuarioService.updatePromotor(usuario));    
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}  	
    }
    
    @RequestMapping(value = "/promotores/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('eliminar promotor')")
    public ResponseEntity deletePromotor(@PathVariable("id") Long id){
    	try{
    		usuarioService.deletePromotor(id);
    		return new ResponseEntity(HttpStatus.OK);  
    	}catch(ValidationException ex){    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(ex.getErrors());    	
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	} 
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
}