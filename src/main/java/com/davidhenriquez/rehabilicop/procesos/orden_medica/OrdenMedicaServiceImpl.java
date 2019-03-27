package com.davidhenriquez.rehabilicop.procesos.orden_medica;

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
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.procesos.evolucion.Evolucion;
import com.davidhenriquez.rehabilicop.procesos.historia.Antecedente;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico2;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico3;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico4;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico5;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico6;
import com.davidhenriquez.rehabilicop.procesos.historia.Farmacologico;
import com.davidhenriquez.rehabilicop.procesos.historia.GinecoObstetricio;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.procesos.historia.Toxico;
import com.davidhenriquez.rehabilicop.procesos.historia.Traumatico;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

@Service
public class OrdenMedicaServiceImpl implements OrdenMedicaService{

	@Autowired	
	private OrdenMedicaRepository ordenMedicaRepository;
	
	@Autowired	
	private MedicamentosOrdenMedicaRepository medicamentosOrdenMedicaRepository;
	
	public List<OrdenMedica> findAll(){
		return ordenMedicaRepository.findAll().stream()
	        	.filter(x -> x.getHistoria().getAdmision().getEstado().equals("ACTIVA"))	
	        	.sorted(Comparator.comparing(OrdenMedica::getFechaDeCreacion))	
	        	.collect(Collectors.toList());
	}
	
	public OrdenMedica findById(UUID id){		
		OrdenMedica ordenMedica = ordenMedicaRepository.findOne(id);
		
		/*List<MedicamentosOrdenMedica> medicamentos = medicamentosOrdenMedicaRepository
			.findAll().stream()
			.filter(x -> x.getOrdenMedica().getIdOrdenMedica().equals(ordenMedica.getIdOrdenMedica()))
			.collect(Collectors.toList());		
		
		ordenMedica.setMedicamentosOrdenMedica(medicamentos);*/
		
		return ordenMedica;
	}
	
	public OrdenMedica create(OrdenMedica ordenMedica) throws ValidationException {		
		ordenMedica.setEstado("PENDIENTE");
		OrdenMedica ordenGuardada = ordenMedicaRepository.save(ordenMedica); 
		
		for (MedicamentosOrdenMedica m : ordenMedica.getMedicamentosOrdenMedica()) {
			m.setOrdenMedica(ordenMedica);
			medicamentosOrdenMedicaRepository.save(m);
		}
		
		return ordenGuardada;		
	}
	
	@Override
	public List<OrdenMedica> getOrdenesMedicasByPaciente(String idEmpleado) {
		return ordenMedicaRepository.findAll().stream()
	        	.filter(x -> x.getHistoria().getAdmision().getPaciente().getIdentificacion().equals(idEmpleado) &&    							
						     x.getHistoria().getAdmision().getEstado().equals("ACTIVA"))	
	        	.sorted(Comparator.comparing(OrdenMedica::getFechaDeCreacion))	
                .collect(Collectors.toList());
	}
	
	@Override
	public List<MedicamentosOrdenMedica> findMedicamentosByIdOrdenMedica(UUID id) {
		return medicamentosOrdenMedicaRepository.findAll().stream()
                .filter(x -> x.getOrdenMedica().getIdOrdenMedica().equals(id))                
                .collect(Collectors.toList());
	}
	
	public OrdenMedica update(OrdenMedica ordenMedica) throws ValidationException {		
						
		for (MedicamentosOrdenMedica mom : ordenMedica.getMedicamentosOrdenMedica()){			
			medicamentosOrdenMedicaRepository.save(mom);
		}
		
		ordenMedica.setEstado("CERRADA");
		return ordenMedicaRepository.save(ordenMedica);			
	}
}