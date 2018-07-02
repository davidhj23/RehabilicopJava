package com.davidhenriquez.rehabilicop.listas.opcion;

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
public class OpcionServiceImpl implements OpcionService {

	@Autowired
	private OpcionRepository opcionRepository;
	
	public List<Opcion> findAll(){
		return opcionRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Opcion::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Opcion findById(UUID idOpcion){
		return opcionRepository.findOne(idOpcion);
	}
	
	public Opcion create(Opcion opcion) throws ValidationException {
		return opcionRepository.save(opcion);		
	}
	
	public Opcion update(Opcion opcion) throws ValidationException {		
		return opcionRepository.save(opcion);		
	}

	@Transactional
	public void delete(UUID idOpcion) throws ValidationException {
		opcionRepository.delete(idOpcion);		
	}
}
