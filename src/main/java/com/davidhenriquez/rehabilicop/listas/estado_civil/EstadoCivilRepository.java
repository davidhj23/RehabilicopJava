package com.davidhenriquez.rehabilicop.listas.estado_civil;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCivilRepository extends JpaRepository<EstadoCivil, UUID>{

}
