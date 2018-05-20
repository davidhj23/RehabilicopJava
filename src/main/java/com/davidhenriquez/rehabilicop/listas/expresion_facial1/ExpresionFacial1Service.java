package com.davidhenriquez.rehabilicop.listas.expresion_facial1;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ExpresionFacial1Service {

	List<ExpresionFacial1> findAll();

	ExpresionFacial1 findById(UUID idExpresionFacial1);

	ExpresionFacial1 create(ExpresionFacial1 expresionFacial1) throws ValidationException;
	
	ExpresionFacial1 update(ExpresionFacial1 expresionFacial1) throws ValidationException;

	void delete(UUID idExpresionFacial1) throws ValidationException;
}