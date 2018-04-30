package com.davidhenriquez.rehabilicop.presentation.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.davidhenriquez.rehabilicop.business_logic.util.Util;
import com.davidhenriquez.rehabilicop.business_logic.validation.ValidationResult;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

	@Value("${jwt.header}")
	private String tokenHeader;	

	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize("5120MB");
		factory.setMaxRequestSize("5120MB");
		return factory.createMultipartConfig();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "multipart/form-data", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> handleFileUpload(@RequestParam(value = "imagen") final MultipartFile file,
			@RequestParam(value="nombreEntidad") String nombreEntidad,
			@RequestParam(value="idEntidad") long idEntidad) throws URISyntaxException, IOException {
		
		String fileDir = getFileDir(nombreEntidad);		
		
		File f = new File(fileDir);
		if(!f.exists() || !f.isDirectory()){
			f.mkdirs();
		}
				
		String name = file.getOriginalFilename();
		//String ext = this.getExtension(name);
		name = fileDir + idEntidad + ".jpg";
		
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
				
				stream.write(bytes);
				stream.close();
				
				return ResponseEntity.status(HttpStatus.OK).body(new ValidationResult("success", "archivo subido correctamente"));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new ValidationResult("error", "ha ocurrido un error por favor vuelva a intentarlo"));
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ValidationResult("error", "archivo dañado o corrupto"));
		}
	}
	
	//Retorna la extensión dado el nombre de un archivo
	private String getExtension(String name){
		 return name.substring(name.lastIndexOf("."));
	}
	
	private String getFileDir(String nombreEntidad){

		String fileDir = "";
		
		switch (nombreEntidad) {
		case "evento":
			fileDir = Util.EVENTS_FILE_DIR;
			break;
		case "promotor":
			fileDir = Util.PROMOTERS_FILE_DIR;
			break;
		}
		
		return fileDir;
	}
}
