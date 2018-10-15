package com.davidhenriquez.rehabilicop.procesos.evolucion;

import java.util.ArrayList;
import java.util.Collection;
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

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucionRepository;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class EvolucionServiceImpl implements EvolucionService{

	@Autowired	
	private EvolucionRepository evolucionRepository;
	
	@Autowired	
	private TipoEvolucionRepository tipoEvolucionRepository;
	
	@Autowired
	private RolTipoEvolucionRepository rolTipoEvolucionRepository;
	
	public Evolucion create(Evolucion evolucion) throws ValidationException {
		return evolucionRepository.save(evolucion);		
	}

	@Override
	public List<TipoEvolucion> findTipoEvolucionbyIdRol(Collection<Rol> roles) {
		Optional<Rol> adminGlobal = roles.stream()
		        .filter(a -> a.getNombre().equals("admin global"))
		        .findAny();
    	
    	if(adminGlobal.isPresent()){
    		return tipoEvolucionRepository.findAll();
    	}else{
    		List<RolTipoEvolucion> rolTipoEvolucionList = rolTipoEvolucionRepository.findAll().stream()
	        	.filter(a -> roles.stream().anyMatch(x -> x.getIdRol().equals(a.getRol().getIdRol())))	        	
                .collect(Collectors.toList());
    		
    		List<TipoEvolucion> tipoEvolucionList = new ArrayList<TipoEvolucion>();
    		
    		for(RolTipoEvolucion rte : rolTipoEvolucionList){
    			tipoEvolucionList.add(rte.getTipoEolucion());
    		}
    		
    		return tipoEvolucionList;
    	}
	}
}