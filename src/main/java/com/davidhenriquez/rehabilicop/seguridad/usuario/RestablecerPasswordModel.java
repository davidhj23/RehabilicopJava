package com.davidhenriquez.rehabilicop.seguridad.usuario;

public class RestablecerPasswordModel {	
	public String newPassword;
	public String repeatNewPassword;
		
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatNewPassword() {
		return repeatNewPassword;
	}
	public void setRepeatNewPassword(String repeatNewPassword) {
		this.repeatNewPassword = repeatNewPassword;
	}	
}