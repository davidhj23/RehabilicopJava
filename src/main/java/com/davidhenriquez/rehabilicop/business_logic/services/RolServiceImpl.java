package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.repositories.RolRepository;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	public List<Rol> findAll(){
		return rolRepository.findAll().stream()
                .filter(x -> x.getIdRol() != 1)                    
                .collect(Collectors.toList());
	}
	
	public Rol findById(Long idRol){
		return rolRepository.findOne(idRol);
	}
	
	public Rol create(Rol rol) throws ValidationException {
		return rolRepository.save(rol);		
	}
	
	public Rol update(Rol rol) throws ValidationException {		
		return rolRepository.save(rol);		
	}

	@Transactional
	public void delete(Long idRol) throws ValidationException {
		rolRepository.delete(idRol);		
	}
}
