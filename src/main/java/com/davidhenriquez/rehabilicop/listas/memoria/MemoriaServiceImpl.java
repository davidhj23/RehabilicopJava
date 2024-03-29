package com.davidhenriquez.rehabilicop.listas.memoria;

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
public class MemoriaServiceImpl implements MemoriaService {

	@Autowired
	private MemoriaRepository memoriaRepository;
	
	public List<Memoria> findAll(){
		return memoriaRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Memoria::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Memoria findById(UUID idMemoria){
		return memoriaRepository.findOne(idMemoria);
	}
	
	public Memoria create(Memoria memoria) throws ValidationException {
		return memoriaRepository.save(memoria);		
	}
	
	public Memoria update(Memoria memoria) throws ValidationException {
		return memoriaRepository.save(memoria);		
	}

	@Transactional
	public void delete(UUID idMemoria) throws ValidationException {
		memoriaRepository.delete(idMemoria);		
	}    
}
