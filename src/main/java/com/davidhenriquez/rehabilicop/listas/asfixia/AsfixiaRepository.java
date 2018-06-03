package com.davidhenriquez.rehabilicop.listas.asfixia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsfixiaRepository extends JpaRepository<Asfixia, UUID>{   
	
}
