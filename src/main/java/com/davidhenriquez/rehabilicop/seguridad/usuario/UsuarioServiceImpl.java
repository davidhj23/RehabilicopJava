package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private DataSource dataSource;
	
	private ArrayList<ValidationResult> Validar(Usuario usuario)
    {
        return new ArrayList<ValidationResult>();
    }

	private ArrayList<ValidationResult> validarDuplicado(Usuario usuario)
    {	
		ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		Optional<Usuario> duplicateCedula = usuarios.stream()
		        .filter(a -> !a.getIdUsuario().equals(usuario.getIdUsuario()) &&
		        			  a.getIdentificacion().equals(usuario.getIdentificacion()))
		        .findAny();
    	
    	if(duplicateCedula.isPresent()){
    		vaidationResults.add(new ValidationResult("cedula", "Ya existe un Usuario con esta cédula"));
    	}
		
    	Optional<Usuario> duplicate = usuarios.stream()
	        .filter(a -> !a.getIdUsuario().equals(usuario.getIdUsuario()) &&
	        			  (a.getEmail() != null && a.getEmail().equals("") &&
	        			   a.getEmail().equals(usuario.getEmail())))
	        .findAny();
    	
    	if(duplicate.isPresent()){
    		vaidationResults.add(new ValidationResult("email", "Ya existe un Usuario con este email"));
    	}
    	
    	return vaidationResults;
    }

    private ArrayList<ValidationResult> ValidarIntegridad(Usuario usuario)
    {
    	return new ArrayList<ValidationResult>();
    }
    
    public List<Usuario> findAll(){
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getUsername() != null && 
                		     !x.getUsername().equals("admin"))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	public Usuario findById(UUID idUsuario){
		return usuarioRepository.findOne(idUsuario);
	}
	
	public Usuario create(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(usuario);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		usuario.setEnabled(true);
		usuario.setUsername(usuario.getIdentificacion());		
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getIdentificacion()));
		return usuarioRepository.save(usuario);		
	}
	
	public Usuario update(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(usuario);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		usuario.setUsername(usuario.getIdentificacion());
		Usuario usuarioGuardado = findById(usuario.getIdUsuario()); 
		usuario.setPassword(usuarioGuardado.getPassword());
		return usuarioRepository.save(usuario);			
	}

	@Transactional
	public void delete(UUID idUsuario) throws ValidationException {
		usuarioRepository.delete(idUsuario);		
	}

	@Override
	public void changePassword(String username, ChangePasswordModel changePasswordModel) throws ValidationException {	
		Usuario usuario = usuarioRepository.findByUsername(username);		
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		if(!bCryptPasswordEncoder.matches(changePasswordModel.getCurrentPassword(), usuario.getPassword())){
			ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();	    	
	    	vaidationResults.add(new ValidationResult("password", "La clave actual no es correcta"));
	    	throw new ValidationException(vaidationResults);
		}
		
		usuario.setPassword(bCryptPasswordEncoder.encode(changePasswordModel.getNewPassword()));
		usuarioRepository.save(usuario);		
	}

	@Override
	public void restablecerPassword(UUID idUsuario, RestablecerPasswordModel restablecerPasswordModel)
			throws ValidationException {
		Usuario usuario = usuarioRepository.findOne(idUsuario);				
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(restablecerPasswordModel.getNewPassword()));
		usuarioRepository.save(usuario);		
	}

	@Override
	public List<Usuario> findAllPacientes() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getUsername() == null || 
                		     x.getUsername().equals(""))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}

	@Override
	public Usuario findPacienteById(UUID idPaciente) {		
		return findById(idPaciente);
	}

	@Override
	public Usuario createPaciente(Usuario paciente) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(paciente);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);		
		 
		Optional<Rol> rol = rolRepository.findAll().stream().filter(x -> x.getNombre().equals("Paciente")).findFirst();		
		ArrayList<Rol> roles = new ArrayList<Rol>();
		roles.add(rol.get());
		
		paciente.setRoles(roles);
		return usuarioRepository.save(paciente);		
	}

	@Override
	public Usuario updatePaciente(Usuario paciente) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(paciente);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		Optional<Rol> rol = rolRepository.findAll().stream().filter(x -> x.getNombre().equals("Paciente")).findFirst();		
		ArrayList<Rol> roles = new ArrayList<Rol>();
		roles.add(rol.get());
		
		paciente.setRoles(roles);
		return usuarioRepository.save(paciente);		
	}

	@Override
	public void deletePaciente(UUID idPaciente) throws ValidationException {
		delete(idPaciente);
	}
	
	private ArrayList<ValidationResult> validarDuplicadoPaciente(Usuario paciente)
    {	
		ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		Optional<Usuario> duplicateCedula = usuarios.stream()
		        .filter(a -> !a.getIdUsuario().equals(paciente.getIdUsuario()) &&
		        			  a.getIdentificacion().equals(paciente.getIdentificacion()))
		        .findAny();
    	
    	if(duplicateCedula.isPresent()){
    		vaidationResults.add(new ValidationResult("cedula", "Ya existe un paciente con esta cÃ©dula"));
    	}
		
    	Optional<Usuario> duplicate = usuarios.stream()
	        .filter(a -> !a.getIdUsuario().equals(paciente.getIdUsuario()) &&
	        			  a.getEmail().equals(paciente.getEmail()))
	        .findAny();
    	
    	if(duplicate.isPresent()){
    		vaidationResults.add(new ValidationResult("email", "Ya existe un paciente con este email"));
    	}
    	
    	return vaidationResults;
    }
	
	@Override
	public List<Usuario> findAllMedicos() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Medicina general")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllPsiquiatras() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Psiquiatria") || y.getNombre().equals("Psiquiatria Infantil")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllMedicosyPsiquiatras() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y ->
                	y.getNombre().equals("Medicina general") ||
                	y.getNombre().equals("Psiquiatria") || 
                	y.getNombre().equals("Psiquiatria Infantil")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllJefesEnfermerias() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Jefe enfermeria")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllEnfermeros() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Enfermeria")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllAuditores() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Auditor")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> findAllAuxiliaresFarmacia() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Auxiliar Farmacia")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}

	@Override
	public Usuario findUserByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
	
	@Override
	public Usuario findPacienteByIdentificacion(String identificacion) {
		 Optional<Usuario> pacienteOptional = usuarioRepository.findAll().stream()
                .filter(x -> (x.getUsername() == null || 
                		      x.getUsername().equals("")) &&
                			  x.getIdentificacion().equals(identificacion))                
                .findFirst();
		 
		 if(pacienteOptional.isPresent()){
	    		return pacienteOptional.get();
		 }
		 
		 return null;
	}

	@Override
	public List<Usuario> findPacientesByNombresApellidos(String search) {
		return usuarioRepository.findAll().stream()
				.filter(x -> (x.getUsername() == null || 
           		     		  x.getUsername().equals("")) &&
           		     		 (x.getNombres().toLowerCase().contains(search.toLowerCase()) ||
							  x.getApellidos().toLowerCase().contains(search.toLowerCase())))
				.sorted(Comparator.comparing(Usuario::getNombres))
				.collect(Collectors.toList()); 
	}
	
	@Override
	public byte[] generateReporteEvoluciones(String idAdmision) throws SQLException {
		
		byte[] bytes = null;
	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {		    	
	    	JasperReport jasperReport = 
		    		(JasperReport) JRLoader.loadObject(
		    				resourceLoader.getResource("classpath:EvolucionesMaster.jasper").getInputStream());
		    
		    Map<String, Object> params = new HashMap<>();
		      params.put("identificacion", idAdmision.replace("-", ""));
		    
		    JasperPrint jasperPrint = 
		    		JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());			      
	      	bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    }
	    catch (JRException | IOException e) {
	    	e.printStackTrace();
	    }
	    
		// Cerrar historia
	    
	    return bytes;
    }
	
	@Override
	public byte[] generateReporteOrdenesMedicas(String idAdmision) throws SQLException {
		
		byte[] bytes = null;
	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {		    	
	    	JasperReport jasperReport = 
		    		(JasperReport) JRLoader.loadObject(
		    				resourceLoader.getResource("classpath:OrdenesMedicasMaster.jasper").getInputStream());
		    
		    Map<String, Object> params = new HashMap<>();
		      params.put("identificacion", idAdmision.replace("-", ""));
		    
		    JasperPrint jasperPrint = 
		    		JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());			      
	      	bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    }
	    catch (JRException | IOException e) {
	    	e.printStackTrace();
	    }
	    
		// Cerrar historia
	    
	    return bytes;
    }
	
	@Override
	public byte[] generateReportEpicrisis(String idAdmision) throws SQLException {
		
		byte[] bytes = null;
	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {		    	
	    	JasperReport jasperReport = 
		    		(JasperReport) JRLoader.loadObject(
		    				resourceLoader.getResource("classpath:EpicrisisMaster.jasper").getInputStream());
		    
		    Map<String, Object> params = new HashMap<>();
		      params.put("identificacion", idAdmision.replace("-", ""));
		    
		    JasperPrint jasperPrint = 
		    		JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());			      
	      	bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    }
	    catch (JRException | IOException e) {
	    	e.printStackTrace();
	    }
	    
		// Cerrar historia
	    
	    return bytes;
    }
}