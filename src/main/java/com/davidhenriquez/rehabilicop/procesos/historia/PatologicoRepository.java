package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface PatologicoRepository extends JpaRepository<Patologico, UUID> {     
	
}
