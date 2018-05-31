package com.davidhenriquez.rehabilicop.listas.tipo_entidad;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

public interface TipoEntidadService {

	List<TipoEntidad> findAll();

	TipoEntidad findById(UUID idTipoEntidad);

	TipoEntidad create(TipoEntidad tipoEntidad) throws ValidationException;
	
	TipoEntidad update(TipoEntidad tipoEntidad) throws ValidationException;

	void delete(UUID idTipoEntidad) throws ValidationException;
}