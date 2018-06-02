package com.davidhenriquez.rehabilicop.listas.conciencia;

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
public class ConcienciaServiceImpl implements ConcienciaService {

	@Autowired
	private ConcienciaRepository concienciaRepository;
	
	public List<Conciencia> findAll(){
		return concienciaRepository.findAll();
	}
	
	public Conciencia findById(UUID idConciencia){
		return concienciaRepository.findOne(idConciencia);
	}
	
	public Conciencia create(Conciencia conciencia) throws ValidationException {
		return concienciaRepository.save(conciencia);		
	}
	
	public Conciencia update(Conciencia conciencia) throws ValidationException {
		return concienciaRepository.save(conciencia);		
	}

	@Transactional
	public void delete(UUID idConciencia) throws ValidationException {
		concienciaRepository.delete(idConciencia);		
	}    
}
