package com.davidhenriquez.rehabilicop.listas.alteracion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface AlteracionService {

	List<Alteracion> findAll();

	Alteracion findById(UUID idAlteracion);

	Alteracion create(Alteracion sede) throws ValidationException;
	
	Alteracion update(Alteracion sede) throws ValidationException;

	void delete(UUID idAlteracion) throws ValidationException;
}