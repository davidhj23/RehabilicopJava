package com.davidhenriquez.rehabilicop.listas.introspeccion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntrospeccionRepository extends JpaRepository<Introspeccion, UUID>{   
	
}
