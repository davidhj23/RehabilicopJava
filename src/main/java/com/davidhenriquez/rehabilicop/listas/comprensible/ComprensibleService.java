package com.davidhenriquez.rehabilicop.listas.comprensible;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ComprensibleService {
	
	List<Comprensible> findAll();

	Comprensible findById(UUID idComprensible);

	Comprensible create(Comprensible comprensible) throws ValidationException;
	
	Comprensible update(Comprensible comprensible) throws ValidationException;

	void delete(UUID idComprensible) throws ValidationException;
}