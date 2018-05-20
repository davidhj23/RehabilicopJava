package com.davidhenriquez.rehabilicop.listas.humor;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumorRepository extends JpaRepository<Humor, UUID>{   
	
}
