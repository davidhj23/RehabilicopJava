package com.davidhenriquez.rehabilicop.seguridad.permiso;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, UUID> {    
	
}
