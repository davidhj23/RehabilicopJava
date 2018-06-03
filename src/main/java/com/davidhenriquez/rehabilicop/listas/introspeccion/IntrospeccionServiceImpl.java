package com.davidhenriquez.rehabilicop.listas.introspeccion;

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
public class IntrospeccionServiceImpl implements IntrospeccionService {

	@Autowired
	private IntrospeccionRepository introspeccionRepository;
	
	public List<Introspeccion> findAll(){
		return introspeccionRepository.findAll();
	}
	
	public Introspeccion findById(UUID idIntrospeccion){
		return introspeccionRepository.findOne(idIntrospeccion);
	}
	
	public Introspeccion create(Introspeccion introspeccion) throws ValidationException {
		return introspeccionRepository.save(introspeccion);		
	}
	
	public Introspeccion update(Introspeccion introspeccion) throws ValidationException {
		return introspeccionRepository.save(introspeccion);		
	}

	@Transactional
	public void delete(UUID idIntrospeccion) throws ValidationException {
		introspeccionRepository.delete(idIntrospeccion);		
	}    
}
