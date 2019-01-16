package com.davidhenriquez.rehabilicop.procesos.evolucion;

import java.util.List;

public interface EvolucionesRepositoryCustom {

    List<Evoluciones> getAllEvoluciones(String idAseguradora, int year, int month);
}