package com.davidhenriquez.rehabilicop.seguridad.rol;

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

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> findAll(){
		return rolRepository.findAll().stream()
                .filter(x -> !x.getNombre().equals("admin global") && 
                			 !x.getNombre().equals("Paciente"))
                .sorted(Comparator.comparing(Rol::getNombre))
                .collect(Collectors.toList());
	}
	
	public Rol findById(UUID idRol){
		return rolRepository.findOne(idRol);
	}
	
	public Rol create(Rol rol) throws ValidationException {
		return rolRepository.save(rol);		
	}
	
	public Rol update(Rol rol) throws ValidationException {		
		return rolRepository.save(rol);		
	}

	@Transactional
	public void delete(UUID idRol) throws ValidationException {
		rolRepository.delete(idRol);		
	}
}
