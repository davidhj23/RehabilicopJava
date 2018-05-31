package com.davidhenriquez.rehabilicop.listas.atencion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface AtencionService {
	
	List<Atencion> findAll();

	Atencion findById(UUID idAtencion);

	Atencion create(Atencion atencion) throws ValidationException;
	
	Atencion update(Atencion atencion) throws ValidationException;

	void delete(UUID idAtencion) throws ValidationException;
}