package com.davidhenriquez.base.business_logic.services;

import java.util.List;

import com.davidhenriquez.base.data_access.domain.TipoDocumento;

public interface TipoDocumentoService {

	List<TipoDocumento> findAll();

	TipoDocumento findById(Long IdTipoDocumento);

}