package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.List;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.data_access.domain.Usuario;

public interface UsuarioService {
	
	//Usuario findByUserName(String userName);
	
	List<Usuario> findAllClientes();	
	Usuario findOneCliente(String identificacion);
	Usuario saveCliente(Usuario usuario) throws ValidationException;
	Usuario updateCliente(Usuario usuario) throws ValidationException;
	void deleteCliente(String identificacion) throws ValidationException;
	Usuario registerCliente(Usuario usuario) throws ValidationException;
	
	List<Usuario> findAllPromotores();
	Usuario findOnePromotor(String identificacion);
	Usuario savePromotor(Usuario usuario) throws ValidationException;
	Usuario updatePromotor(Usuario usuario) throws ValidationException;
	void deletePromotor(String identificacion) throws ValidationException;
	Usuario registerPromotor(Usuario usuario) throws ValidationException;
	
}
