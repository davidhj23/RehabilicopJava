package com.davidhenriquez.base.presentation.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.davidhenriquez.base.data_access.domain.Permiso;
import com.davidhenriquez.base.data_access.domain.Rol;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long idUsuario;	
	
	private final String username;
	private final String password;
	private final String email;
	private final boolean enabled;
	
	private final String identificacion;
	private final String nombres;
	private final String apellidos;
	private final String direccion;	
	private final String telefono;
	private final String celular;

	private final Date ultimoAcceso;
	
	private final Collection<Rol> roles;	

    public JwtUser(
		Long idUsuario,	
		
		String username,
		String password,
		String email,
		boolean enabled,
		
		String identificacion,
		String nombres,
		String apellidos,
		String direccion,	
		String telefono,
		String celular,

		Date ultimoAcceso,
		
		Collection<Rol> roles
    ) {
        this.idUsuario = idUsuario;
        
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        
        this.ultimoAcceso = ultimoAcceso;
        
        this.roles = roles;
    }
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }
    
    public String getEmail() {
        return email;
    }
    
    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    @JsonIgnore
    public String getIdentificacion() {
        return identificacion;
    }
    
    public String getNombres() {
        return nombres;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    @JsonIgnore
    public String getDireccion() {
        return direccion;
    }
    
    @JsonIgnore
    public String getTelefono() {
        return telefono;
    }
    
    @JsonIgnore
    public String getCelular() {
        return celular;
    }
    
    @JsonIgnore
    public Date getUltimoAcceso() {
        return ultimoAcceso;
    }
    
    @JsonIgnore
    public Collection<Rol> getRoles() {
        return roles;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities(getRoles());
    }
    
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }    
    
    private Collection<? extends GrantedAuthority> getAuthorities(
      Collection<Rol> roles) {
  
        return getGrantedAuthorities(getPermisos(roles));
    }
 
    private List<String> getPermisos(Collection<Rol> roles) {  
        List<String> permisos = new ArrayList<>();
        List<Permiso> collection = new ArrayList<>();
        
        for (Rol role : roles) {
            collection.addAll(role.getPermisos());
        }
        
        for (Permiso item : collection) {
            permisos.add(item.getNombre());
        }
        
        return permisos;
    }
 
    private List<GrantedAuthority> getGrantedAuthorities(List<String> permisos) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permiso : permisos) {
            authorities.add(new SimpleGrantedAuthority(permiso));
        }
        return authorities;
    }
}
