package com.davidhenriquez.rehabilicop.configuracion.evolucion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametrizacionEvolucionRepository extends JpaRepository<ParametrizacionEvolucion, UUID> {      
    
}
