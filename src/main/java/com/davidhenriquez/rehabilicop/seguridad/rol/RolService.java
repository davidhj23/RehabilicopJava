package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.seguridad.permiso.Permiso;

public interface RolService {

	List<Rol> findAll();

	Rol findById(UUID idRol);

	Rol create(Rol rol) throws ValidationException;
	
	Rol update(Rol rol) throws ValidationException;

	void delete(UUID idRol) throws ValidationException;
}