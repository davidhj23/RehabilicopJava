package com.davidhenriquez.rehabilicop.procesos.administracion_de_medicamentos;

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

public interface AdministracionDeMedicamentosService {
		
	AdministracionDeMedicamentos create(AdministracionDeMedicamentos administracionDeMedicamentos) throws ValidationException;
	
	List<AdministracionDeMedicamentos> getAdministracionDeMedicamentosByPaciente(String idPaciente);
}
