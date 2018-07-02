package com.davidhenriquez.rehabilicop.listas.estado_conciencia;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class EstadoConcienciaServiceImpl implements EstadoConcienciaService {

	@Autowired
	private EstadoConcienciaRepository estadoConcienciaRepository;
	
	public List<EstadoConciencia> findAll(){
		return estadoConcienciaRepository.findAll().stream()                
		           .sorted(Comparator.comparing(EstadoConciencia::getNombre))
		           .collect(Collectors.toList());
	}
	
	public EstadoConciencia findById(UUID idEstadoConciencia){
		return estadoConcienciaRepository.findOne(idEstadoConciencia);
	}

	public EstadoConciencia create(EstadoConciencia estadoConciencia) throws ValidationException {
		return estadoConcienciaRepository.save(estadoConciencia);		
	}
	
	public EstadoConciencia update(EstadoConciencia estadoConciencia) throws ValidationException {		
		return estadoConcienciaRepository.save(estadoConciencia);		
	}

	@Transactional
	public void delete(UUID idEstadoConciencia) throws ValidationException {
		estadoConcienciaRepository.delete(idEstadoConciencia);		
	}
}
