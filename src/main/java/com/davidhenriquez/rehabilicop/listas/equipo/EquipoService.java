package com.davidhenriquez.rehabilicop.listas.equipo;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface EquipoService {
	
	List<Equipo> findAll();

	Equipo findById(UUID idEquipo);

	Equipo create(Equipo equipo) throws ValidationException;
	
	Equipo update(Equipo equipo) throws ValidationException;

	void delete(UUID idEquipo) throws ValidationException;
}