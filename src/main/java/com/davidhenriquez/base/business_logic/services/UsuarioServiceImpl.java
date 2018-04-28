package com.davidhenriquez.base.business_logic.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.davidhenriquez.base.business_logic.util.Util;
import com.davidhenriquez.base.business_logic.validation.ValidationException;
import com.davidhenriquez.base.business_logic.validation.ValidationResult;
import com.davidhenriquez.base.data_access.domain.Rol;
import com.davidhenriquez.base.data_access.domain.TipoDocumento;
import com.davidhenriquez.base.data_access.domain.Usuario;
import com.davidhenriquez.base.data_access.repositories.UsuarioRepository;

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

    /*public Usuario findByUserName(String userName){
		return usuarioRepository.findByUsername(userName);
	}*/
    
	public List<Usuario> findAllClientes(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		usuarios = usuarios.stream().filter(x-> x.isEnabled()).collect(Collectors.toList());
		return usuarios;
	}
	
	public Usuario findOneCliente(Long IdUsuario){
		return usuarioRepository.findOne(IdUsuario);
	}
	
	public Usuario saveCliente(Usuario usuario) throws ValidationException {		
		usuario.setEnabled(true);
		ArrayList<ValidationResult> validaciones = this.Validar(usuario);

        if (validaciones.size() > 0)
            throw new ValidationException(validaciones);

        ArrayList<ValidationResult> validacionesDuplicado = this.ValidarDuplicado(usuario);
        if (validacionesDuplicado.size() > 0)
            throw new ValidationException(validacionesDuplicado);
        
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getIdentificacion()));
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdTipoDocumento(1L);
		
		usuario.setTipoDocumento(tipoDocumento);
        
        return usuarioRepository.save(usuario);
	}
	
	public Usuario updateCliente(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.Validar(usuario);
		if (validaciones.size() > 0)
            throw new ValidationException(validaciones);
		
		ArrayList<ValidationResult> validacionesDuplicado = this.ValidarDuplicado(usuario);
        if (validacionesDuplicado.size() > 0)
            throw new ValidationException(validacionesDuplicado);

        Usuario usuarioConsultado = findOneCliente(usuario.getIdUsuario());
        usuario.setPassword(usuarioConsultado.getPassword());
        
        return usuarioRepository.save(usuario);
    }

	public void deleteCliente(Long id) throws ValidationException {	
		Usuario usuario = findOneCliente(id);
		
		ArrayList<ValidationResult> validaciones = ValidarIntegridad(usuario);
        if (validaciones.size() > 0)
            throw new ValidationException(validaciones);
        
        usuario.setEnabled(false);
		usuarioRepository.save(usuario);
	}
	
	public Usuario registerCliente(Usuario usuario) throws ValidationException {		
		usuario.setEnabled(true);
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdTipoDocumento(1L);
		
		Rol rol = new Rol();
		rol.setIdRol(2L);
		List<Rol> roles = new ArrayList<Rol>();
		roles.add(rol);
		
		usuario.setTipoDocumento(tipoDocumento);
		
        return usuarioRepository.save(usuario);
	}
	
	public List<Usuario> findAllPromotores(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Usuario> promotores = new ArrayList<Usuario>();
		
		for (Usuario usuario : usuarios) {
			if(usuario.isEnabled()){
				for (Rol rol: usuario.getRoles()) {
					if(rol.getIdRol() == 3){
						usuario.setImagenUrl(Util.getPromotorImageName(usuario.getIdentificacion()));						
						promotores.add(usuario);
					}
				}
			}
		}
		
		return promotores;
	}

	public Usuario findOnePromotor(Long IdUsuario){
		return usuarioRepository.findOne(IdUsuario);
	}
	
	public Usuario savePromotor(Usuario usuario) throws ValidationException {		
		usuario.setEnabled(true);
		ArrayList<ValidationResult> validaciones = this.Validar(usuario);

        if (validaciones.size() > 0)
            throw new ValidationException(validaciones);

        ArrayList<ValidationResult> validacionesDuplicado = this.ValidarDuplicado(usuario);
        if (validacionesDuplicado.size() > 0)
            throw new ValidationException(validacionesDuplicado);
        
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getIdentificacion()));
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdTipoDocumento(1L);
		
		usuario.setTipoDocumento(tipoDocumento);
        
        return usuarioRepository.save(usuario);
	}
	
	public Usuario updatePromotor(Usuario usuario) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.Validar(usuario);
		if (validaciones.size() > 0)
            throw new ValidationException(validaciones);
		
		ArrayList<ValidationResult> validacionesDuplicado = this.ValidarDuplicado(usuario);
        if (validacionesDuplicado.size() > 0)
            throw new ValidationException(validacionesDuplicado);

        Usuario usuarioConsultado = findOnePromotor(usuario.getIdUsuario());
        usuario.setPassword(usuarioConsultado.getPassword());
        
        return usuarioRepository.save(usuario);
    }

	public void deletePromotor(Long id) throws ValidationException {	
		Usuario usuario = findOnePromotor(id);
		
		ArrayList<ValidationResult> validaciones = ValidarIntegridad(usuario);
        if (validaciones.size() > 0)
            throw new ValidationException(validaciones);
        
        usuario.setEnabled(false);
		usuarioRepository.save(usuario);
	}
	
	public Usuario registerPromotor(Usuario usuario) throws ValidationException {		
		usuario.setEnabled(true);
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getIdentificacion()));
		
		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setIdTipoDocumento(1L);
		
		usuario.setTipoDocumento(tipoDocumento);
		
		Rol rol = new Rol();
		rol.setIdRol(3L);
		List<Rol> roles = new ArrayList<Rol>();
		roles.add(rol);
		
		usuario.setRoles(roles);
		
        return usuarioRepository.save(usuario);
	}
}
