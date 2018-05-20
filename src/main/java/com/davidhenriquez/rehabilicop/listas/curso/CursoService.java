package com.davidhenriquez.rehabilicop.listas.curso;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface CursoService {
	
	List<Curso> findAll();

	Curso findById(UUID idCurso);

	Curso create(Curso curso) throws ValidationException;
	
	Curso update(Curso curso) throws ValidationException;

	void delete(UUID idCurso) throws ValidationException;
}