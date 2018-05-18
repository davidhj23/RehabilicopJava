package com.davidhenriquez.rehabilicop.listas.estado_civil;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

public interface EstadoCivilService {

	List<EstadoCivil> findAll();

	EstadoCivil findById(UUID idEstadoCivil);

	EstadoCivil create(EstadoCivil estadoCivil) throws ValidationException;
	
	EstadoCivil update(EstadoCivil estadoCivil) throws ValidationException;

	void delete(UUID idEstadoCivil) throws ValidationException;
}