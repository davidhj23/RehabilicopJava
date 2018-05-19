package com.davidhenriquez.rehabilicop.listas.servicio;

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
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository servicioRepository;
	
	public List<Servicio> findAll(){
		return servicioRepository.findAll();
	}
	
	public Servicio findById(UUID idServicio){
		return servicioRepository.findOne(idServicio);
	}
	
	public Servicio create(Servicio servicio) throws ValidationException {
		return servicioRepository.save(servicio);		
	}
	
	public Servicio update(Servicio servicio) throws ValidationException {		
		return servicioRepository.save(servicio);		
	}

	@Transactional
	public void delete(UUID idServicio) throws ValidationException {
		servicioRepository.delete(idServicio);		
	}
}
