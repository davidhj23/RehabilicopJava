package com.davidhenriquez.rehabilicop.listas.alteracion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface AlteracionService {

	List<Alteracion> findAll();

	Alteracion findById(UUID idAlteracion);

	Alteracion create(Alteracion alimentacion) throws ValidationException;
	
	Alteracion update(Alteracion alimentacion) throws ValidationException;

	void delete(UUID idAlteracion) throws ValidationException;
}