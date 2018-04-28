package com.davidhenriquez.base.business_logic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidhenriquez.base.data_access.domain.TipoDocumento;
import com.davidhenriquez.base.data_access.repositories.TipoDocumentoRepository;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;
	
	public List<TipoDocumento> findAll(){
		return tipoDocumentoRepository.findAll();
	}
	
	public TipoDocumento findById(Long IdTipoDocumento){
		return tipoDocumentoRepository.findOne(IdTipoDocumento);
	}
}
