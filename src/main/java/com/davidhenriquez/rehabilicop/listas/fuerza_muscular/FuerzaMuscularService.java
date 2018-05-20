package com.davidhenriquez.rehabilicop.listas.fuerza_muscular;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

public interface FuerzaMuscularService {

	List<FuerzaMuscular> findAll();

	FuerzaMuscular findById(UUID idFuerzaMuscular);

	FuerzaMuscular create(FuerzaMuscular fuerzaMuscular) throws ValidationException;
	
	FuerzaMuscular update(FuerzaMuscular fuerzaMuscular) throws ValidationException;

	void delete(UUID idFuerzaMuscular) throws ValidationException;
}