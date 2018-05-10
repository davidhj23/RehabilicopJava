package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationException;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.data_access.domain.Opcion;
import com.davidhenriquez.rehabilicop.data_access.domain.Rol;
import com.davidhenriquez.rehabilicop.data_access.repositories.OpcionRepository;
import com.davidhenriquez.rehabilicop.data_access.repositories.RolRepository;

@Service
public class OpcionServiceImpl implements OpcionService {

	@Autowired
	private OpcionRepository opcionRepository;
	
	public List<Opcion> findAll(){
		return opcionRepository.findAll();
	}
	
	public Opcion findById(Long idOpcion){
		return opcionRepository.findOne(idOpcion);
	}
	
	public Opcion create(Opcion opcion) throws ValidationException {
		return opcionRepository.save(opcion);		
	}
	
	public Opcion update(Opcion opcion) throws ValidationException {		
		return opcionRepository.save(opcion);		
	}

	@Transactional
	public void delete(Long idOpcion) throws ValidationException {
		opcionRepository.delete(idOpcion);		
	}
}
