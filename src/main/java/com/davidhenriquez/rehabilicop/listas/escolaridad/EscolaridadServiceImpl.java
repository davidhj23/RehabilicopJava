package com.davidhenriquez.rehabilicop.listas.escolaridad;

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
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class EscolaridadServiceImpl implements EscolaridadService {

	@Autowired
	private EscolaridadRepository escolaridadRepository;
	
	public List<Escolaridad> findAll(){
		return escolaridadRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Escolaridad::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Escolaridad findById(UUID idEscolaridad){
		return escolaridadRepository.findOne(idEscolaridad);
	}
	
	public Escolaridad create(Escolaridad escolaridad) throws ValidationException {
		return escolaridadRepository.save(escolaridad);		
	}
	
	public Escolaridad update(Escolaridad escolaridad) throws ValidationException {
		return escolaridadRepository.save(escolaridad);		
	}

	@Transactional
	public void delete(UUID idEscolaridad) throws ValidationException {
		escolaridadRepository.delete(idEscolaridad);		
	}    
}
