package com.davidhenriquez.rehabilicop.procesos.evolucion;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;

public interface EvolucionService {
	
	Evolucion create(Evolucion evolucion) throws ValidationException;
	
	List<TipoEvolucion> findTipoEvolucionbyIdRol(Collection<Rol> roles);
	
	List<Evoluciones> getAllEvoluciones(String idAseguradora, int year, int month);
	
	List<Evolucion> getEvolucionesEmpleado(String identification);
}
