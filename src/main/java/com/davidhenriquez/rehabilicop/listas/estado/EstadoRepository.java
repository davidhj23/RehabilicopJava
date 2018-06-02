package com.davidhenriquez.rehabilicop.listas.estado;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID>{   
	
}
