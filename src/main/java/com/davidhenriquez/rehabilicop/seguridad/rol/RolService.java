package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.List;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface RolService {

	List<Rol> findAll();

	Rol findById(Long idRol);

	Rol create(Rol rol) throws ValidationException;
	
	Rol update(Rol rol) throws ValidationException;

	void delete(Long idRol) throws ValidationException;
}