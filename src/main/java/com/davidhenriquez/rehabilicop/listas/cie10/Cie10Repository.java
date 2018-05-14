package com.davidhenriquez.rehabilicop.listas.cie10;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cie10Repository extends JpaRepository<Cie10, UUID> {   
	
}
