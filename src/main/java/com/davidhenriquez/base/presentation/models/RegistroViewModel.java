package com.davidhenriquez.base.presentation.models;

import com.davidhenriquez.base.data_access.domain.Usuario;

public class RegistroViewModel {
	
	private String username;
	private String password;
	private String nombres;
	private String apellidos;
	
	private String getUsername() {
		return username;
	}
	private void setUsername(String username) {
		this.username = username;
	}
	private String getPassword() {
		return password;
	}
	private void setPassword(String password) {
		this.password = password;
	}
	private String getNombres() {
		return nombres;
	}
	private void setNombres(String nombres) {
		this.nombres = nombres;
	}
	private String getApellidos() {
		return apellidos;
	}
	private void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Usuario ToUsuario(){		
		Usuario usuario = new Usuario();
		
		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setNombres(nombres);
		usuario.setApellidos(getApellidos());
		
		return usuario;
	}
}
