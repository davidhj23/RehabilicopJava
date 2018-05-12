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
import com.davidhenriquez.rehabilicop.data_access.domain.Sede;
import com.davidhenriquez.rehabilicop.data_access.repositories.OpcionRepository;
import com.davidhenriquez.rehabilicop.data_access.repositories.RolRepository;
import com.davidhenriquez.rehabilicop.data_access.repositories.SedeRepository;

@Service
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRepository sedeRepository;
	
	public List<Sede> findAll(){
		return sedeRepository.findAll();
	}
	
	public Sede findById(Long idSede){
		return sedeRepository.findOne(idSede);
	}
	
	public Sede create(Sede sede) throws ValidationException {
		return sedeRepository.save(sede);		
	}
	
	public Sede update(Sede sede) throws ValidationException {		
		return sedeRepository.save(sede);		
	}

	@Transactional
	public void delete(Long idSede) throws ValidationException {
		sedeRepository.delete(idSede);		
	}
}
