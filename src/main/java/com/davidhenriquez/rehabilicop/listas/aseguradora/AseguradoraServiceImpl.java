package com.davidhenriquez.rehabilicop.listas.aseguradora;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.procesos.evolucion.RolTipoEvolucion;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

@Service
public class AseguradoraServiceImpl implements AseguradoraService {

	@Autowired
	private AseguradoraRepository aseguradoraRepository;
	
	public List<Aseguradora> findAll(){
		return aseguradoraRepository.findAll().stream()                
		           .sorted(Comparator.comparing(Aseguradora::getNombre))
		           .collect(Collectors.toList());
	}
	
	public Aseguradora findById(UUID idAseguradora){
		return aseguradoraRepository.findOne(idAseguradora);
	}
	
	public Aseguradora create(Aseguradora aseguradora) throws ValidationException {
		return aseguradoraRepository.save(aseguradora);		
	}
	
	public Aseguradora update(Aseguradora aseguradora) throws ValidationException {
		return aseguradoraRepository.save(aseguradora);		
	}

	@Transactional
	public void delete(UUID idAseguradora) throws ValidationException {
		aseguradoraRepository.delete(idAseguradora);		
	}   
	
	@Override
	public List<Aseguradora> findAseguradorasByUsuario(Usuario usuario) {
		Optional<Rol> adminGlobal = usuario.getRoles().stream()
		        .filter(a -> a.getNombre().equals("admin global"))
		        .findAny();
    	
    	if(adminGlobal.isPresent()){
    		return aseguradoraRepository.findAll().stream()
    			   .sorted(Comparator.comparing(Aseguradora::getNombre))
 		           .collect(Collectors.toList());
    	}else{
    		List<Aseguradora> aseguradoras = aseguradoraRepository.findAll().stream()
	        	.filter(a -> a.getAuditor() != null && a.getAuditor().getIdUsuario().equals(usuario.getIdUsuario()))	        	
                .collect(Collectors.toList());
    		
    		return aseguradoras;
    	}
	}
}
