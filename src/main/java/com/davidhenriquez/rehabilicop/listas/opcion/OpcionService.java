package com.davidhenriquez.rehabilicop.listas.opcion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface OpcionService {

	List<Opcion> findAll();

	Opcion findById(UUID idOpcion);

	Opcion create(Opcion rol) throws ValidationException;
	
	Opcion update(Opcion rol) throws ValidationException;

	void delete(UUID idOpcion) throws ValidationException;
}