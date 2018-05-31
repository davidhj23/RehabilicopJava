package com.davidhenriquez.rehabilicop.listas.escolaridad;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaridadRepository extends JpaRepository<Escolaridad, UUID>{   
	
}
