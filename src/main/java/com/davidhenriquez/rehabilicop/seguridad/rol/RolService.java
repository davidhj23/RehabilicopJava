package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface RolService {

	List<Rol> findAll();

	Rol findById(UUID idRol);

	Rol create(Rol rol) throws ValidationException;
	
	Rol update(Rol rol) throws ValidationException;

	void delete(UUID idRol) throws ValidationException;
}