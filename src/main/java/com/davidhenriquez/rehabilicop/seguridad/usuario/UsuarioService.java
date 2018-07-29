package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();

	Usuario findById(UUID idUsuario);

	Usuario create(Usuario usuario) throws ValidationException;
	
	Usuario update(Usuario usuario) throws ValidationException;

	void delete(UUID idUsuario) throws ValidationException;
	
	void changePassword(String username, ChangePasswordModel changePasswordModel) throws ValidationException;
	
	void restablecerPassword(UUID idUsuario, RestablecerPasswordModel restablecerPasswordModel) throws ValidationException;
	
	
	List<Usuario> findAllPacientes();

	Usuario findPacienteById(UUID idPaciente);

	Usuario createPaciente(Usuario paciente) throws ValidationException;
	
	Usuario updatePaciente(Usuario paciente) throws ValidationException;

	void deletePaciente(UUID idPaciente) throws ValidationException;
	
	Usuario findPacienteByIdentificacion(String identificacion);

	
	List<Usuario> findAllMedicos();
	
	List<Usuario> findAllEnfermeros();

	Usuario findUserByUsername(String username);
}
