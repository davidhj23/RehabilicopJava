package com.davidhenriquez.rehabilicop.listas.tono_voz;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface TonoVozService {

	List<TonoVoz> findAll();

	TonoVoz findById(UUID idTonoVoz);

	TonoVoz create(TonoVoz tonoVoz) throws ValidationException;
	
	TonoVoz update(TonoVoz tonoVoz) throws ValidationException;

	void delete(UUID idTonoVoz) throws ValidationException;
}