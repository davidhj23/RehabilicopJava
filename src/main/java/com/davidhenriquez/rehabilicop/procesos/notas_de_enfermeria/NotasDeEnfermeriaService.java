package com.davidhenriquez.rehabilicop.procesos.notas_de_enfermeria;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evoluciones;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface NotasDeEnfermeriaService {
	
	NotasDeEnfermeria create(NotasDeEnfermeria notasDeEnfermeria) throws ValidationException;
	
	List<NotasDeEnfermeria> getNotasDeEnfermeriaByPaciente(String identificacion);
	
	void delete(UUID id) throws ValidationException;
}
