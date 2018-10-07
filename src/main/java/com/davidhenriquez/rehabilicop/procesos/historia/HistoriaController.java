package com.davidhenriquez.rehabilicop.procesos.historia;

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
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/historias")
public class HistoriaController {
        
	@Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioService usuarioService;
        
    @Autowired
    private HistoriaService historiaService; 
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getHistorias() {
    	try{
    		List<Historia> historias = historiaService.findAll();
    		return ResponseEntity.ok(historias);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getHistoria(@PathVariable UUID id){
		try {
			Historia historia = historiaService.findById(id);
			return ResponseEntity.ok(historia);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear historia')")
	public ResponseEntity<?> create(@RequestBody Historia historia) throws Exception {
		try {
			return ResponseEntity.ok(historiaService.create(historia));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());			
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar historia')")
	public ResponseEntity<?> update(@RequestBody Historia historia) throws Exception {
		try {
			return ResponseEntity.ok(historiaService.update(historia));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar historia')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			historiaService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Historia());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/patologicos", method = RequestMethod.GET)
	public ResponseEntity<?> getPatologicos(@PathVariable UUID id){
		try {
			List<Patologico> patologicos = historiaService.findPatologicosByIdHistoria(id);
			return ResponseEntity.ok(patologicos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/antecedentes", method = RequestMethod.GET)
	public ResponseEntity<?> getAntecedentes(@PathVariable UUID id){
		try {
			List<Antecedente> antecedentes = historiaService.findAntecedentesByIdHistoria(id);
			return ResponseEntity.ok(antecedentes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/traumaticos", method = RequestMethod.GET)
	public ResponseEntity<?> getTraumaticos(@PathVariable UUID id){
		try {
			List<Traumatico> traumaticos = historiaService.findTraumaticosByIdHistoria(id);
			return ResponseEntity.ok(traumaticos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/farmacologicos", method = RequestMethod.GET)
	public ResponseEntity<?> getFarmacologicos(@PathVariable UUID id){
		try {
			List<Farmacologico> farmacologicos = historiaService.findFarmacologicosByIdHistoria(id);
			return ResponseEntity.ok(farmacologicos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/toxicos", method = RequestMethod.GET)
	public ResponseEntity<?> getToxicos(@PathVariable UUID id){
		try {
			List<Toxico> toxicos = historiaService.findToxicosByIdHistoria(id);
			return ResponseEntity.ok(toxicos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/gineco-obstetricios", method = RequestMethod.GET)
	public ResponseEntity<?> getGinecoObstetricios(@PathVariable UUID id){
		try {
			List<GinecoObstetricio> ginecoObstetricios = historiaService.findGinecoObstetriciosByIdHistoria(id);
			return ResponseEntity.ok(ginecoObstetricios);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico(@PathVariable UUID id){
		try {
			List<ExamenFisico> examenFisico = historiaService.findExamenFisicoByIdHistoria(id);
			return ResponseEntity.ok(examenFisico);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico2", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico2(@PathVariable UUID id){
		try {
			List<ExamenFisico2> examenFisico2 = historiaService.findExamenFisico2ByIdHistoria(id);
			return ResponseEntity.ok(examenFisico2);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico3", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico3(@PathVariable UUID id){
		try {
			List<ExamenFisico3> examenFisico3 = historiaService.findExamenFisico3ByIdHistoria(id);
			return ResponseEntity.ok(examenFisico3);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico4", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico4(@PathVariable UUID id){
		try {
			List<ExamenFisico4> examenFisico4 = historiaService.findExamenFisico4ByIdHistoria(id);
			return ResponseEntity.ok(examenFisico4);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico5", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico5(@PathVariable UUID id){
		try {
			List<ExamenFisico5> examenFisico5 = historiaService.findExamenFisico5ByIdHistoria(id);
			return ResponseEntity.ok(examenFisico5);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/examen-fisico6", method = RequestMethod.GET)
	public ResponseEntity<?> getExamenFisico6(@PathVariable UUID id){
		try {
			List<ExamenFisico6> examenFisico6 = historiaService.findExamenFisico6ByIdHistoria(id);
			return ResponseEntity.ok(examenFisico6);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}