package com.davidhenriquez.rehabilicop.listas.estado_civil;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

	@Autowired
	private EstadoCivilRepository estadoCivilRepository;
	
	public List<EstadoCivil> findAll(){
		return estadoCivilRepository.findAll().stream()                
		           .sorted(Comparator.comparing(EstadoCivil::getNombre))
		           .collect(Collectors.toList());
	}
	
	public EstadoCivil findById(UUID idEstadoCivil){
		return estadoCivilRepository.findOne(idEstadoCivil);
	}

	public EstadoCivil create(EstadoCivil estadoCivil) throws ValidationException {
		return estadoCivilRepository.save(estadoCivil);		
	}
	
	public EstadoCivil update(EstadoCivil estadoCivil) throws ValidationException {		
		return estadoCivilRepository.save(estadoCivil);		
	}

	@Transactional
	public void delete(UUID idEstadoCivil) throws ValidationException {
		estadoCivilRepository.delete(idEstadoCivil);		
	}
}
