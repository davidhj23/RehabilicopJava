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
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Service
public class AdmisionServiceImpl implements AdmisionService{

	@Autowired
	private AdmisionRepository admisionRepository;
	
	private ArrayList<ValidationResult> Validar(Admision admision)
    {
        return new ArrayList<ValidationResult>();
    }

	private ArrayList<ValidationResult> validarDuplicado(Admision admision)
    {	
		ArrayList<ValidationResult> vaidationResults = new ArrayList<ValidationResult>();
		
		List<Admision> admisiones = admisionRepository.findAll();
    	
    	return vaidationResults;
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
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(admision);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
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
}