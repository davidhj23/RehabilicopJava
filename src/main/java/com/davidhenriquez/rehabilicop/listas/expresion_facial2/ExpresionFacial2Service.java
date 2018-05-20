package com.davidhenriquez.rehabilicop.listas.expresion_facial2;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ExpresionFacial2Service {

	List<ExpresionFacial2> findAll();

	ExpresionFacial2 findById(UUID idExpresionFacial2);

	ExpresionFacial2 create(ExpresionFacial2 expresionFacial2) throws ValidationException;
	
	ExpresionFacial2 update(ExpresionFacial2 expresionFacial2) throws ValidationException;

	void delete(UUID idExpresionFacial2) throws ValidationException;
}