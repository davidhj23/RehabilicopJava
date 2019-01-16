package com.davidhenriquez.rehabilicop.procesos.evolucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvolucionesRepository extends CrudRepository<Evoluciones, Long>, EvolucionesRepositoryCustom {


}
