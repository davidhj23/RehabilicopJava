package com.davidhenriquez.rehabilicop.procesos.historia;

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
	
	@Autowired
	private PatologicoRepository patologicoRepository;
	
	@Autowired
	private AntecedenteRepository antecedenteRepository;
	
	@Autowired
	private TraumaticoRepository traumaticoRepository;
	
	@Autowired
	private FarmacologicoRepository farmacologicoRepository;
	
	@Autowired
	private ToxicoRepository toxicoRepository;
	
	@Autowired
	private ExamenFisicoRepository examenFisicoRepository;
	
	@Autowired
	private ExamenFisico2Repository examenFisico2Repository;
	
	@Autowired
	private GinecoObstetricioRepository ginecoObstetricioRepository;
	
	@Autowired
	private ExamenFisico3Repository examenFisico3Repository;
	
	@Autowired
	private ExamenFisico4Repository examenFisico4Repository;
	
	@Autowired
	private ExamenFisico5Repository examenFisico5Repository;
	
	@Autowired
	private ExamenFisico6Repository examenFisico6Repository;
	
	private ArrayList<ValidationResult> validar(Historia historia)
    {
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
		
		Usuario paciente = usuarioRepository.findOne(historia.getAdmision().getPaciente().getIdUsuario());		
		if(paciente == null)
			validationResults.add(new ValidationResult("paciente", "No se encontró un paciente con esa identificación"));
			
        return validationResults;
    }

	private ArrayList<ValidationResult> validarDuplicado(Historia historia)
    {	
		ArrayList<ValidationResult> validationResults = new ArrayList<ValidationResult>();
    	
    	Optional<Historia> pacienteDuplicado = historiaRepository.findAll().stream()
    			.filter(a -> !a.getIdHistoria().equals(historia.getIdHistoria()) &&
    							a.getAdmision().getPaciente().getIdUsuario().equals(
    									historia.getAdmision().getPaciente().getIdUsuario()) &&    							
    							a.getAdmision().getEstado().equals("ACTIVA"))
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
				
		Historia savedHistoria = historiaRepository.save(historia);
		
		for (Patologico p : historia.getPatologicos()) {
			p.setHistoria(savedHistoria);
			patologicoRepository.save(p);
		}
		
		for (Antecedente a : historia.getAntecedentes()) {
			a.setHistoria(savedHistoria);
			antecedenteRepository.save(a);
		}
		
		for (Traumatico t : historia.getTraumaticos()) {
			t.setHistoria(savedHistoria);
			traumaticoRepository.save(t);
		}
		
		for (Farmacologico f : historia.getFarmacologicos()) {
			f.setHistoria(savedHistoria);
			farmacologicoRepository.save(f);
		}
		
		for (Toxico t : historia.getToxicos()) {
			t.setHistoria(savedHistoria);
			toxicoRepository.save(t);
		}
		
		if(historia.getGinecoObstetricios() != null){
			for (GinecoObstetricio g : historia.getGinecoObstetricios()) {
				g.setHistoria(savedHistoria);
				ginecoObstetricioRepository.save(g);
			}	
		}
		
		if(historia.getExamenFisicos() != null){
			for (ExamenFisico ef : historia.getExamenFisicos()) {
				ef.setHistoria(savedHistoria);
				examenFisicoRepository.save(ef);
			}	
		}
		
		if(historia.getExamenFisicos2() != null){
			for (ExamenFisico2 ef2 : historia.getExamenFisicos2()) {
				ef2.setHistoria(savedHistoria);
				examenFisico2Repository.save(ef2);
			}	
		}
		
		if(historia.getExamenFisicos3() != null){
			for (ExamenFisico3 ef3 : historia.getExamenFisicos3()) {
				ef3.setHistoria(savedHistoria);
				examenFisico3Repository.save(ef3);
			}	
		}
		
		if(historia.getExamenFisicos4() != null){
			for (ExamenFisico4 ef4 : historia.getExamenFisicos4()) {
				ef4.setHistoria(savedHistoria);
				examenFisico4Repository.save(ef4);
			}	
		}
		
		if(historia.getExamenFisicos5() != null){
			for (ExamenFisico5 ef5 : historia.getExamenFisicos5()) {
				ef5.setHistoria(savedHistoria);
				examenFisico5Repository.save(ef5);
			}	
		}
		
		if(historia.getExamenFisicos6() != null){
			for (ExamenFisico6 ef6 : historia.getExamenFisicos6()) {
				ef6.setHistoria(savedHistoria);
				examenFisico6Repository.save(ef6);
			}	
		}
		
		return savedHistoria;
	}
	
	public Historia update(Historia historia) throws ValidationException {
		ArrayList<ValidationResult> validaciones = this.validarDuplicado(historia);
		
		if (validaciones != null && validaciones.size() > 0)
			throw new ValidationException(validaciones);
		
		Historia savedHistoria = historiaRepository.save(historia);	
		
		for (Patologico pe : findPatologicosByIdHistoria(historia.getIdHistoria())) {			
			patologicoRepository.delete(pe);
		}
				
		for (Patologico pn : historia.getPatologicos()){			
			pn.setHistoria(historia);
			patologicoRepository.save(pn);
		}
		
		for (Antecedente ae : findAntecedentesByIdHistoria(historia.getIdHistoria())) {			
			antecedenteRepository.delete(ae);
		}		
				
		for (Antecedente an : historia.getAntecedentes()){			
			an.setHistoria(historia);
			antecedenteRepository.save(an);
		} 
		
		for (Traumatico te : findTraumaticosByIdHistoria(historia.getIdHistoria())) {			
			traumaticoRepository.delete(te);
		}		
				
		for (Traumatico tn : historia.getTraumaticos()){			
			tn.setHistoria(historia);
			traumaticoRepository.save(tn);
		} 
		
		for (Farmacologico x : findFarmacologicosByIdHistoria(historia.getIdHistoria())) {			
			farmacologicoRepository.delete(x);
		}		
				
		for (Farmacologico x : historia.getFarmacologicos()){			
			x.setHistoria(historia);
			farmacologicoRepository.save(x);
		}
		
		for (Toxico x : findToxicosByIdHistoria(historia.getIdHistoria())) {			
			toxicoRepository.delete(x);
		}		
				
		for (Toxico x : historia.getToxicos()){			
			x.setHistoria(historia);
			toxicoRepository.save(x);
		}
		
		for (GinecoObstetricio x : findGinecoObstetriciosByIdHistoria(historia.getIdHistoria())) {			
			ginecoObstetricioRepository.delete(x);
		}		
				
		for (GinecoObstetricio x : historia.getGinecoObstetricios()){			
			x.setHistoria(historia);
			ginecoObstetricioRepository.save(x);
		}
		
		return savedHistoria;			
	}

	@Transactional
	public void delete(UUID idHistoria) throws ValidationException {
		historiaRepository.delete(idHistoria);		
	}

	@Override
	public List<Patologico> findPatologicosByIdHistoria(UUID idHistoria) {
		return patologicoRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}

	@Override
	public List<Antecedente> findAntecedentesByIdHistoria(UUID idHistoria) {
		return antecedenteRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<Traumatico> findTraumaticosByIdHistoria(UUID idHistoria) {
		return traumaticoRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<Farmacologico> findFarmacologicosByIdHistoria(UUID idHistoria) {
		return farmacologicoRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<Toxico> findToxicosByIdHistoria(UUID idHistoria) {
		return toxicoRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<GinecoObstetricio> findGinecoObstetriciosByIdHistoria(UUID idHistoria) {
		return ginecoObstetricioRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<ExamenFisico> findExamenFisicoByIdHistoria(UUID idHistoria) {
		return examenFisicoRepository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());		
	}

	@Override
	public List<ExamenFisico2> findExamenFisico2ByIdHistoria(UUID idHistoria) {
		return examenFisico2Repository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}

	@Override
	public List<ExamenFisico3> findExamenFisico3ByIdHistoria(UUID idHistoria) {
		return examenFisico3Repository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}

	@Override
	public List<ExamenFisico4> findExamenFisico4ByIdHistoria(UUID idHistoria) {
		return examenFisico4Repository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}

	@Override
	public List<ExamenFisico5> findExamenFisico5ByIdHistoria(UUID idHistoria) {
		return examenFisico5Repository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}

	@Override
	public List<ExamenFisico6> findExamenFisico6ByIdHistoria(UUID idHistoria) {
		return examenFisico6Repository.findAll().stream()
                .filter(x -> x.getHistoria().getIdHistoria().equals(idHistoria))                
                .collect(Collectors.toList());
	}
}