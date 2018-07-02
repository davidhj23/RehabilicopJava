package com.davidhenriquez.rehabilicop.listas.se_muestra1;

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
public class SeMuestra1ServiceImpl implements SeMuestra1Service {

	@Autowired
	private SeMuestra1Repository seMuestra1Repository;
	
	public List<SeMuestra1> findAll(){
		return seMuestra1Repository.findAll().stream()                
		           .sorted(Comparator.comparing(SeMuestra1::getNombre))
		           .collect(Collectors.toList());
	}
	
	public SeMuestra1 findById(UUID idSeMuestra1){
		return seMuestra1Repository.findOne(idSeMuestra1);
	}
	
	public SeMuestra1 create(SeMuestra1 seMuestra1) throws ValidationException {
		return seMuestra1Repository.save(seMuestra1);		
	}
	
	public SeMuestra1 update(SeMuestra1 seMuestra1) throws ValidationException {		
		return seMuestra1Repository.save(seMuestra1);		
	}

	@Transactional
	public void delete(UUID idSeMuestra1) throws ValidationException {
		seMuestra1Repository.delete(idSeMuestra1);		
	}
}
