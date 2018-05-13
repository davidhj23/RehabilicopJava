package com.davidhenriquez.rehabilicop.listas.tipo_documento;

import java.util.List;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;

public interface TipoDocumentoService {

	List<TipoDocumento> findAll();

	TipoDocumento findById(Long IdTipoDocumento);

	TipoDocumento create(TipoDocumento tipoDocumento) throws ValidationException;
	
	TipoDocumento update(TipoDocumento tipoDocumento) throws ValidationException;

	void delete(Long idTipoDocumento) throws ValidationException;
}