package com.davidhenriquez.rehabilicop.procesos.kardex;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KardexRepository extends JpaRepository<Kardex, UUID> {      
    
}
