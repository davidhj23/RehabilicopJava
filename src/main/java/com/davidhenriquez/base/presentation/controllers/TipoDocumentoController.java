package com.davidhenriquez.base.presentation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.davidhenriquez.base.business_logic.services.TipoDocumentoService;
import com.davidhenriquez.base.business_logic.validation.ValidationResult;
import com.davidhenriquez.base.data_access.domain.TipoDocumento;
import com.davidhenriquez.base.presentation.config.JwtTokenUtil;

@RestController
@RequestMapping("/api/tiposDocumento")
public class TipoDocumentoController {

	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTiposDocumentos() {
    	try{
    		List<TipoDocumento> tiposDocumento = tipoDocumentoService.findAll();
    		return ResponseEntity.ok(tiposDocumento);
    	}catch(Exception ex){
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
    	}
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getTipoDocumento(Long idTipoDocumento){
		try {
			TipoDocumento tipoDocumento = tipoDocumentoService.findById(idTipoDocumento);
			return ResponseEntity.ok(tipoDocumento);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    				.body(new ValidationResult("error", 
    					"ha ocurrido un error por favor vuelva a intentarlo"));
		}
	}
}
