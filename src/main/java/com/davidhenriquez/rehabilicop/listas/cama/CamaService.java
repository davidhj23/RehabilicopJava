package com.davidhenriquez.rehabilicop.listas.cama;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface CamaService {
	
	List<Cama> findAll();

	Cama findById(UUID idCama);

	Cama create(Cama cama) throws ValidationException;
	
	Cama update(Cama cama) throws ValidationException;

	void delete(UUID idCama) throws ValidationException;
}