package com.davidhenriquez.rehabilicop.procesos.paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.rehabilicop.core.config.JwtTokenUtil;
import com.davidhenriquez.rehabilicop.core.model.JwtUser;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioService;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {    
    
    @Autowired
    private UsuarioService usuarioService; 
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getPacientes() {
    	try{
    		List<Usuario> pacientes = usuarioService.findAllPacientes();
    		return ResponseEntity.ok(pacientes);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getPaciente(@PathVariable UUID id){
		try {
			Usuario paciente = usuarioService.findPacienteById(id);
			return ResponseEntity.ok(paciente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@PreAuthorize("hasRole('crear paciente')")
	public ResponseEntity<?> create(@RequestBody Usuario paciente) throws Exception {
		try {
			return ResponseEntity.ok(usuarioService.createPaciente(paciente));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());			
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('editar paciente')")
	public ResponseEntity<?> update(@RequestBody Usuario paciente) throws Exception {
		try {
			return ResponseEntity.ok(usuarioService.updatePaciente(paciente));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	@PreAuthorize("hasRole('eliminar paciente')")
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		try {
			usuarioService.deletePaciente(id);
			return ResponseEntity.status(HttpStatus.OK).body(new Usuario());
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "identificacion/{identificacion}", method = RequestMethod.GET)
	public ResponseEntity<?> getPaciente(@PathVariable String identificacion){
		try {
			Usuario paciente = usuarioService.findPacienteByIdentificacion(identificacion);
			return ResponseEntity.ok(paciente);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "search/{search}", method = RequestMethod.GET)
	public ResponseEntity<?> getPacienteByNombresApellidos(@PathVariable String search){
		try {
			List<Usuario> pacientes = usuarioService.findPacientesByNombresApellidos(search);
			return ResponseEntity.ok(pacientes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
	@RequestMapping(value = "/{id}/reabrir-ultima-historia", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('reabrir historia')")
	public ResponseEntity<?> reabrirUltimaHistoria(@RequestBody Usuario paciente) throws Exception {
		try {
			return ResponseEntity.ok(usuarioService.reabrirUltimaHistoria(paciente));
		} catch (ValidationException ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrors());
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
	
    public ResponseEntity<byte[]> reportEvoluciones(@PathVariable String idAdmision) throws SQLException {      
        byte[] bytes = usuarioService.generateReporteEvoluciones(idAdmision);
        return ResponseEntity
          .ok()
          .header("Content-Type", "application/pdf; charset=UTF-8")
          .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-evoluciones" + ".pdf\"")
          .body(bytes);      
      }
	
	 @RequestMapping(value = "/reporte-evoluciones/{idAdmision}", method = RequestMethod.GET)	
    public ResponseEntity<byte[]> reportEvoluciones2(@PathVariable String idAdmision,
    		@RequestParam(name = "fechaInicio", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
    		@RequestParam(name = "fechaFin", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) throws SQLException {      
      byte[] bytes = usuarioService.generateReporteEvoluciones2(idAdmision, fechaInicio, fechaFin);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-evoluciones" + ".pdf\"")
        .body(bytes);      
    }
	    
    @RequestMapping(value = "/reporte-ordenes-medicas/{idAdmision}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reportOrdenesMedicas(@PathVariable String idAdmision) throws SQLException {      
      byte[] bytes = usuarioService.generateReporteOrdenesMedicas(idAdmision);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-ordenes-medicas" + ".pdf\"")
        .body(bytes);      
    }
    
    @RequestMapping(value = "/reporte-epicrisis/{idAdmision}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reportEpicrisis(@PathVariable String idAdmision) throws SQLException {      
      byte[] bytes = usuarioService.generateReportEpicrisis(idAdmision);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-epicrisis" + ".pdf\"")
        .body(bytes);      
    }
    
    @RequestMapping(value = "/reporte-notas/{idAdmision}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reportNotas(@PathVariable String idAdmision) throws SQLException {      
      byte[] bytes = usuarioService.generateReportNotas(idAdmision);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-notas" + ".pdf\"")
        .body(bytes);      
    }
    
    @RequestMapping(value = "/reporte-historia/{idAdmision}", method = RequestMethod.GET)	
    public ResponseEntity<byte[]> reportHistoria(@PathVariable String idAdmision) throws SQLException {      
      byte[] bytes = usuarioService.generateReporteHistoria(idAdmision);
      return ResponseEntity
        .ok()
        .header("Content-Type", "application/pdf; charset=UTF-8")
        .header("Content-Disposition", "inline; filename=\"" + idAdmision + "-historia" + ".pdf\"")
        .body(bytes);      
    }
}