package com.davidhenriquez.rehabilicop.procesos.kardex;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evoluciones;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

public interface KardexService {
	
	Kardex create(Kardex kardex) throws ValidationException;
	
	List<Kardex> getKardexByPaciente(String identificacion);
}
