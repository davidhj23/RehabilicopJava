package com.davidhenriquez.rehabilicop.procesos.hoja_eventual;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;

public interface HojaEventualService {
	
	HojaEventual create(HojaEventual hojaEventual) throws ValidationException;
	
	List<HojaEventual> getHojasEventualesEmpleado(String identification);
}
