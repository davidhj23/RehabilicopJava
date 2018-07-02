package com.davidhenriquez.rehabilicop.listas.memoria2;

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
public class Memoria2ServiceImpl implements Memoria2Service {

	@Autowired
	private Memoria2Repository memoria2Repository;
	
	public List<Memoria2> findAll(){
		return memoria2Repository.findAll().stream()                
		           .sorted(Comparator.comparing(Memoria2::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Memoria2 findById(UUID idMemoria2){
		return memoria2Repository.findOne(idMemoria2);
	}
	
	public Memoria2 create(Memoria2 memoria2) throws ValidationException {
		return memoria2Repository.save(memoria2);		
	}
	
	public Memoria2 update(Memoria2 memoria2) throws ValidationException {
		return memoria2Repository.save(memoria2);		
	}

	@Transactional
	public void delete(UUID idMemoria2) throws ValidationException {
		memoria2Repository.delete(idMemoria2);		
	}    
}
