package com.davidhenriquez.rehabilicop.listas.dosis;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DosisRepository extends JpaRepository<Dosis, UUID>{   
	
}
