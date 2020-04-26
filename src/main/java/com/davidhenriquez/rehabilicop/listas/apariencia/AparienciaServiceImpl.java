package com.davidhenriquez.rehabilicop.listas.apariencia;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AparienciaServiceImpl implements AparienciaService {

	@Autowired
	private AparienciaRepository aparienciaRepository;
	
	public List<Apariencia> findAll(){
		return aparienciaRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Apariencia::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Apariencia findById(UUID idApariencia){
		return aparienciaRepository.findOne(idApariencia);
	}
	
	public Apariencia create(Apariencia apariencia) throws ValidationException {
		return aparienciaRepository.save(apariencia);		
	}
	
	public Apariencia update(Apariencia apariencia) throws ValidationException {
		return aparienciaRepository.save(apariencia);		
	}

	@Transactional
	public void delete(UUID idApariencia) throws ValidationException {
		aparienciaRepository.delete(idApariencia);		
	}    
}
