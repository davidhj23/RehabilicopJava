package com.davidhenriquez.rehabilicop.listas.cama;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Repository
public interface CamaRepository extends JpaRepository<Cama, UUID>{
	
}
