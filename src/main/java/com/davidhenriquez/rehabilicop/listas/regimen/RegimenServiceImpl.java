package com.davidhenriquez.rehabilicop.listas.regimen;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

@Service
public class RegimenServiceImpl implements RegimenService {

	@Autowired
	private RegimenRepository regimenRepository;
	
	public List<Regimen> findAll(){
		return regimenRepository.findAll();
	}
	
	public Regimen findById(UUID idRegimen){
		return regimenRepository.findOne(idRegimen);
	}
	
	public Regimen create(Regimen regimen) throws ValidationException {
		return regimenRepository.save(regimen);		
	}
	
	public Regimen update(Regimen regimen) throws ValidationException {
		return regimenRepository.save(regimen);		
	}

	@Transactional
	public void delete(UUID idRegimen) throws ValidationException {
		regimenRepository.delete(idRegimen);		
	}    
}
