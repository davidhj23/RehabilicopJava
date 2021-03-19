package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.List;

public interface MedicamentosOrdenMedicaRepositoryCustom {

	List<MedicamentosOrdenMedicaSP> getMedicamentosOrdenMedica(String idOrdenMedica);
	
	List<AdministracionSP> getAdministraciones(String idMedicamentosOrdenMedica);
}