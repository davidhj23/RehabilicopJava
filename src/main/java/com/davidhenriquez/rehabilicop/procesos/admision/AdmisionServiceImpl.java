package com.davidhenriquez.rehabilicop.procesos.admision;

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
import com.davidhenriquez.rehabilicop.procesos.epicrisis.Epicrisis;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class AdmisionServiceImpl implements AdmisionService{

	@Autowired
	private AdmisionRepository admisionRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private ArrayList<ValidationResult> validar(Admision admision)
    {
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		
		Usuario paciente = usuarioRepository.findOne(admision.getPaciente().getIdUsuario());		
		if(paciente == null)
			validationResults.add(new ValidationResult("paciente", "No se encontró un paciente con esa identificación"));
			
        return validationResults;
    }

	private ArrayList<ValidationResult> validarDuplicado(Admision admision)
    {	
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		
		Optional<Admision> numeroRemisionDuplicado = admisionRepository.findAll().stream()
		        .filter(a -> !a.getIdAdmision().equals(admision.getIdAdmision()) &&
		        			  a.getNumeroRemision().equals(admision.getNumeroRemision()))
		        .findAny();
    	
    	if(numeroRemisionDuplicado.isPresent()){
    		validationResults.add(new ValidationResult("remision", "Ya existe una admisión con este número"));
    	}
    	
    	Optional<Admision> pacienteDuplicado = admisionRepository.findAll().stream()
    			.filter(a -> !a.getIdAdmision().equals(admision.getIdAdmision()) &&
    							a.getPaciente().getIdUsuario().equals(admision.getPaciente().getIdUsuario()) &&    							
    							a.getEstado().equals("ACTIVA"))
    			.findAny();
    	
    	if(pacienteDuplicado.isPresent()){
    		validationResults.add(new ValidationResult("paciente", "Hay una historia activa para este paciente"));
    	}
			
        return validationResults;
    }

    private ArrayList<ValidationResult> ValidarIntegridad(Usuario usuario)
    {
    	return new ArrayList<ValidationResult>();
    }
    
    public List<Admision> findAll(){
		return admisionRepository.findAll();
	}
	
	public Admision findById(UUID idAdmision){
		return admisionRepository.findOne(idAdmision);
	}
	
	public Admision create(Admision admision) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validar(admision);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		ArrayList<ValidationResult> validacionesDuplicado = this.validarDuplicado(admision);
		
		if (validacionesDuplicado != null && validacionesDuplicado.size() > 0)
			throw new ValidationException(validacionesDuplicado);
		
		admision.setEstado("ACTIVA");
		return admisionRepository.save(admision);		
	}
	
	public Admision update(Admision admision) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(admision);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		return admisionRepository.save(admision);			
	}

	@Transactional
	public void delete(UUID idAdmision) throws ValidationException {
		admisionRepository.delete(idAdmision);		
	}

	@Override
	public Admision findAdmisionActivaByIdentificacionPaciente(String identificacion) {
		 Optional<Admision> admisionOptional = admisionRepository.findAll().stream()
				.filter(a -> a.getEstado().equals("ACTIVA") &&
							 a.getPaciente().getIdentificacion().equals(identificacion))
				.findFirst();
		 
		 if(admisionOptional.isPresent()){
    		return admisionOptional.get();
    	 }
		 
		 return null;
	}
	
	@Override
	public List<Admision> findTodasAdmisionByIdentificacionPaciente(String identificacion) {
		 return admisionRepository.findAll().stream()
				 .filter(a -> a.getPaciente().getIdentificacion().equals(identificacion))
				 .sorted(Comparator.comparing(Admision::getFechaDeIngreso))	
		         .collect(Collectors.toList());
	}
}