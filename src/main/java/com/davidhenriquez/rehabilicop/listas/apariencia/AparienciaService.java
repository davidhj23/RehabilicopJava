package com.davidhenriquez.rehabilicop.listas.apariencia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface AparienciaService {
	
	List<Apariencia> findAll();

	Apariencia findById(UUID idApariencia);

	Apariencia create(Apariencia apariencia) throws ValidationException;
	
	Apariencia update(Apariencia apariencia) throws ValidationException;

	void delete(UUID idApariencia) throws ValidationException;
}