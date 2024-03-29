package com.davidhenriquez.rehabilicop.listas.humor;

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
public class HumorServiceImpl implements HumorService {

	@Autowired
	private HumorRepository humorRepository;
	
	public List<Humor> findAll(){
		return humorRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Humor::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Humor findById(UUID idHumor){
		return humorRepository.findOne(idHumor);
	}
	
	public Humor create(Humor humor) throws ValidationException {
		return humorRepository.save(humor);		
	}
	
	public Humor update(Humor humor) throws ValidationException {
		return humorRepository.save(humor);		
	}

	@Transactional
	public void delete(UUID idHumor) throws ValidationException {
		humorRepository.delete(idHumor);		
	}    
}
