package com.davidhenriquez.rehabilicop.procesos.admision;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmisionRepository extends JpaRepository<Admision, UUID> {      
    
}
