package com.davidhenriquez.rehabilicop.listas.apariencia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AparienciaRepository extends JpaRepository<Apariencia, UUID>{   
	
}
