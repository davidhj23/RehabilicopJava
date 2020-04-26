package com.davidhenriquez.rehabilicop.listas.alucinacion;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface AlucinacionService {
	
	List<Alucinacion> findAll();

	Alucinacion findById(UUID idAlucinacion);

	Alucinacion create(Alucinacion alucinacion) throws ValidationException;
	
	Alucinacion update(Alucinacion alucinacion) throws ValidationException;

	void delete(UUID idAlucinacion) throws ValidationException;
}