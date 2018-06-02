package com.davidhenriquez.rehabilicop.listas.regimen;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface RegimenService {
	
	List<Regimen> findAll();

	Regimen findById(UUID idRegimen);

	Regimen create(Regimen regimen) throws ValidationException;
	
	Regimen update(Regimen regimen) throws ValidationException;

	void delete(UUID idRegimen) throws ValidationException;
}