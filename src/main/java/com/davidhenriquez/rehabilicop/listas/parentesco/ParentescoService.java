package com.davidhenriquez.rehabilicop.listas.parentesco;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ParentescoService {
	
	List<Parentesco> findAll();

	Parentesco findById(UUID idParentesco);

	Parentesco create(Parentesco parentesco) throws ValidationException;
	
	Parentesco update(Parentesco parentesco) throws ValidationException;

	void delete(UUID idParentesco) throws ValidationException;
}