package com.davidhenriquez.rehabilicop.listas.escolaridad;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface EscolaridadService {
	
	List<Escolaridad> findAll();

	Escolaridad findById(UUID idEscolaridad);

	Escolaridad create(Escolaridad escolaridad) throws ValidationException;
	
	Escolaridad update(Escolaridad escolaridad) throws ValidationException;

	void delete(UUID idEscolaridad) throws ValidationException;
}