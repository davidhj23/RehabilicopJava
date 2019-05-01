package com.davidhenriquez.rehabilicop.seguridad.permiso;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.cama.Cama;

public interface PermisoService {

	List<Permiso> findAll();
}