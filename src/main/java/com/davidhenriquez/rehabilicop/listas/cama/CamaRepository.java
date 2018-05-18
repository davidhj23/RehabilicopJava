package com.davidhenriquez.rehabilicop.listas.cama;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamaRepository extends JpaRepository<Cama, UUID>{   
	
}
