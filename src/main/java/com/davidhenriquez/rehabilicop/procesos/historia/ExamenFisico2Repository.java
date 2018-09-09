package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenFisico2Repository extends JpaRepository<ExamenFisico2, UUID> {      
    
}
