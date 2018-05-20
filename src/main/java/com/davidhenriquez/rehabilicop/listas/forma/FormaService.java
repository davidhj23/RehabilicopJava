package com.davidhenriquez.rehabilicop.listas.forma;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface FormaService {
	
	List<Forma> findAll();

	Forma findById(UUID idForma);

	Forma create(Forma forma) throws ValidationException;
	
	Forma update(Forma forma) throws ValidationException;

	void delete(UUID idForma) throws ValidationException;
}