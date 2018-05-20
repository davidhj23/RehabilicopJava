package com.davidhenriquez.rehabilicop.listas.se_muestra1;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface SeMuestra1Repository extends JpaRepository<SeMuestra1, UUID> {   
	
}
