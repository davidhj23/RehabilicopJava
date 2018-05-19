package com.davidhenriquez.rehabilicop.listas.servicio;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ServicioService {

	List<Servicio> findAll();

	Servicio findById(UUID idServicio);

	Servicio create(Servicio servicio) throws ValidationException;
	
	Servicio update(Servicio servicio) throws ValidationException;

	void delete(UUID idServicio) throws ValidationException;
}