package com.davidhenriquez.rehabilicop.listas.organo;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface OrganoService {
	
	List<Organo> findAll();

	Organo findById(UUID idOrgano);

	Organo create(Organo organo) throws ValidationException;
	
	Organo update(Organo organo) throws ValidationException;

	void delete(UUID idOrgano) throws ValidationException;
}