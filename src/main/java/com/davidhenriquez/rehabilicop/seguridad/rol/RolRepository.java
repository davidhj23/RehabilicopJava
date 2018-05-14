package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, UUID> {    
	Rol findByNombre(String nombre);
}
