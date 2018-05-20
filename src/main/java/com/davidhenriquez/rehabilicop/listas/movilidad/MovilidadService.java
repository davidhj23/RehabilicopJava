package com.davidhenriquez.rehabilicop.listas.movilidad;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface MovilidadService {
	
	List<Movilidad> findAll();

	Movilidad findById(UUID idMovilidad);

	Movilidad create(Movilidad movilidad) throws ValidationException;
	
	Movilidad update(Movilidad movilidad) throws ValidationException;

	void delete(UUID idMovilidad) throws ValidationException;
}