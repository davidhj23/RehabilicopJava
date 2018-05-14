package com.davidhenriquez.rehabilicop.listas.opcion;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface OpcionRepository extends JpaRepository<Opcion, UUID> {   
	
}
