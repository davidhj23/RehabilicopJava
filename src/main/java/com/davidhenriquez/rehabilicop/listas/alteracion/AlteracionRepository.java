package com.davidhenriquez.rehabilicop.listas.alteracion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlteracionRepository extends JpaRepository<Alteracion, UUID> {   
	
}
