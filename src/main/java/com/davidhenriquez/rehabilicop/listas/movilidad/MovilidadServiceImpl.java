package com.davidhenriquez.rehabilicop.listas.movilidad;

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
public class MovilidadServiceImpl implements MovilidadService {

	@Autowired
	private MoilidadRepository MovilidadRepository;
	
	public List<Movilidad> findAll(){
		return MovilidadRepository.findAll();
	}
	
	public Movilidad findById(UUID idMovilidad){
		return MovilidadRepository.findOne(idMovilidad);
	}
	
	public Movilidad create(Movilidad Movilidad) throws ValidationException {
		return MovilidadRepository.save(Movilidad);		
	}
	
	public Movilidad update(Movilidad Movilidad) throws ValidationException {
		return MovilidadRepository.save(Movilidad);		
	}

	@Transactional
	public void delete(UUID idMovilidad) throws ValidationException {
		MovilidadRepository.delete(idMovilidad);		
	}    
}
