package com.davidhenriquez.rehabilicop.listas.gesta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

@Service
public class GestaServiceImpl implements GestaService {

	@Autowired
	private GestaRepository gestaRepository;
	
	public List<Gesta> findAll(){
		return gestaRepository.findAll();
	}
	
	public Gesta findById(UUID idGesta){
		return gestaRepository.findOne(idGesta);
	}
	
	public Gesta create(Gesta gesta) throws ValidationException {
		return gestaRepository.save(gesta);		
	}
	
	public Gesta update(Gesta gesta) throws ValidationException {
		return gestaRepository.save(gesta);		
	}

	@Transactional
	public void delete(UUID idGesta) throws ValidationException {
		gestaRepository.delete(idGesta);		
	}    
}
