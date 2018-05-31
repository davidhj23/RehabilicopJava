package com.davidhenriquez.rehabilicop.listas.sexo;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface SexoService {
	
	List<Sexo> findAll();

	Sexo findById(UUID idSexo);

	Sexo create(Sexo sexo) throws ValidationException;
	
	Sexo update(Sexo sexo) throws ValidationException;

	void delete(UUID idSexo) throws ValidationException;
}