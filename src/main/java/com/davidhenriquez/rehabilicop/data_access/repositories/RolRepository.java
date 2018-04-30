package com.davidhenriquez.rehabilicop.data_access.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.data_access.domain.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {    
	Rol findByNombre(String nombre);
}
