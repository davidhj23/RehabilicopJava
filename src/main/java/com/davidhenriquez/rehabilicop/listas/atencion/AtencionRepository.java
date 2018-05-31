package com.davidhenriquez.rehabilicop.listas.atencion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, UUID>{   
	
}
