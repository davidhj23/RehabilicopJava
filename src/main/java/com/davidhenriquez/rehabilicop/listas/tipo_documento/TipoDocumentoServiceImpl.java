package com.davidhenriquez.rehabilicop.listas.tipo_documento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
