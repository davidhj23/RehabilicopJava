package com.davidhenriquez.rehabilicop.procesos.admision;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface AdmisionService {
	
	List<Admision> findAll();

	Admision findById(UUID idAdmision);

	Admision create(Admision admision) throws ValidationException;
	
	Admision update(Admision admision) throws ValidationException;

	void delete(UUID idAdmision) throws ValidationException;
}
