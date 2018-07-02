package com.davidhenriquez.rehabilicop.listas.tono_voz;

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
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.listas.opcion.OpcionRepository;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Service
public class TonoVozServiceImpl implements TonoVozService {

	@Autowired
	private TonoVozRepository tonoVozRepository;
	
	public List<TonoVoz> findAll(){
		return tonoVozRepository.findAll().stream()                
		           .sorted(Comparator.comparing(TonoVoz::getNombre))
		           .collect(Collectors.toList());
	}
	
	public TonoVoz findById(UUID idTonoVoz){
		return tonoVozRepository.findOne(idTonoVoz);
	}
	
	public TonoVoz create(TonoVoz tonoVoz) throws ValidationException {
		return tonoVozRepository.save(tonoVoz);		
	}
	
	public TonoVoz update(TonoVoz tonoVoz) throws ValidationException {		
		return tonoVozRepository.save(tonoVoz);		
	}

	@Transactional
	public void delete(UUID idTonoVoz) throws ValidationException {
		tonoVozRepository.delete(idTonoVoz);		
	}
}
