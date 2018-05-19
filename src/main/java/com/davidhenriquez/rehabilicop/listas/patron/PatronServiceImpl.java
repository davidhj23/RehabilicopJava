package com.davidhenriquez.rehabilicop.listas.patron;

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
public class PatronServiceImpl implements PatronService {

	@Autowired
	private PatronRepository patronRepository;
	
	public List<Patron> findAll(){
		return patronRepository.findAll();
	}
	
	public Patron findById(UUID idPatron){
		return patronRepository.findOne(idPatron);
	}
	
	public Patron create(Patron patron) throws ValidationException {
		return patronRepository.save(patron);		
	}
	
	public Patron update(Patron patron) throws ValidationException {		
		return patronRepository.save(patron);		
	}

	@Transactional
	public void delete(UUID idPatron) throws ValidationException {
		patronRepository.delete(idPatron);		
	}
}
