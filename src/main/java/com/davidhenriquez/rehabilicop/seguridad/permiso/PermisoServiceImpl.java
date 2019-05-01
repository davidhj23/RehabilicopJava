package com.davidhenriquez.rehabilicop.seguridad.permiso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;

@Service
public class PermisoServiceImpl implements PermisoService {

	@Autowired
	private PermisoRepository permisoRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	public List<Permiso> findAll(){
		return permisoRepository.findAll().stream()                
                .collect(Collectors.toList());
	}
}
