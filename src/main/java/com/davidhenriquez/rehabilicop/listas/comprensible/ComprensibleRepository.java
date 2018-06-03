package com.davidhenriquez.rehabilicop.listas.comprensible;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprensibleRepository extends JpaRepository<Comprensible, UUID>{   
	
}
