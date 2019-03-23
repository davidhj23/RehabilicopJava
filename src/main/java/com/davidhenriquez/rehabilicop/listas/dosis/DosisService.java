package com.davidhenriquez.rehabilicop.listas.dosis;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface DosisService {
	
	List<Dosis> findAll();

	Dosis findById(UUID idDosis);

	Dosis create(Dosis dosis) throws ValidationException;
	
	Dosis update(Dosis dosis) throws ValidationException;

	void delete(UUID idDosis) throws ValidationException;
}