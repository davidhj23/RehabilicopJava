package com.davidhenriquez.rehabilicop.listas.fuerza_muscular;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuerzaMuscularRepository extends JpaRepository<FuerzaMuscular, UUID>{

}
