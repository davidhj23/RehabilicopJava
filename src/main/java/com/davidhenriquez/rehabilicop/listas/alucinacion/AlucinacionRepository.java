package com.davidhenriquez.rehabilicop.listas.alucinacion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlucinacionRepository extends JpaRepository<Alucinacion, UUID>{   
	
}
