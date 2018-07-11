package com.davidhenriquez.rehabilicop.listas.cie10;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface Cie10Service {

	List<Cie10> findAll();

	Cie10 findById(UUID idCie10);

	Cie10 create(Cie10 cie10) throws ValidationException;
	
	Cie10 update(Cie10 cie10) throws ValidationException;

	void delete(UUID idCie10) throws ValidationException;
	
	List<Cie10> search(String search);
}