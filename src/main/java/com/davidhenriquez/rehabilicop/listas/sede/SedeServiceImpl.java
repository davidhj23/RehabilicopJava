package com.davidhenriquez.rehabilicop.listas.sede;

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
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.listas.opcion.OpcionRepository;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Service
public class SedeServiceImpl implements SedeService {

	@Autowired
	private SedeRepository sedeRepository;
	
	public List<Sede> findAll(){
		return sedeRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Sede::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Sede findById(UUID idSede){
		return sedeRepository.findOne(idSede);
	}
	
	public Sede create(Sede sede) throws ValidationException {
		return sedeRepository.save(sede);		
	}
	
	public Sede update(Sede sede) throws ValidationException {		
		return sedeRepository.save(sede);		
	}

	@Transactional
	public void delete(UUID idSede) throws ValidationException {
		sedeRepository.delete(idSede);		
	}
}
