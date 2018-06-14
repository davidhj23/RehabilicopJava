package com.davidhenriquez.rehabilicop.seguridad.usuario;

public class ChangePasswordModel {
	public String currentPassword;
	public String newPassword;
	public String repeatNewPassword;
	
	public String getCurrentPassword() {
		return currentPassword;
	}
	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}
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