package com.davidhenriquez.rehabilicop.listas.parentesco;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentescoRepository extends JpaRepository<Parentesco, UUID>{   
	
}
