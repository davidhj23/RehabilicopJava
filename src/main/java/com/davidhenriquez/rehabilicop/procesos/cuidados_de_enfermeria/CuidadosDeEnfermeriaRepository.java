package com.davidhenriquez.rehabilicop.procesos.cuidados_de_enfermeria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;

import java.util.List;
import java.util.UUID;

public interface CuidadosDeEnfermeriaRepository extends JpaRepository<CuidadosDeEnfermeria, UUID> {


}
