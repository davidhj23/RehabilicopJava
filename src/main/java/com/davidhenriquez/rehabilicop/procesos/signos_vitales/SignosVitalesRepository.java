package com.davidhenriquez.rehabilicop.procesos.signos_vitales;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SignosVitalesRepository extends JpaRepository<SignosVitales, UUID> {      
    
}
