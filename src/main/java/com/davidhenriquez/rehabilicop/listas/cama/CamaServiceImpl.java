package com.davidhenriquez.rehabilicop.listas.cama;

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
public class CamaServiceImpl implements CamaService {

	@Autowired
	private CamaRepository camaRepository;
	
	public List<Cama> findAll(){
		return camaRepository.findAll();
	}
	
	public Cama findById(UUID idCama){
		return camaRepository.findOne(idCama);
	}
	
	public Cama create(Cama cama) throws ValidationException {
		return camaRepository.save(cama);		
	}
	
	public Cama update(Cama cama) throws ValidationException {
		return camaRepository.save(cama);		
	}

	@Transactional
	public void delete(UUID idCama) throws ValidationException {
		camaRepository.delete(idCama);		
	}    
}
