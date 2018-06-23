package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ArrayList<ValidationResult> Validar(Usuario usuario)
    {
        return new ArrayList<ValidationResult>();
    }

	private ArrayList<ValidationResult> validarDuplicado(Usuario usuario)
    {	
		ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
		
		Optional<Usuario> duplicateCedula = findAll().stream()
		        .filter(a -> !a.getIdUsuario().equals(usuario.getIdUsuario()) &&
		        			  a.getIdentificacion().equals(usuario.getIdentificacion()))
		        .findAny();
    	
    	if(duplicateCedula.isPresent()){
    		vaidationResults.add(new ValidationResult("cedula", "Ya existe un Usuario con esta cédula"));
    	}
		
    	Optional<Usuario> duplicate = findAll().stream()
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
                .filter(x -> !x.getUsername().equals("admin"))                    
                .collect(Collectors.toList());
	}
	
	public Usuario findById(UUID idUsuario){
		return usuarioRepository.findOne(idUsuario);
	}
	
	public Usuario create(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(usuario);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		usuario.setUsername(usuario.getEmail());
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getIdentificacion()));
		return usuarioRepository.save(usuario);		
	}
	
	public Usuario update(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(usuario);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		usuario.setUsername(usuario.getEmail());
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
}