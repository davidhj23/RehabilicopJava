package com.davidhenriquez.rehabilicop.listas.cie10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;

@Service
public class Cie10ServiceImpl implements Cie10Service {

	@Autowired
	private Cie10Repository cie10Repository;
	
	public List<Cie10> findAll(){
		return cie10Repository.findAll().stream()                
		           .sorted(Comparator.comparing(Cie10::getNombre))
		           .collect(Collectors.toList());
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
    	Optional<Cie10> duplicate = findAll().stream()
	        .filter(a -> !a.getIdCie10().equals(cie10.getIdCie10()) &&
	        			 a.getCodigo().equals(cie10.getCodigo()))
	        .findAny();            
    	
    	ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
    	if(duplicate.isPresent()){
    		vaidationResults.add(new ValidationResult("codigo", "Ya existe un Cie 10 con este código"));
    	}
    	
    	return vaidationResults;
    }

	@Override
	public List<Cie10> search(String search) {
		return cie10Repository.findAll().stream()
				.filter(x -> x.getCodigo().contains(search.toUpperCase()) ||
							 x.getNombre().contains(search.toUpperCase()))
				.sorted(Comparator.comparing(Cie10::getNombre))
				.collect(Collectors.toList()); 
	}
}
