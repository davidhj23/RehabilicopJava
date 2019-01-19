package com.davidhenriquez.rehabilicop.procesos.evolucion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class EvolucionesRepositoryImpl implements EvolucionesRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Evoluciones> getAllEvoluciones(String idAseguradora, int year, int month) {
        StoredProcedureQuery getAllEvoluciones = em.createNamedStoredProcedureQuery("getAllEvoluciones");        
        getAllEvoluciones.setParameter("id_aseguradora", idAseguradora.replace("-", "").toUpperCase());
        getAllEvoluciones.setParameter("year_param", year);
        getAllEvoluciones.setParameter("month_param", month);
        return getAllEvoluciones.getResultList();
    }
}