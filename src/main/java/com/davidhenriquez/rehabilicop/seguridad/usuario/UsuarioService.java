package com.davidhenriquez.rehabilicop.seguridad.usuario;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

public interface UsuarioService {
	
	List<Usuario> findAll();

	Usuario findById(UUID idUsuario);

	Usuario create(Usuario usuario) throws ValidationException;
	
	Usuario update(Usuario usuario) throws ValidationException;

	void delete(UUID idUsuario) throws ValidationException;
	
	void changePassword(String username, ChangePasswordModel changePasswordModel) throws ValidationException;
	
	void restablecerPassword(UUID idUsuario, RestablecerPasswordModel restablecerPasswordModel) throws ValidationException;
	
	Usuario reabrirUltimaHistoria(Usuario usuario) throws ValidationException;
	
	
	List<Usuario> findAllPacientes();

	Usuario findPacienteById(UUID idPaciente);

	Usuario createPaciente(Usuario paciente) throws ValidationException;
	
	Usuario updatePaciente(Usuario paciente) throws ValidationException;

	void deletePaciente(UUID idPaciente) throws ValidationException;
	
	Usuario findPacienteByIdentificacion(String identificacion);
	
	List<Usuario> findPacientesByNombresApellidos(String search);
	
	
	List<Usuario> findAllMedicos();
	
	List<Usuario> findAllJefesEnfermerias();
	
	List<Usuario> findAllEnfermeros();
	
	List<Usuario> findAllPsiquiatras();
	
	List<Usuario> findAllMedicosyPsiquiatras();
	
	List<Usuario> findAllAuditores();
	
	List<Usuario> findAllAuxiliaresFarmacia();

	Usuario findUserByUsername(String username);
	

	byte[] generateReporteHistoria(String idAdmision) throws SQLException;
	
	byte[] generateReporteEvoluciones(String idAdmision) throws SQLException;
	
	byte[] generateReporteEvoluciones2(String idAdmision, Date fechaInicio, Date fechaFin) throws SQLException;
	
	byte[] generateReporteOrdenesMedicas(String idAdmision) throws SQLException;
	
	byte[] generateReportEpicrisis(String idAdmision) throws SQLException;
	
	byte[] generateReportNotas(String idAdmision) throws SQLException;
	
}
