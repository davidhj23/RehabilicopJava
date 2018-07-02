package com.davidhenriquez.rehabilicop.listas.comprensible;

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
public class ComprensibleServiceImpl implements ComprensibleService {

	@Autowired
	private ComprensibleRepository comprensibleRepository;
	
	public List<Comprensible> findAll(){
		return comprensibleRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Comprensible::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Comprensible findById(UUID idComprensible){
		return comprensibleRepository.findOne(idComprensible);
	}
	
	public Comprensible create(Comprensible comprensible) throws ValidationException {
		return comprensibleRepository.save(comprensible);		
	}
	
	public Comprensible update(Comprensible comprensible) throws ValidationException {
		return comprensibleRepository.save(comprensible);		
	}

	@Transactional
	public void delete(UUID idComprensible) throws ValidationException {
		comprensibleRepository.delete(idComprensible);		
	}    
}
