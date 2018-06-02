package com.davidhenriquez.rehabilicop.listas.regimen;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegimenRepository extends JpaRepository<Regimen, UUID>{   
	
}
