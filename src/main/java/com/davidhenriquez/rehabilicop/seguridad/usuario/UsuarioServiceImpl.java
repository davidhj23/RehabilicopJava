package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
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
	        			  a.getEmail().equals(usuario.getEmail()))
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
    		vaidationResults.add(new ValidationResult("cedula", "Ya existe un paciente con esta cédula"));
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
	public List<Usuario> findAllEnfermeros() {
		return usuarioRepository.findAll().stream()
                .filter(x -> x.getRoles().stream().anyMatch(y -> y.getNombre().equals("Jefe enfermeria")))
                .sorted(Comparator.comparing(Usuario::getNombres))
                .collect(Collectors.toList());
	}

	@Override
	public Usuario findUserByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}
}