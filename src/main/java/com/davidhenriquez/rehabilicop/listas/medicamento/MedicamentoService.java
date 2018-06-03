package com.davidhenriquez.rehabilicop.listas.medicamento;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface MedicamentoService {
	
	List<Medicamento> findAll();

	Medicamento findById(UUID idMedicamento);

	Medicamento create(Medicamento medicamento) throws ValidationException;
	
	Medicamento update(Medicamento medicamento) throws ValidationException;

	void delete(UUID idMedicamento) throws ValidationException;
}