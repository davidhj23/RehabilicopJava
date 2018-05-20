package com.davidhenriquez.rehabilicop.listas.movilidad;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoilidadRepository extends JpaRepository<Movilidad, UUID>{   
	
}
