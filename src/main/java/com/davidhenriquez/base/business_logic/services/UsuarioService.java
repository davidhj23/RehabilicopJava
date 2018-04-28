package com.davidhenriquez.base.business_logic.services;

import java.util.List;

import com.davidhenriquez.base.business_logic.validation.ValidationException;
import com.davidhenriquez.base.data_access.domain.Usuario;

public interface UsuarioService {
	
	//Usuario findByUserName(String userName);
	
	List<Usuario> findAllClientes();	
	Usuario findOneCliente(Long IdUsuario);
	Usuario saveCliente(Usuario usuario) throws ValidationException;
	Usuario updateCliente(Usuario usuario) throws ValidationException;
	void deleteCliente(Long id) throws ValidationException;
	Usuario registerCliente(Usuario usuario) throws ValidationException;
	
	List<Usuario> findAllPromotores();
	Usuario findOnePromotor(Long IdUsuario);
	Usuario savePromotor(Usuario usuario) throws ValidationException;
	Usuario updatePromotor(Usuario usuario) throws ValidationException;
	void deletePromotor(Long id) throws ValidationException;
	Usuario registerPromotor(Usuario usuario) throws ValidationException;
	
}
