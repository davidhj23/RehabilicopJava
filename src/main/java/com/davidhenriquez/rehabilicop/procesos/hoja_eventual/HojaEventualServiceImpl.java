package com.davidhenriquez.rehabilicop.procesos.hoja_eventual;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucionRepository;
import com.davidhenriquez.rehabilicop.core.validation.ValidationException;

@Service
public class HojaEventualServiceImpl implements HojaEventualService{

	@Autowired	
	private HojaEventualRepository hojaEventualRepository;
	
	@Autowired	
	private TipoEvolucionRepository tipoEvolucionRepository;	
	
	public HojaEventual create(HojaEventual hojaEventual) throws ValidationException {
		return hojaEventualRepository.save(hojaEventual);		
	}

	@Override
	public List<HojaEventual> getHojasEventualesEmpleado(String identificacion) {
		return hojaEventualRepository.findAll().stream()
	        	.filter(x -> x.getUsuario().getIdentificacion().equals(identificacion))	
	        	.sorted(Comparator.comparing(HojaEventual::getFecha))	
                .collect(Collectors.toList());
	}
}
