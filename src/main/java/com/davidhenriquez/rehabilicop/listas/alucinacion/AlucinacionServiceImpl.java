package com.davidhenriquez.rehabilicop.listas.alucinacion;

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
public class AlucinacionServiceImpl implements AlucinacionService {

	@Autowired
	private AlucinacionRepository alucinacionRepository;
	
	public List<Alucinacion> findAll(){
		return alucinacionRepository.findAll();
	}
	
	public Alucinacion findById(UUID idAlucinacion){
		return alucinacionRepository.findOne(idAlucinacion);
	}
	
	public Alucinacion create(Alucinacion alucinacion) throws ValidationException {
		return alucinacionRepository.save(alucinacion);		
	}
	
	public Alucinacion update(Alucinacion alucinacion) throws ValidationException {
		return alucinacionRepository.save(alucinacion);		
	}

	@Transactional
	public void delete(UUID idAlucinacion) throws ValidationException {
		alucinacionRepository.delete(idAlucinacion);		
	}    
}
