package com.davidhenriquez.rehabilicop.listas.estado_conciencia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

public interface EstadoConcienciaService {

	List<EstadoConciencia> findAll();

	EstadoConciencia findById(UUID idEstadoConciencia);

	EstadoConciencia create(EstadoConciencia estadoConciencia) throws ValidationException;
	
	EstadoConciencia update(EstadoConciencia estadoConciencia) throws ValidationException;

	void delete(UUID idEstadoConciencia) throws ValidationException;
}