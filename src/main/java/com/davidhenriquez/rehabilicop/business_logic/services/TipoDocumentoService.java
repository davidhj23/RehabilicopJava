package com.davidhenriquez.rehabilicop.business_logic.services;

import java.util.List;

import com.davidhenriquez.rehabilicop.data_access.domain.TipoDocumento;

public interface TipoDocumentoService {

	List<TipoDocumento> findAll();

	TipoDocumento findById(Long IdTipoDocumento);

}