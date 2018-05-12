package com.davidhenriquez.rehabilicop.core.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static final String EVENTS_FILE_DIR = "src\\main\\resources\\static\\src\\files\\events\\";
	public static final String QRCODES_FILE_DIR = "src\\main\\resources\\static\\src\\files\\QRCodes\\";
	public static final String QRCODES_FILE_DIR2 = "static\\src\\files\\QRCodes\\";
	public static final String PROMOTERS_FILE_DIR = "src\\main\\resources\\static\\src\\files\\promoters\\";
	public static final String EMAIL_RESOURCES_FILE_DIR = "src\\main\\resources\\static\\src\\files\\templates\\";
	public static final String EMAIL_RESOURCES_FILE_DIR_IMG = "static\\src\\files\\templates\\imgs\\";
	public static final String EMAIL_TEMPLATE = "EmailTemplate.html";
	public static final String EMAIL_SUBJECT = "Asunto";
	
	public static String getEventoImageName(Long entityId){
		return getImageName(EVENTS_FILE_DIR, entityId);
	}
	
	public static String getPromotorImageName(String identificacion){
		return getPromotorImageName(PROMOTERS_FILE_DIR, identificacion);
	}
	
	private static String getImageName(String fileDir, Long entityId){
		String imageName = "0.png";
		String idString = "";
		File folder = new File(fileDir);
		
		if(!folder.exists() || !folder.isDirectory()){
			folder.mkdirs();
		}
		
		for (File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	idString = fileEntry.getName();
	        	idString = idString.substring(0, idString.lastIndexOf("."));
	        	long id = Long.parseLong(idString);
	        	if(entityId == id){
	        		imageName = fileEntry.getName();
	        		break;
	        	}
	        }
	    }
		
		return imageName;
	}
	
	private static String getPromotorImageName(String fileDir, String identificacion){
		String imageName = "0.png";
		String idString = "";
		File folder = new File(fileDir);
		
		if(!folder.exists() || !folder.isDirectory()){
			folder.mkdirs();
		}
		
		for (File fileEntry : folder.listFiles()) {
	        if (!fileEntry.isDirectory()) {
	        	idString = fileEntry.getName();
	        	idString = idString.substring(0, idString.lastIndexOf("."));	        	
	        	if(identificacion.equals(idString)){
	        		imageName = fileEntry.getName();
	        		break;
	        	}
	        }
	    }
		
		return imageName;
	}

	public static String getHTMLTemplate(){
		String content = "";
		StringBuilder contentBuilder = new StringBuilder();
		try {
		    BufferedReader in = new BufferedReader(new FileReader(EMAIL_RESOURCES_FILE_DIR+EMAIL_TEMPLATE));
		    String str;
		    while ((str = in.readLine()) != null) {
		        contentBuilder.append(str);
		    }
		    in.close();
		} catch (IOException e) {
		}
		content = contentBuilder.toString();
		return content;
	}
	
	public static String getFormattedCurrentDate(String format){
		//LocalDateTime ldt = LocalDateTime.now();
		//java.sql.Timestamp tsmp = java.sql.Timestamp.valueOf(ldt);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		String formattedDate = now.format(formatter);
		return formattedDate;
	}
}
