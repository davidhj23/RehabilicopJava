package com.davidhenriquez.rehabilicop.listas.gesta;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestaRepository extends JpaRepository<Gesta, UUID>{   
	
}
