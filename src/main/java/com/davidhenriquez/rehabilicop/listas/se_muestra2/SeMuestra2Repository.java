package com.davidhenriquez.rehabilicop.listas.se_muestra2;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface SeMuestra2Repository extends JpaRepository<SeMuestra2, UUID> {   
	
}
