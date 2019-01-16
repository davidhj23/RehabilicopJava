package com.davidhenriquez.rehabilicop.listas.aseguradora;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

public interface AseguradoraService {
	
	List<Aseguradora> findAll();

	Aseguradora findById(UUID idAseguradora);

	Aseguradora create(Aseguradora aseguradora) throws ValidationException;
	
	Aseguradora update(Aseguradora aseguradora) throws ValidationException;

	void delete(UUID idAseguradora) throws ValidationException;
	
	List<Aseguradora> findAseguradorasByUsuario(Usuario usuario);
}