package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.List;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;

public interface RolService {

	List<Rol> findAll();

	Rol findById(Long idRol);

	Rol create(Rol rol) throws ValidationException;
	
	Rol update(Rol rol) throws ValidationException;

	void delete(Long idRol) throws ValidationException;
}