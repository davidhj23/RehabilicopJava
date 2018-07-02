package com.davidhenriquez.rehabilicop.listas.expresion_facial2;

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
public class ExpresionFacial2ServiceImpl implements ExpresionFacial2Service {

	@Autowired
	private ExpresionFacial2Repository expresionFacial2Repository;
	
	public List<ExpresionFacial2> findAll(){
		return expresionFacial2Repository.findAll().stream()                
		           .sorted(Comparator.comparing(ExpresionFacial2::getNombre))
		           .collect(Collectors.toList());
	}
	
	public ExpresionFacial2 findById(UUID idExpresionFacial2){
		return expresionFacial2Repository.findOne(idExpresionFacial2);
	}
	
	public ExpresionFacial2 create(ExpresionFacial2 expresionFacial2) throws ValidationException {
		return expresionFacial2Repository.save(expresionFacial2);		
	}
	
	public ExpresionFacial2 update(ExpresionFacial2 expresionFacial2) throws ValidationException {		
		return expresionFacial2Repository.save(expresionFacial2);		
	}

	@Transactional
	public void delete(UUID idExpresionFacial2) throws ValidationException {
		expresionFacial2Repository.delete(idExpresionFacial2);		
	}
}
