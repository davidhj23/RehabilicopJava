package com.davidhenriquez.rehabilicop.listas.memoria;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface MemoriaService {
	
	List<Memoria> findAll();

	Memoria findById(UUID idMemoria);

	Memoria create(Memoria memoria) throws ValidationException;
	
	Memoria update(Memoria memoria) throws ValidationException;

	void delete(UUID idMemoria) throws ValidationException;
}