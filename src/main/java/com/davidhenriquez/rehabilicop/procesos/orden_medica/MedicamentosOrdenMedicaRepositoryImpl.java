package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.davidhenriquez.rehabilicop.procesos.evolucion.Evoluciones;

import java.util.List;

public class MedicamentosOrdenMedicaRepositoryImpl implements MedicamentosOrdenMedicaRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<MedicamentosOrdenMedicaSP> getMedicamentosOrdenMedica(String idOrdenMedica) {
        StoredProcedureQuery getMedicamentosOrdenMedica = em.createNamedStoredProcedureQuery("getMedicamentosOrdenMedica");        
        getMedicamentosOrdenMedica.setParameter("id_orden_medica", idOrdenMedica.replace("-", "").toUpperCase());
        return getMedicamentosOrdenMedica.getResultList();
    }
    
    @Override
    public List<AdministracionSP> getAdministraciones(String idMedicamentosOrdenMedica) {
        StoredProcedureQuery getAdministraciones = em.createNamedStoredProcedureQuery("getAdministraciones");        
        getAdministraciones.setParameter("id_medicamentos_orden_medica", idMedicamentosOrdenMedica.replace("-", "").toUpperCase());
        return getAdministraciones.getResultList();
    }
}