package com.davidhenriquez.rehabilicop.listas.tono_voz;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface TonoVozService {

	List<TonoVoz> findAll();

	TonoVoz findById(UUID idSede);

	TonoVoz create(TonoVoz sede) throws ValidationException;
	
	TonoVoz update(TonoVoz sede) throws ValidationException;

	void delete(UUID idSede) throws ValidationException;
}