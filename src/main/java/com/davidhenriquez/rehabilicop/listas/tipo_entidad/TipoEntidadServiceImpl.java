package com.davidhenriquez.rehabilicop.listas.tipo_entidad;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

@Service
public class TipoEntidadServiceImpl implements TipoEntidadService {

	@Autowired
	private TipoEntidadRepository tipoEntidadRepository;
	
	public List<TipoEntidad> findAll(){
		return tipoEntidadRepository.findAll();
	}
	
	public TipoEntidad findById(UUID idTipoEntidad){
		return tipoEntidadRepository.findOne(idTipoEntidad);
	}

	public TipoEntidad create(TipoEntidad tipoEntidad) throws ValidationException {
		return tipoEntidadRepository.save(tipoEntidad);		
	}
	
	public TipoEntidad update(TipoEntidad tipoEntidad) throws ValidationException {		
		return tipoEntidadRepository.save(tipoEntidad);		
	}

	@Transactional
	public void delete(UUID idTipoEntidad) throws ValidationException {
		tipoEntidadRepository.delete(idTipoEntidad);		
	}
}
