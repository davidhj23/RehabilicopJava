package com.davidhenriquez.rehabilicop.data_access.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.data_access.domain.Opcion;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.domain.Sede;

@Repository
public interface SedeRepository extends JpaRepository<Sede, Long> {   
	
}
