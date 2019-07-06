package com.davidhenriquez.rehabilicop.procesos.administracion_de_medicamentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;

import java.util.List;
import java.util.UUID;

public interface AdministracionDeMedicamentosRepository extends JpaRepository<AdministracionDeMedicamentos, UUID> {


}
