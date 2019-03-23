package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;

import java.util.List;
import java.util.UUID;

public interface MedicamentosOrdenMedicaRepository extends JpaRepository<MedicamentosOrdenMedica, UUID> {


}
