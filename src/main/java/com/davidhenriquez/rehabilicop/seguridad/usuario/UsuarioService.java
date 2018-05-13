package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.List;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface UsuarioService {
	
	List<Usuario> findAllClientes();	
	Usuario findOneCliente(String identificacion);
	Usuario saveCliente(Usuario usuario) throws ValidationException;
	Usuario updateCliente(Usuario usuario) throws ValidationException;
	void deleteCliente(String identificacion) throws ValidationException;
	Usuario registerCliente(Usuario usuario) throws ValidationException;
}
