package com.davidhenriquez.rehabilicop.listas.inteligencia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteligenciaRepository extends JpaRepository<Inteligencia, UUID>{   
	
}
