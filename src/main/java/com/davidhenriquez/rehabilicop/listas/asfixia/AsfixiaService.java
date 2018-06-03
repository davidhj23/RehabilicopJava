package com.davidhenriquez.rehabilicop.listas.asfixia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface AsfixiaService {
	
	List<Asfixia> findAll();

	Asfixia findById(UUID idAsfixia);

	Asfixia create(Asfixia asfixia) throws ValidationException;
	
	Asfixia update(Asfixia asfixia) throws ValidationException;

	void delete(UUID idAsfixia) throws ValidationException;
}