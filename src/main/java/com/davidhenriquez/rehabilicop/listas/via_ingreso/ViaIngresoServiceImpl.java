package com.davidhenriquez.rehabilicop.listas.via_ingreso;

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
public class ViaIngresoServiceImpl implements ViaIngresoService {

	@Autowired
	private ViaIngresoRepository viaIngresoRepository;
	
	public List<ViaIngreso> findAll(){
		return viaIngresoRepository.findAll().stream()                
		           .sorted(Comparator.comparing(ViaIngreso::getNombre))
		           .collect(Collectors.toList());
	}
	
	public ViaIngreso findById(UUID idViaIngreso){
		return viaIngresoRepository.findOne(idViaIngreso);
	}
	
	public ViaIngreso create(ViaIngreso viaIngreso) throws ValidationException {
		return viaIngresoRepository.save(viaIngreso);		
	}
	
	public ViaIngreso update(ViaIngreso viaIngreso) throws ValidationException {		
		return viaIngresoRepository.save(viaIngreso);		
	}

	@Transactional
	public void delete(UUID idViaIngreso) throws ValidationException {
		viaIngresoRepository.delete(idViaIngreso);		
	}
}
