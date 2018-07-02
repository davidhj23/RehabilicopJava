package com.davidhenriquez.rehabilicop.listas.estado;

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
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> findAll(){
		return estadoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Estado::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Estado findById(UUID idEstado){
		return estadoRepository.findOne(idEstado);
	}
	
	public Estado create(Estado estado) throws ValidationException {
		return estadoRepository.save(estado);		
	}
	
	public Estado update(Estado estado) throws ValidationException {
		return estadoRepository.save(estado);		
	}

	@Transactional
	public void delete(UUID idEstado) throws ValidationException {
		estadoRepository.delete(idEstado);		
	}    
}
