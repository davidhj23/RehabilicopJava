package com.davidhenriquez.rehabilicop.listas.cie10;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;

@Service
public class Cie10ServiceImpl implements Cie10Service {

	@Autowired
	private Cie10Repository cie10Repository;
	
	public List<Cie10> findAll(){
		return cie10Repository.findAll();
	}
	
	public Cie10 findById(UUID idCie10){
		return cie10Repository.findOne(idCie10);
	}
	
	public Cie10 create(Cie10 cie10) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(cie10);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		return cie10Repository.save(cie10);		
	}
	
	public Cie10 update(Cie10 cie10) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(cie10);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		return cie10Repository.save(cie10);		
	}

	@Transactional
	public void delete(UUID idCie10) throws ValidationException {
		cie10Repository.delete(idCie10);		
	}
	
    private ArrayList<ValidationResult> validarDuplicado(Cie10 cie10)
    {
    	Cie10 duplicate = findAll().stream()
	        .filter(a -> a.getCodigo() == cie10.getCodigo() &&
	                     a.getIdCie10() != cie10.getIdCie10())
	        .findFirst()
            .get();
    	
    	ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
    	if(duplicate == null){
    		vaidationResults.add(new ValidationResult("codigo", "Ya existe un Cie 10 con este c�digo"));
    	}
    	
    	return vaidationResults;
    }
}