package com.davidhenriquez.rehabilicop.listas.se_muestra1;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface SeMuestra1Service {

	List<SeMuestra1> findAll();

	SeMuestra1 findById(UUID idSeMuestra1);

	SeMuestra1 create(SeMuestra1 seMuestra1) throws ValidationException;
	
	SeMuestra1 update(SeMuestra1 seMuestra1) throws ValidationException;

	void delete(UUID idSeMuestra1) throws ValidationException;
}