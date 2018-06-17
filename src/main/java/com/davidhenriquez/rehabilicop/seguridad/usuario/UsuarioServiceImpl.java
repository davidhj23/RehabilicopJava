package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ArrayList<ValidationResult> Validar(Usuario usuario)
    {
        return new ArrayList<ValidationResult>();
    }

    private ArrayList<ValidationResult> ValidarDuplicado(Usuario usuario)
    {
    	return new ArrayList<ValidationResult>();
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
		return usuarioRepository.save(usuario);		
	}
	
	public Usuario update(Usuario usuario) throws ValidationException {		
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