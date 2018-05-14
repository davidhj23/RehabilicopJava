package com.davidhenriquez.rehabilicop.listas.tipo_documento;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public List<TipoDocumento> findAll(){
		return tipoDocumentoRepository.findAll();
	}
	
	public TipoDocumento findById(UUID IdTipoDocumento){
		return tipoDocumentoRepository.findOne(IdTipoDocumento);
	}

	public TipoDocumento create(TipoDocumento tipoDocumento) throws ValidationException {
		return tipoDocumentoRepository.save(tipoDocumento);		
	}
	
	public TipoDocumento update(TipoDocumento tipoDocumento) throws ValidationException {		
		return tipoDocumentoRepository.save(tipoDocumento);		
	}

	@Transactional
	public void delete(UUID idTipoDocumento) throws ValidationException {
		tipoDocumentoRepository.delete(idTipoDocumento);		
	}
}
