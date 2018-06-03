package com.davidhenriquez.rehabilicop.listas.via_ingreso;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface ViaIngresoService {

	List<ViaIngreso> findAll();

	ViaIngreso findById(UUID idViaIngreso);

	ViaIngreso create(ViaIngreso viaIngreso) throws ValidationException;
	
	ViaIngreso update(ViaIngreso viaIngreso) throws ValidationException;

	void delete(UUID idViaIngreso) throws ValidationException;
}