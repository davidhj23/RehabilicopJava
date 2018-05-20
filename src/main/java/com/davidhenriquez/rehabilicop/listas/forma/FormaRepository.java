package com.davidhenriquez.rehabilicop.listas.forma;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaRepository extends JpaRepository<Forma, UUID>{   
	
}
