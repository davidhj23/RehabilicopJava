package com.davidhenriquez.rehabilicop.listas.patron;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface PatronService {

	List<Patron> findAll();

	Patron findById(UUID idPatron);

	Patron create(Patron sede) throws ValidationException;
	
	Patron update(Patron sede) throws ValidationException;

	void delete(UUID idPatron) throws ValidationException;
}