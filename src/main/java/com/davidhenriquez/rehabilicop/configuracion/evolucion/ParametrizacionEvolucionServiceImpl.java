package com.davidhenriquez.rehabilicop.configuracion.evolucion;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
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
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class ParametrizacionEvolucionServiceImpl implements ParametrizacionEvolucionService{

	@Autowired
	private TipoEvolucionRepository tipoEvolucionRepository;
	
	@Autowired
	private ParametrizacionEvolucionRepository parametrizacionEvolucionRepository;
		    
    public List<TipoEvolucion> findAllTiposEvoluciones(){
		return tipoEvolucionRepository.findAll();
	}
    
    public ParametrizacionEvolucion create(ParametrizacionEvolucion parametrizacionEvolucion) throws ValidationException {
		return parametrizacionEvolucionRepository.save(parametrizacionEvolucion);		
	}

	@Override
	public List<ParametrizacionEvolucion> findAll() {
		return parametrizacionEvolucionRepository.findAll().stream()
				.sorted(Comparator.comparing(ParametrizacionEvolucion::getFecha).reversed())
		        .collect(Collectors.toList());
	}

	@Transactional
	public void delete(UUID id) throws ValidationException {
		parametrizacionEvolucionRepository.delete(id);
	}

	@Override
	public List<ParametrizacionEvolucion> getAllByAnioAndMes(int year, int month) {
		
		List<ParametrizacionEvolucion> peList = new ArrayList<ParametrizacionEvolucion>();
		
		for (ParametrizacionEvolucion pe : parametrizacionEvolucionRepository.findAll()){
			LocalDate localDate = pe.getFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			if(localDate.getYear() == year &&
					localDate.getMonthValue() == month){
						peList.add(pe);
			}
		}
		
		return peList
				.stream()
				.sorted(Comparator.comparing(ParametrizacionEvolucion::getFecha))
		        .collect(Collectors.toList());
	}
}