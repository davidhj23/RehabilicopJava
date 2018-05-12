package com.davidhenriquez.rehabilicop.listas.tipo_documento;

import java.util.List;

public interface TipoDocumentoService {

	List<TipoDocumento> findAll();

	TipoDocumento findById(Long IdTipoDocumento);

}