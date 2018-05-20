package com.davidhenriquez.rehabilicop.listas.expresion_facial1;

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
public class ExpresionFacial1ServiceImpl implements ExpresionFacial1Service {

	@Autowired
	private ExpresionFacial1Repository expresionFacial1Repository;
	
	public List<ExpresionFacial1> findAll(){
		return expresionFacial1Repository.findAll();
	}
	
	public ExpresionFacial1 findById(UUID idExpresionFacial1){
		return expresionFacial1Repository.findOne(idExpresionFacial1);
	}
	
	public ExpresionFacial1 create(ExpresionFacial1 expresionFacial1) throws ValidationException {
		return expresionFacial1Repository.save(expresionFacial1);		
	}
	
	public ExpresionFacial1 update(ExpresionFacial1 expresionFacial1) throws ValidationException {		
		return expresionFacial1Repository.save(expresionFacial1);		
	}

	@Transactional
	public void delete(UUID idExpresionFacial1) throws ValidationException {
		expresionFacial1Repository.delete(idExpresionFacial1);		
	}
}
