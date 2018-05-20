package com.davidhenriquez.rehabilicop.listas.curso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID>{   
	
}
