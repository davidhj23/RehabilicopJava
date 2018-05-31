package com.davidhenriquez.rehabilicop.listas.estado_conciencia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoConcienciaRepository extends JpaRepository<EstadoConciencia, UUID>{

}
