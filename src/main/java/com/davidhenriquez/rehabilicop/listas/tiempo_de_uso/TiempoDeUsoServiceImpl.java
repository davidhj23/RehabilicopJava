package com.davidhenriquez.rehabilicop.listas.tiempo_de_uso;

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
public class TiempoDeUsoServiceImpl implements TiempoDeUsoService {

	@Autowired
	private TiempoDeUsoRepository tiempoDeUsoRepository;
	
	public List<TiempoDeUso> findAll(){
		return tiempoDeUsoRepository.findAll();
	}
	
	public TiempoDeUso findById(UUID idTiempoDeUso){
		return tiempoDeUsoRepository.findOne(idTiempoDeUso);
	}
	
	public TiempoDeUso create(TiempoDeUso tiempoDeUso) throws ValidationException {
		return tiempoDeUsoRepository.save(tiempoDeUso);		
	}
	
	public TiempoDeUso update(TiempoDeUso tiempoDeUso) throws ValidationException {
		return tiempoDeUsoRepository.save(tiempoDeUso);		
	}

	@Transactional
	public void delete(UUID idTiempoDeUso) throws ValidationException {
		tiempoDeUsoRepository.delete(idTiempoDeUso);		
	}    
}
