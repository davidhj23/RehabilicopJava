package com.davidhenriquez.rehabilicop.listas.medicamento;

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

@Service
public class MedicamentoServiceImpl implements MedicamentoService {

	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	public List<Medicamento> findAll(){
		return medicamentoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Medicamento::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Medicamento findById(UUID idMedicamento){
		return medicamentoRepository.findOne(idMedicamento);
	}
	
	public Medicamento create(Medicamento medicamento) throws ValidationException {
		return medicamentoRepository.save(medicamento);		
	}
	
	public Medicamento update(Medicamento medicamento) throws ValidationException {
		return medicamentoRepository.save(medicamento);		
	}

	@Transactional
	public void delete(UUID idMedicamento) throws ValidationException {
		medicamentoRepository.delete(idMedicamento);		
	}    
}
