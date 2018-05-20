package com.davidhenriquez.rehabilicop.listas.curso;

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
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		return cursoRepository.findAll();
	}
	
	public Curso findById(UUID idCurso){
		return cursoRepository.findOne(idCurso);
	}
	
	public Curso create(Curso curso) throws ValidationException {
		return cursoRepository.save(curso);		
	}
	
	public Curso update(Curso curso) throws ValidationException {
		return cursoRepository.save(curso);		
	}

	@Transactional
	public void delete(UUID idCurso) throws ValidationException {
		cursoRepository.delete(idCurso);		
	}    
}
