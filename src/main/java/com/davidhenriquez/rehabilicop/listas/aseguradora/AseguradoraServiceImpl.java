package com.davidhenriquez.rehabilicop.listas.aseguradora;

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
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;

@Service
public class AseguradoraServiceImpl implements AseguradoraService {

	@Autowired
	private AseguradoraRepository aseguradoraRepository;
	
	public List<Aseguradora> findAll(){
		return aseguradoraRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Aseguradora::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Aseguradora findById(UUID idAseguradora){
		return aseguradoraRepository.findOne(idAseguradora);
	}
	
	public Aseguradora create(Aseguradora aseguradora) throws ValidationException {
		return aseguradoraRepository.save(aseguradora);		
	}
	
	public Aseguradora update(Aseguradora aseguradora) throws ValidationException {
		return aseguradoraRepository.save(aseguradora);		
	}

	@Transactional
	public void delete(UUID idAseguradora) throws ValidationException {
		aseguradoraRepository.delete(idAseguradora);		
	}    
}
