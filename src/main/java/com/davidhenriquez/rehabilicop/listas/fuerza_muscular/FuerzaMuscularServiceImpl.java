package com.davidhenriquez.rehabilicop.listas.fuerza_muscular;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;

@Service
public class FuerzaMuscularServiceImpl implements FuerzaMuscularService {

	@Autowired
	private FuerzaMuscularRepository fuerzaMuscularRepository;
	
	public List<FuerzaMuscular> findAll(){
		return fuerzaMuscularRepository.findAll().stream()                
		           .sorted(Comparator.comparing(FuerzaMuscular::getNombre))
		           .collect(Collectors.toList());
	}
	
	public FuerzaMuscular findById(UUID idFuerzaMuscular){
		return fuerzaMuscularRepository.findOne(idFuerzaMuscular);
	}

	public FuerzaMuscular create(FuerzaMuscular fuerzaMuscular) throws ValidationException {
		return fuerzaMuscularRepository.save(fuerzaMuscular);		
	}
	
	public FuerzaMuscular update(FuerzaMuscular fuerzaMuscular) throws ValidationException {		
		return fuerzaMuscularRepository.save(fuerzaMuscular);		
	}

	@Transactional
	public void delete(UUID idFuerzaMuscular) throws ValidationException {
		fuerzaMuscularRepository.delete(idFuerzaMuscular);		
	}
}
