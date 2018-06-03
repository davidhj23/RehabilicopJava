package com.davidhenriquez.rehabilicop.listas.introspeccion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface IntrospeccionService {
	
	List<Introspeccion> findAll();

	Introspeccion findById(UUID idIntrospeccion);

	Introspeccion create(Introspeccion introspeccion) throws ValidationException;
	
	Introspeccion update(Introspeccion introspeccion) throws ValidationException;

	void delete(UUID idIntrospeccion) throws ValidationException;
}