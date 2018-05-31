package com.davidhenriquez.rehabilicop.listas.aseguradora;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradoraRepository extends JpaRepository<Aseguradora, UUID>{   
	
}
