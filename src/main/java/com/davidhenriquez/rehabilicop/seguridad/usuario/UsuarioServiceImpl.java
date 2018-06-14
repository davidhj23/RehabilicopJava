package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.davidhenriquez.rehabilicop.core.model.JwtUser;
import com.davidhenriquez.rehabilicop.core.util.Util;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumento;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

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
	
	public Usuario findOneCliente(UUID idUsuario){
		return usuarioRepository.findOne(idUsuario);
	}

	@Override
	public void changePassword(String username, ChangePasswordModel changePasswordModel) throws ValidationException {	
		Usuario usuario = usuarioRepository.findByUsername(username);		
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();		
		String currentEncryptedPassword = bCryptPasswordEncoder.encode(changePasswordModel.getCurrentPassword());
		
		if(!usuario.getPassword().equals(currentEncryptedPassword)) {
			ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();	    	
	    	vaidationResults.add(new ValidationResult("password", "La contraseña actual no es correcta"));
	    	throw new ValidationException(vaidationResults);
		}		
		
		usuario.setPassword(bCryptPasswordEncoder.encode(changePasswordModel.getNewPassword()));
		usuarioRepository.save(usuario);		
	}
}