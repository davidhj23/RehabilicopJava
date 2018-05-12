package com.davidhenriquez.rehabilicop.listas.opcion;

import java.util.List;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface OpcionService {

	List<Opcion> findAll();

	Opcion findById(Long idOpcion);

	Opcion create(Opcion rol) throws ValidationException;
	
	Opcion update(Opcion rol) throws ValidationException;

	void delete(Long idOpcion) throws ValidationException;
}