package com.davidhenriquez.rehabilicop.listas.alimentacion;

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
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Service
public class AlimentacionServiceImpl implements AlimentacionService {

	@Autowired
	private AlimentacionRepository alimentacionRepository;
	
	public List<Alimentacion> findAll(){
		return alimentacionRepository.findAll().stream()                
           .sorted(Comparator.comparing(Alimentacion::getNombre))
           .collect(Collectors.toList());
	}
	
	public Alimentacion findById(UUID idAlimentacion){
		return alimentacionRepository.findOne(idAlimentacion);
	}
	
	public Alimentacion create(Alimentacion alimentacion) throws ValidationException {
		return alimentacionRepository.save(alimentacion);		
	}
	
	public Alimentacion update(Alimentacion alimentacion) throws ValidationException {
		return alimentacionRepository.save(alimentacion);		
	}

	@Transactional
	public void delete(UUID idAlimentacion) throws ValidationException {
		alimentacionRepository.delete(idAlimentacion);		
	}    
}
