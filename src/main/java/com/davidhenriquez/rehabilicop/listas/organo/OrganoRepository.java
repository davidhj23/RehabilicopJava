package com.davidhenriquez.rehabilicop.listas.organo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganoRepository extends JpaRepository<Organo, UUID>{   
	
}
