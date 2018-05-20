package com.davidhenriquez.rehabilicop.listas.marcha;

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
public class MarchaServiceImpl implements MarchaService {

	@Autowired
	private MarchaRepository marchaRepository;
	
	public List<Marcha> findAll(){
		return marchaRepository.findAll();
	}
	
	public Marcha findById(UUID idMarcha){
		return marchaRepository.findOne(idMarcha);
	}
	
	public Marcha create(Marcha marcha) throws ValidationException {
		return marchaRepository.save(marcha);		
	}
	
	public Marcha update(Marcha marcha) throws ValidationException {
		return marchaRepository.save(marcha);		
	}

	@Transactional
	public void delete(UUID idMarcha) throws ValidationException {
		marchaRepository.delete(idMarcha);		
	}    
}
