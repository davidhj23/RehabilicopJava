package com.davidhenriquez.rehabilicop.procesos.notas_de_enfermeria;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasDeEnfermeriaRepository extends JpaRepository<NotasDeEnfermeria, UUID> {      
    
}
