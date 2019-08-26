package com.davidhenriquez.rehabilicop.procesos.epicrisis;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.tags.TransformTag;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucionRepository;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;
import com.davidhenriquez.rehabilicop.core.validation.ValidationResult;
import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.expresion_facial1.ExpresionFacial1;
import com.davidhenriquez.rehabilicop.procesos.orden_medica.MedicamentosOrdenMedica;
import com.davidhenriquez.rehabilicop.procesos.orden_medica.OrdenMedica;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.rol.RolRepository;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.davidhenriquez.rehabilicop.seguridad.usuario.UsuarioRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

@Service
public class EpicrisisServiceImpl implements EpicrisisService{

	@Autowired	
	private EpicrisisRepository epicrisisRepository;
	
	@Autowired	
	private TratamientoFarmacologicoRepository tratamientoFarmacologicoRepository;
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Autowired
	private DataSource dataSource;
	
	public Epicrisis create(Epicrisis epicrisis) throws ValidationException {		
		
		Epicrisis e = epicrisisRepository.save(epicrisis); 
		
		for (TratamientoFarmacologico t : epicrisis.getTratamientoFarmacologico()) {
			t.setEpicrisis(e);
			tratamientoFarmacologicoRepository.save(t);
		}
		
		return e;		
	}
	
	public List<Epicrisis> findAll(){
		return epicrisisRepository.findAll().stream()	        		
	        	.sorted(Comparator.comparing(Epicrisis::getFechaDeCreacion))	
	        	.collect(Collectors.toList());
	}
	
	public Epicrisis findById(UUID id){		
		return epicrisisRepository.findOne(id);
	}
	
	@Override
	public List<TratamientoFarmacologico> findMedicamentosByIdEpicrisis(UUID id) {
		return tratamientoFarmacologicoRepository.findAll().stream()
                .filter(x -> x.getEpicrisis().getIdEpicrisis().equals(id))                
                .collect(Collectors.toList());
	}
	
	public Epicrisis update(Epicrisis epicrisis) throws ValidationException {		
						
		for (TratamientoFarmacologico t : epicrisis.getTratamientoFarmacologico()){			
			tratamientoFarmacologicoRepository.save(t);
		}
		
		return epicrisisRepository.save(epicrisis);			
	}	
	
	@Override
	public byte[] generateReport(String idAdmision) throws SQLException {
		
		byte[] bytes = null;
	    try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {		    	
	    	JasperReport jasperReport = 
		    		(JasperReport) JRLoader.loadObject(
		    				resourceLoader.getResource("classpath:HistoriaClinica.jasper").getInputStream());
		    
		    Map<String, Object> params = new HashMap<>();
		      params.put("identificacion", idAdmision.replace("-", ""));
		    
		    JasperPrint jasperPrint = 
		    		JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());			      
	      	bytes = JasperExportManager.exportReportToPdf(jasperPrint);
	    }
	    catch (JRException | IOException e) {
	    	e.printStackTrace();
	    }
	    
		// Cerrar historia
	    
	    return bytes;
    }
}