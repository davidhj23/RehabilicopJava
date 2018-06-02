package com.davidhenriquez.rehabilicop.listas.gesta;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface GestaService {
	
	List<Gesta> findAll();

	Gesta findById(UUID idGesta);

	Gesta create(Gesta gesta) throws ValidationException;
	
	Gesta update(Gesta gesta) throws ValidationException;

	void delete(UUID idGesta) throws ValidationException;
}