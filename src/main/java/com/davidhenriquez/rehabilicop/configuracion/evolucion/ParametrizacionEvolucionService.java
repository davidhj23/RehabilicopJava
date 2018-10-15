package com.davidhenriquez.rehabilicop.configuracion.evolucion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;

public interface ParametrizacionEvolucionService {
	
	List<TipoEvolucion> findAllTiposEvoluciones();	
	
	ParametrizacionEvolucion create(ParametrizacionEvolucion parametrizacionEvolucion) throws ValidationException;

	List<ParametrizacionEvolucion> findAll();
	
	void delete(UUID id) throws ValidationException;
}
