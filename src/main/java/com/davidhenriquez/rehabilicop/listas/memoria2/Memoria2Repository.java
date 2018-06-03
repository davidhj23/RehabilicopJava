package com.davidhenriquez.rehabilicop.listas.memoria2;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Memoria2Repository extends JpaRepository<Memoria2, UUID>{   
	
}
