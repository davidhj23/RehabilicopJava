package com.davidhenriquez.rehabilicop.listas.parentesco;

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
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;

@Service
public class ParentescoServiceImpl implements ParentescoService {

	@Autowired
	private ParentescoRepository parentescoRepository;
	
	public List<Parentesco> findAll(){
		return parentescoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Parentesco::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Parentesco findById(UUID idParentesco){
		return parentescoRepository.findOne(idParentesco);
	}
	
	public Parentesco create(Parentesco parentesco) throws ValidationException {
		return parentescoRepository.save(parentesco);		
	}
	
	public Parentesco update(Parentesco parentesco) throws ValidationException {
		return parentescoRepository.save(parentesco);		
	}

	@Transactional
	public void delete(UUID idParentesco) throws ValidationException {
		parentescoRepository.delete(idParentesco);		
	}    
}
