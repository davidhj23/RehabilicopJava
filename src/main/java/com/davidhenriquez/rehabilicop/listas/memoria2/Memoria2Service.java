package com.davidhenriquez.rehabilicop.listas.memoria2;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface Memoria2Service {
	
	List<Memoria2> findAll();

	Memoria2 findById(UUID idMemoria2);

	Memoria2 create(Memoria2 memoria2) throws ValidationException;
	
	Memoria2 update(Memoria2 memoria2) throws ValidationException;

	void delete(UUID idMemoria2) throws ValidationException;
}