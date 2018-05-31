package com.davidhenriquez.rehabilicop.listas.expresion_facial3;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ExpresionFacial3Service {

	List<ExpresionFacial3> findAll();

	ExpresionFacial3 findById(UUID idExpresionFacial3);

	ExpresionFacial3 create(ExpresionFacial3 expresionFacial3) throws ValidationException;
	
	ExpresionFacial3 update(ExpresionFacial3 expresionFacial3) throws ValidationException;

	void delete(UUID idExpresionFacial3) throws ValidationException;
}