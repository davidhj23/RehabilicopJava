package com.davidhenriquez.rehabilicop.listas.humor;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface HumorService {
	
	List<Humor> findAll();

	Humor findById(UUID idHumor);

	Humor create(Humor humor) throws ValidationException;
	
	Humor update(Humor humor) throws ValidationException;

	void delete(UUID idHumor) throws ValidationException;
}