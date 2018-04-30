package com.davidhenriquez.rehabilicop.data_access.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	private String identificacion;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String email;
	private boolean enabled;
	
	private String nombres;
	private String apellidos;
	private String direccion;	
	private String telefono;
	private String celular;

	@Temporal(TemporalType.TIMESTAMP)	
	private Date ultimoAcceso;
	
	@Transient
	private String imagenUrl;
	
	@ManyToOne	
	@JoinColumn(name="idTipoDocumento", nullable=false)
	private TipoDocumento tipoDocumento;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
        name = "UsuarioRol",
        joinColumns = {@JoinColumn(name = "identificacion", referencedColumnName = "identificacion")},
        inverseJoinColumns = {@JoinColumn(name = "idRol", referencedColumnName = "idRol")})
	private Collection<Rol> roles;
}
