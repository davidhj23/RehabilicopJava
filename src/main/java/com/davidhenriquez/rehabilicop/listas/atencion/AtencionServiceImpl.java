package com.davidhenriquez.rehabilicop.listas.atencion;

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
public class AtencionServiceImpl implements AtencionService {

	@Autowired
	private AtencionRepository atencionRepository;
	
	public List<Atencion> findAll(){
		return atencionRepository.findAll();
	}
	
	public Atencion findById(UUID idAtencion){
		return atencionRepository.findOne(idAtencion);
	}
	
	public Atencion create(Atencion atencion) throws ValidationException {
		return atencionRepository.save(atencion);		
	}
	
	public Atencion update(Atencion atencion) throws ValidationException {
		return atencionRepository.save(atencion);		
	}

	@Transactional
	public void delete(UUID idAtencion) throws ValidationException {
		atencionRepository.delete(idAtencion);		
	}    
}
