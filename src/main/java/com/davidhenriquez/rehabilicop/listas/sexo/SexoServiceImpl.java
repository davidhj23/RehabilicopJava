package com.davidhenriquez.rehabilicop.listas.sexo;

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
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;

@Service
public class SexoServiceImpl implements SexoService {

	@Autowired
	private SexoRepository sexoRepository;
	
	public List<Sexo> findAll(){
		return sexoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Sexo::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Sexo findById(UUID idSexo){
		return sexoRepository.findOne(idSexo);
	}
	
	public Sexo create(Sexo sexo) throws ValidationException {
		return sexoRepository.save(sexo);		
	}
	
	public Sexo update(Sexo sexo) throws ValidationException {
		return sexoRepository.save(sexo);		
	}

	@Transactional
	public void delete(UUID idSexo) throws ValidationException {
		sexoRepository.delete(idSexo);		
	}    
}
