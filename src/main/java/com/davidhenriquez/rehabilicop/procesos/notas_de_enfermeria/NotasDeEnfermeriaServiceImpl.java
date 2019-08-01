package com.davidhenriquez.rehabilicop.procesos.notas_de_enfermeria;

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
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class NotasDeEnfermeriaServiceImpl implements NotasDeEnfermeriaService{

	@Autowired
	private NotasDeEnfermeriaRepository notasDeEnfermeriaRepository;
	
	public NotasDeEnfermeria create(NotasDeEnfermeria notasDeEnfermeria) throws ValidationException {		
		return notasDeEnfermeriaRepository.save(notasDeEnfermeria);		
	}
	
	@Override
	public List<NotasDeEnfermeria> getNotasDeEnfermeriaByPaciente(String identificacion) {
		 return notasDeEnfermeriaRepository
		 	.findAll()
		 	.stream()
		 	.filter(a -> a.getHistoria()
					 	  .getAdmision()
					 	  .getPaciente()
					 	  .getIdentificacion().equals(identificacion)
					 	  &&
					 	 a.getHistoria()
					 	  .getAdmision().getEstado().equals("ACTIVA"))
		 	.sorted(Comparator.comparing(NotasDeEnfermeria::getFecha))
	        .collect(Collectors.toList());
	}
}