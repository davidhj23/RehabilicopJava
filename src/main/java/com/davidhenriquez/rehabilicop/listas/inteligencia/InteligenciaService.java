package com.davidhenriquez.rehabilicop.listas.inteligencia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface InteligenciaService {
	
	List<Inteligencia> findAll();

	Inteligencia findById(UUID idInteligencia);

	Inteligencia create(Inteligencia inteligencia) throws ValidationException;
	
	Inteligencia update(Inteligencia inteligencia) throws ValidationException;

	void delete(UUID idInteligencia) throws ValidationException;
}