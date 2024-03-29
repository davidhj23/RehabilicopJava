package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
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
	
	@Autowired
	private AdministracionRepository administracionRepository;
	
	public List<OrdenMedica> findAll(){
		return ordenMedicaRepository.findAll().stream()
	        	.filter(x -> x.getHistoria().getAdmision().getEstado().equals("ACTIVA") &&
	        			     !x.getEstado().equals("CERRADA"))	
	        	.sorted(Comparator.comparing(OrdenMedica::getFechaDeCreacion))	
	        	.collect(Collectors.toList());
	}
	
	public List<OrdenMedica> getPendientes(){
		return ordenMedicaRepository.findAll().stream()
	        	.filter(x -> x.getHistoria().getAdmision().getEstado().equals("ACTIVA") &&
	        			     x.getEstado().equals("PENDIENTE"))	
	        	.sorted(Comparator.comparing(OrdenMedica::getFechaDeCreacion))	
	        	.collect(Collectors.toList());
	}
	
	public List<OrdenMedica> getEnProceso(){
		return ordenMedicaRepository.findAll().stream()
	        	.filter(x -> x.getHistoria().getAdmision().getEstado().equals("ACTIVA") &&
	        			     x.getEstado().equals("EN PROCESO"))	
	        	.sorted(Comparator.comparing(OrdenMedica::getFechaDeCreacion))	
	        	.collect(Collectors.toList());
	}
	
	public OrdenMedica findById(UUID id){		
		OrdenMedica ordenMedica = ordenMedicaRepository.findOne(id);
		return ordenMedica;
	}
	
	public OrdenMedica create(OrdenMedica ordenMedica) throws ValidationException {		
		ordenMedica.setEstado("PENDIENTE");
		OrdenMedica ordenGuardada = ordenMedicaRepository.save(ordenMedica); 
		
		for (MedicamentosOrdenMedica m : ordenMedica.getMedicamentosOrdenMedica()) {
			m.setOrdenMedica(ordenMedica);
			medicamentosOrdenMedicaRepository.save(m);
			
			for(Administracion a : m.getAdministraciones()){
				a.setMedicamentosOrdenMedica(m);
				administracionRepository.save(a);	
			}
		}
		
		return ordenGuardada;		
	}
			
	public OrdenMedica update(OrdenMedica ordenMedica) throws ValidationException {		
			
		boolean cerrar = true;
		
		for (MedicamentosOrdenMedica mom : ordenMedica.getMedicamentosOrdenMedica()){			
			medicamentosOrdenMedicaRepository.save(mom);
			
			for(Administracion a : mom.getAdministraciones()){
				a.setMedicamentosOrdenMedica(mom);
				if(a.getAdministra() != null 
						&& a.getAdministra().getIdUsuario() == null)
				{
					a.setAdministra(null);
					cerrar = false;
				}
				administracionRepository.save(a);	
			}
		}
		
		if(ordenMedica.getPuedeCerrar() != null && 
		   ordenMedica.getPuedeCerrar() && 
		   cerrar){
			ordenMedica.setEstado("CERRADA");	
		}else{
			ordenMedica.setEstado("EN PROCESO");
		}
		
		return ordenMedicaRepository.save(ordenMedica);			
	}

	@Transactional
	public void delete(UUID id) throws ValidationException {
		
		for (MedicamentosOrdenMedica m : findMedicamentosByIdOrdenMedica(id)) {	
			for (Administracion a : findAdministracionesByIdMedicamento(m.getIdMedicamentosOrdenMedica())) {			
				administracionRepository.delete(a.getIdAdministracion());
			}
			medicamentosOrdenMedicaRepository.delete(m.getIdMedicamentosOrdenMedica());
		}
		
		ordenMedicaRepository.delete(id);		
	}
	
	@Transactional
	public void deleteMedicamentos(UUID id) throws ValidationException {
					
		for (Administracion a : findAdministracionesByIdMedicamento(id)) {			
			administracionRepository.delete(a);
		}
		
		medicamentosOrdenMedicaRepository.delete(id);
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
	public List<MedicamentosOrdenMedica> findMedicamentosByIdOrdenMedica(UUID id) 
	{	
		List<MedicamentosOrdenMedicaSP> medicamentosOrdenMedicaSPs = medicamentosOrdenMedicaRepository.getMedicamentosOrdenMedica(id.toString());
				
		ArrayList<MedicamentosOrdenMedica> medicamentosOrdenMedicas = new ArrayList<MedicamentosOrdenMedica>();		
		for(MedicamentosOrdenMedicaSP momSP : medicamentosOrdenMedicaSPs)
		{	
			MedicamentosOrdenMedica mom = new MedicamentosOrdenMedica();
			
			mom.setIdMedicamentosOrdenMedica(momSP.getIdMedicamentosOrdenMedica());
			
			OrdenMedica om = new OrdenMedica();
			om.setIdOrdenMedica(id);
			mom.setOrdenMedica(om);			
			
			Medicamento m = new Medicamento();
			m.setIdMedicamento(momSP.getIdMedicamento());
			m.setNombre(momSP.getMedicamento());		
			mom.setMedicamento(m);
			
			Dosis d = new Dosis();
			d.setIdDosis(momSP.getIdDosisMom());
			d.setNombre(momSP.getDosisMom());		
			mom.setFrecuencia(d);
			
			mom.setCantidadSolicitada(momSP.getCantidadSolicitada());				
			mom.setCantidadEntregada(momSP.getCantidadEntregada());
			
			medicamentosOrdenMedicas.add(mom);
		}
		
		return medicamentosOrdenMedicas;
	}
	
	@Override
	public List<Administracion> findAdministracionesByIdMedicamento(UUID id) 
	{
		List<AdministracionSP> administracionSPs = medicamentosOrdenMedicaRepository.getAdministraciones(id.toString());
		
		ArrayList<Administracion> administraciones = new ArrayList<Administracion>();		
		for(AdministracionSP admSP : administracionSPs)
		{	
			Administracion adm = new Administracion();
			
			MedicamentosOrdenMedica mom = new MedicamentosOrdenMedica();
			mom.setIdMedicamentosOrdenMedica(id);			
			adm.setMedicamentosOrdenMedica(mom);
			
			adm.setIdAdministracion(admSP.getIdAdministracion());
			
			adm.setFecha(admSP.getFechaAdm());
			adm.setHora(admSP.getHora());
			adm.setAmpm(admSP.getAmpm());
			adm.setValida(admSP.getValida());
			
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(admSP.getIdAdministra());
			usuario.setNombres(admSP.getNombreAdministra());
			usuario.setApellidos(admSP.getApellidoAdministra());
			adm.setAdministra(usuario);
			
			adm.setMedicamentosOrdenMedica(mom);
			
			administraciones.add(adm);
		}
		
		return administraciones;
	}
}