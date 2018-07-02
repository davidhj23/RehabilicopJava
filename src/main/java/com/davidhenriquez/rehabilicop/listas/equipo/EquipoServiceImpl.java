package com.davidhenriquez.rehabilicop.listas.equipo;

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
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class EquipoServiceImpl implements EquipoService {

	@Autowired
	private EquipoRepository equipoRepository;
	
	public List<Equipo> findAll(){
		return equipoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Equipo::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Equipo findById(UUID idEquipo){
		return equipoRepository.findOne(idEquipo);
	}
	
	public Equipo create(Equipo equipo) throws ValidationException {
		return equipoRepository.save(equipo);		
	}
	
	public Equipo update(Equipo equipo) throws ValidationException {
		return equipoRepository.save(equipo);		
	}

	@Transactional
	public void delete(UUID idEquipo) throws ValidationException {
		equipoRepository.delete(idEquipo);		
	}    
}
