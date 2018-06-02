package com.davidhenriquez.rehabilicop.listas.conciencia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ConcienciaService {
	
	List<Conciencia> findAll();

	Conciencia findById(UUID idConciencia);

	Conciencia create(Conciencia conciencia) throws ValidationException;
	
	Conciencia update(Conciencia conciencia) throws ValidationException;

	void delete(UUID idConciencia) throws ValidationException;
}