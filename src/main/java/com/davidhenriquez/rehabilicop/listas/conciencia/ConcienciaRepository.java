package com.davidhenriquez.rehabilicop.listas.conciencia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcienciaRepository extends JpaRepository<Conciencia, UUID>{   
	
}
