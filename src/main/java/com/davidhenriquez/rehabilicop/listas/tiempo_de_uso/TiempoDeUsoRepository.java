package com.davidhenriquez.rehabilicop.listas.tiempo_de_uso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiempoDeUsoRepository extends JpaRepository<TiempoDeUso, UUID>{   
	
}
