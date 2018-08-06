package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class HistoriaServiceImpl implements HistoriaService{

	@Autowired
	private HistoriaRepository historiaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ArrayList<ValidationResult> validar(Historia historia)
    {
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		
		/*Usuario paciente = usuarioRepository.findOne(historia.getPaciente().getIdUsuario());		
		if(paciente == null)
			validationResults.add(new ValidationResult("paciente", "No se encontr� un paciente con esa identificaci�n"));*/
			
        return validationResults;
    }

	private ArrayList<ValidationResult> validarDuplicado(Historia historia)
    {	
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		
		/*Optional<Historia> numeroRemisionDuplicado = historiaRepository.findAll().stream()
		        .filter(a -> !a.getIdHistoria().equals(historia.getIdHistoria()) &&
		        			  a.getNumeroRemision().equals(historia.getNumeroRemision()))
		        .findAny();
    	
    	if(numeroRemisionDuplicado.isPresent()){
    		validationResults.add(new ValidationResult("remision", "Ya existe una admisi�n con este n�mero"));
    	}
    	
    	Optional<Historia> pacienteDuplicado = historiaRepository.findAll().stream()
    			.filter(a -> !a.getIdHistoria().equals(historia.getIdHistoria()) &&
    							a.getPaciente().getIdUsuario().equals(historia.getPaciente().getIdUsuario()) &&    							
    							a.getEstado().equals("ACTIVA"))
    			.findAny();
    	
    	if(pacienteDuplicado.isPresent()){
    		validationResults.add(new ValidationResult("paciente", "Hay una historia activa para este paciente"));
    	}*/
			
        return validationResults;
    }

    private ArrayList<ValidationResult> ValidarIntegridad(Usuario usuario)
    {
    	return new ArrayList<ValidationResult>();
    }
    
    public List<Historia> findAll(){
		return historiaRepository.findAll();
	}
	
	public Historia findById(UUID idHistoria){
		return historiaRepository.findOne(idHistoria);
	}
	
	public Historia create(Historia historia) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validar(historia);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		ArrayList<ValidationResult> validacionesDuplicado = this.validarDuplicado(historia);
		
		if (validacionesDuplicado != null && validacionesDuplicado.size() > 0)
			throw new ValidationException(validacionesDuplicado);		
		
		return historiaRepository.save(historia);		
	}
	
	public Historia update(Historia historia) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(historia);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		return historiaRepository.save(historia);			
	}

	@Transactional
	public void delete(UUID idHistoria) throws ValidationException {
		historiaRepository.delete(idHistoria);		
	}
}