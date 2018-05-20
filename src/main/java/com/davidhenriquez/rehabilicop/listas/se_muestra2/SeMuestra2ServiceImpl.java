package com.davidhenriquez.rehabilicop.listas.se_muestra2;

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
public class SeMuestra2ServiceImpl implements SeMuestra2Service {

	@Autowired
	private SeMuestra2Repository seMuestra2Repository;
	
	public List<SeMuestra2> findAll(){
		return seMuestra2Repository.findAll();
	}
	
	public SeMuestra2 findById(UUID idSeMuestra2){
		return seMuestra2Repository.findOne(idSeMuestra2);
	}
	
	public SeMuestra2 create(SeMuestra2 seMuestra2) throws ValidationException {
		return seMuestra2Repository.save(seMuestra2);		
	}
	
	public SeMuestra2 update(SeMuestra2 seMuestra2) throws ValidationException {		
		return seMuestra2Repository.save(seMuestra2);		
	}

	@Transactional
	public void delete(UUID idSeMuestra2) throws ValidationException {
		seMuestra2Repository.delete(idSeMuestra2);		
	}
}
