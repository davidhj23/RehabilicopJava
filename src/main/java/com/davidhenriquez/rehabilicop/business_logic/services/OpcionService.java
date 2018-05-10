package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.List;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.data_access.domain.Opcion;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;

public interface OpcionService {

	List<Opcion> findAll();

	Opcion findById(Long idOpcion);

	Opcion create(Opcion rol) throws ValidationException;
	
	Opcion update(Opcion rol) throws ValidationException;

	void delete(Long idOpcion) throws ValidationException;
}