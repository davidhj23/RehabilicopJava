package com.davidhenriquez.rehabilicop.listas.alteracion;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlteracionServiceImpl implements AlteracionService {

	@Autowired
	private AlteracionRepository alteracionRepository;
	
	public List<Alteracion> findAll(){
		return alteracionRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Alteracion::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Alteracion findById(UUID idAlteracion){
		return alteracionRepository.findOne(idAlteracion);
	}
	
	public Alteracion create(Alteracion alteracion) throws ValidationException {
		return alteracionRepository.save(alteracion);		
	}
	
	public Alteracion update(Alteracion alteracion) throws ValidationException {		
		return alteracionRepository.save(alteracion);		
	}

	@Transactional
	public void delete(UUID idAlteracion) throws ValidationException {
		alteracionRepository.delete(idAlteracion);		
	}
}
