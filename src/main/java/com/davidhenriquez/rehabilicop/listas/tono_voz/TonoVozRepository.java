package com.davidhenriquez.rehabilicop.listas.tono_voz;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface TonoVozRepository extends JpaRepository<TonoVoz, UUID> {   
	
}
