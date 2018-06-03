package com.davidhenriquez.rehabilicop.listas.asfixia;

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
public class AsfixiaServiceImpl implements AsfixiaService {

	@Autowired
	private AsfixiaRepository asfixiaRepository;
	
	public List<Asfixia> findAll(){
		return asfixiaRepository.findAll();
	}
	
	public Asfixia findById(UUID idAsfixia){
		return asfixiaRepository.findOne(idAsfixia);
	}
	
	public Asfixia create(Asfixia asfixia) throws ValidationException {
		return asfixiaRepository.save(asfixia);		
	}
	
	public Asfixia update(Asfixia asfixia) throws ValidationException {
		return asfixiaRepository.save(asfixia);		
	}

	@Transactional
	public void delete(UUID idAsfixia) throws ValidationException {
		asfixiaRepository.delete(idAsfixia);		
	}    
}
