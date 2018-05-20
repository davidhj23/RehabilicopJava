package com.davidhenriquez.rehabilicop.listas.marcha;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface MarchaService {
	
	List<Marcha> findAll();

	Marcha findById(UUID idMarcha);

	Marcha create(Marcha marcha) throws ValidationException;
	
	Marcha update(Marcha marcha) throws ValidationException;

	void delete(UUID idMarcha) throws ValidationException;
}