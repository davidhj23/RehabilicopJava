package com.davidhenriquez.rehabilicop.listas.se_muestra2;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface SeMuestra2Service {

	List<SeMuestra2> findAll();

	SeMuestra2 findById(UUID idSeMuestra2);

	SeMuestra2 create(SeMuestra2 seMuestra2) throws ValidationException;
	
	SeMuestra2 update(SeMuestra2 seMuestra2) throws ValidationException;

	void delete(UUID idSeMuestra2) throws ValidationException;
}