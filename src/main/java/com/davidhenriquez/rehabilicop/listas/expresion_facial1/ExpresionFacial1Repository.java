package com.davidhenriquez.rehabilicop.listas.expresion_facial1;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Repository
public interface ExpresionFacial1Repository extends JpaRepository<ExpresionFacial1, UUID> {   
	
}
