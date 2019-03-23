package com.davidhenriquez.rehabilicop.listas.dosis;

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
public class DosisServiceImpl implements DosisService {

	@Autowired
	private DosisRepository dosisRepository;
	
	public List<Dosis> findAll(){
		return dosisRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Dosis::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Dosis findById(UUID idDosis){
		return dosisRepository.findOne(idDosis);
	}
	
	public Dosis create(Dosis dosis) throws ValidationException {
		return dosisRepository.save(dosis);		
	}
	
	public Dosis update(Dosis dosis) throws ValidationException {
		return dosisRepository.save(dosis);		
	}

	@Transactional
	public void delete(UUID idDosis) throws ValidationException {
		dosisRepository.delete(idDosis);		
	}    
}
