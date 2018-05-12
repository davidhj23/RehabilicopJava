package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.List;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.data_access.domain.Opcion;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.domain.Sede;

public interface SedeService {

	List<Sede> findAll();

	Sede findById(Long idSede);

	Sede create(Sede sede) throws ValidationException;
	
	Sede update(Sede sede) throws ValidationException;

	void delete(Long idSede) throws ValidationException;
}