package com.davidhenriquez.rehabilicop.listas.tiempo_de_uso;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface TiempoDeUsoService {
	
	List<TiempoDeUso> findAll();

	TiempoDeUso findById(UUID idTiempoDeUso);

	TiempoDeUso create(TiempoDeUso tiempoDeUso) throws ValidationException;
	
	TiempoDeUso update(TiempoDeUso tiempoDeUso) throws ValidationException;

	void delete(UUID idTiempoDeUso) throws ValidationException;
}