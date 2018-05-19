package com.davidhenriquez.rehabilicop.listas.tono_voz;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.listas.opcion.OpcionRepository;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;

@Service
public class TonoVozServiceImpl implements TonoVozService {

	@Autowired
	private TonoVozRepository sedeRepository;
	
	public List<TonoVoz> findAll(){
		return sedeRepository.findAll();
	}
	
	public TonoVoz findById(UUID idSede){
		return sedeRepository.findOne(idSede);
	}
	
	public TonoVoz create(TonoVoz sede) throws ValidationException {
		return sedeRepository.save(sede);		
	}
	
	public TonoVoz update(TonoVoz sede) throws ValidationException {		
		return sedeRepository.save(sede);		
	}

	@Transactional
	public void delete(UUID idSede) throws ValidationException {
		sedeRepository.delete(idSede);		
	}
}
