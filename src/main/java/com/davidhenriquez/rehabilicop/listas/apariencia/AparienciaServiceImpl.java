package com.davidhenriquez.rehabilicop.listas.apariencia;

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
public class AparienciaServiceImpl implements AparienciaService {

	@Autowired
	private AparienciaRepository aparienciaRepository;
	
	public List<Apariencia> findAll(){
		return aparienciaRepository.findAll();
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
