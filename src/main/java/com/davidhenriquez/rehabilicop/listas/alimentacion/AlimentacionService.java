package com.davidhenriquez.rehabilicop.listas.alimentacion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface AlimentacionService {
	
	List<Alimentacion> findAll();

	Alimentacion findById(UUID idAlimentacion);

	Alimentacion create(Alimentacion alimentacion) throws ValidationException;
	
	Alimentacion update(Alimentacion alimentacion) throws ValidationException;

	void delete(UUID idAlimentacion) throws ValidationException;
}