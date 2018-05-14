package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

public interface UsuarioService {
	
	Usuario findOneCliente(UUID idUsuario);
}
