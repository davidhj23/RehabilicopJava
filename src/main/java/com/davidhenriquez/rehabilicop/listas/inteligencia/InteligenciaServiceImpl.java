package com.davidhenriquez.rehabilicop.listas.inteligencia;

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
public class InteligenciaServiceImpl implements InteligenciaService {

	@Autowired
	private InteligenciaRepository inteligenciaRepository;
	
	public List<Inteligencia> findAll(){
		return inteligenciaRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Inteligencia::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Inteligencia findById(UUID idInteligencia){
		return inteligenciaRepository.findOne(idInteligencia);
	}
	
	public Inteligencia create(Inteligencia inteligencia) throws ValidationException {
		return inteligenciaRepository.save(inteligencia);		
	}
	
	public Inteligencia update(Inteligencia inteligencia) throws ValidationException {
		return inteligenciaRepository.save(inteligencia);		
	}

	@Transactional
	public void delete(UUID idInteligencia) throws ValidationException {
		inteligenciaRepository.delete(idInteligencia);		
	}    
}
