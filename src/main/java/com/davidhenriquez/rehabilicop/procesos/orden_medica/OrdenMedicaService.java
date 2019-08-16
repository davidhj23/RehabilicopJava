package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;

public interface OrdenMedicaService {
	
	List<OrdenMedica> findAll();
	
	OrdenMedica findById(UUID id);
	
	OrdenMedica create(OrdenMedica ordenMedica) throws ValidationException;
	
	List<OrdenMedica> getOrdenesMedicasByPaciente(String idPaciente);
	
	List<MedicamentosOrdenMedica> findMedicamentosByIdOrdenMedica(UUID id);
	
	List<Administracion> findAdministracionesByIdMedicamento(UUID id);
	
	OrdenMedica update(OrdenMedica ordenMedica) throws ValidationException;
}
