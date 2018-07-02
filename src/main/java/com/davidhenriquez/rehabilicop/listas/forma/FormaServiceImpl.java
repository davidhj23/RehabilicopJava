package com.davidhenriquez.rehabilicop.listas.forma;

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
public class FormaServiceImpl implements FormaService {

	@Autowired
	private FormaRepository formaRepository;
	
	public List<Forma> findAll(){
		return formaRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Forma::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Forma findById(UUID idForma){
		return formaRepository.findOne(idForma);
	}
	
	public Forma create(Forma forma) throws ValidationException {
		return formaRepository.save(forma);		
	}
	
	public Forma update(Forma forma) throws ValidationException {
		return formaRepository.save(forma);		
	}

	@Transactional
	public void delete(UUID idForma) throws ValidationException {
		formaRepository.delete(idForma);		
	}    
}
