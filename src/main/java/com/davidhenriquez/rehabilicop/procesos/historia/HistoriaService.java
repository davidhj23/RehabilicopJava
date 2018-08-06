package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface HistoriaService {
	
	List<Historia> findAll();

	Historia findById(UUID idHistoria);

	Historia create(Historia historia) throws ValidationException;
	
	Historia update(Historia historia) throws ValidationException;

	void delete(UUID idHistoria) throws ValidationException;
}
