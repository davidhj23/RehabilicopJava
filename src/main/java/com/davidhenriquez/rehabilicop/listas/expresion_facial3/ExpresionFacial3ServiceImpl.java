package com.davidhenriquez.rehabilicop.listas.expresion_facial3;

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
public class ExpresionFacial3ServiceImpl implements ExpresionFacial3Service {

	@Autowired
	private ExpresionFacial3Repository expresionFacial3Repository;
	
	public List<ExpresionFacial3> findAll(){
		return expresionFacial3Repository.findAll().stream()                
		           .sorted(Comparator.comparing(ExpresionFacial3::getNombre))
		           .collect(Collectors.toList());
	}
	
	public ExpresionFacial3 findById(UUID idExpresionFacial3){
		return expresionFacial3Repository.findOne(idExpresionFacial3);
	}
	
	public ExpresionFacial3 create(ExpresionFacial3 expresionFacial3) throws ValidationException {
		return expresionFacial3Repository.save(expresionFacial3);		
	}
	
	public ExpresionFacial3 update(ExpresionFacial3 expresionFacial3) throws ValidationException {		
		return expresionFacial3Repository.save(expresionFacial3);		
	}

	@Transactional
	public void delete(UUID idExpresionFacial3) throws ValidationException {
		expresionFacial3Repository.delete(idExpresionFacial3);		
	}
}
