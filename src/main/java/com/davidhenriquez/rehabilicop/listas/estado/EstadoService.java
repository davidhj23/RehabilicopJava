package com.davidhenriquez.rehabilicop.listas.estado;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface EstadoService {
	
	List<Estado> findAll();

	Estado findById(UUID idEstado);

	Estado create(Estado estado) throws ValidationException;
	
	Estado update(Estado estado) throws ValidationException;

	void delete(UUID idEstado) throws ValidationException;
}