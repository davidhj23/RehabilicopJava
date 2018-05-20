package com.davidhenriquez.rehabilicop.listas.memoria;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoriaRepository extends JpaRepository<Memoria, UUID>{   
	
}
