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
	
	List<Patologico> findPatologicosByIdHistoria(UUID idHistoria);
	List<Antecedente> findAntecedentesByIdHistoria(UUID idHistoria);
	List<Traumatico> findTraumaticosByIdHistoria(UUID idHistoria);
	List<Farmacologico> findFarmacologicosByIdHistoria(UUID idHistoria);
	List<Toxico> findToxicosByIdHistoria(UUID idHistoria);
	List<GinecoObstetricio> findGinecoObstetriciosByIdHistoria(UUID idHistoria);
	List<ExamenFisico> findExamenFisicoByIdHistoria(UUID idHistoria);
	List<ExamenFisico2> findExamenFisico2ByIdHistoria(UUID idHistoria);
	List<ExamenFisico3> findExamenFisico3ByIdHistoria(UUID idHistoria);
	List<ExamenFisico4> findExamenFisico4ByIdHistoria(UUID idHistoria);
	List<ExamenFisico5> findExamenFisico5ByIdHistoria(UUID idHistoria);
	List<ExamenFisico6> findExamenFisico6ByIdHistoria(UUID idHistoria);
}
