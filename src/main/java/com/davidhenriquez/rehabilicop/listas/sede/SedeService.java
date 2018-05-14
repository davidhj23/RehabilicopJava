package com.davidhenriquez.rehabilicop.listas.sede;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface SedeService {

	List<Sede> findAll();

	Sede findById(UUID idSede);

	Sede create(Sede sede) throws ValidationException;
	
	Sede update(Sede sede) throws ValidationException;

	void delete(UUID idSede) throws ValidationException;
}