package com.davidhenriquez.rehabilicop.core.util;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static final String EVENTS_FILE_DIR = "src\\main\\resources\\static\\src\\files\\events\\";	
	
	public static String getEventoImageName(Long entityId){
		return getImageName(EVENTS_FILE_DIR, entityId);
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
	
	public static String getFormattedCurrentDate(String format){		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		String formattedDate = now.format(formatter);
		return formattedDate;
	}
}
