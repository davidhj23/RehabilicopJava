package com.davidhenriquez.rehabilicop.procesos.epicrisis;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.procesos.orden_medica.MedicamentosOrdenMedica;
import com.davidhenriquez.rehabilicop.procesos.orden_medica.OrdenMedica;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;

public interface EpicrisisService {
	
	List<Epicrisis> findAll();
	
	Epicrisis create(Epicrisis epicrisis) throws ValidationException;
	
	Epicrisis findById(UUID id);
	
	List<TratamientoFarmacologico> findMedicamentosByIdEpicrisis(UUID id);
	
	Epicrisis update(Epicrisis epicrisis) throws ValidationException;
	
	byte[] generateReport(String identificacion) throws SQLException;
}
