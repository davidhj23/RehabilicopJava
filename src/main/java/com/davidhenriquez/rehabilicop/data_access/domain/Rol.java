package com.davidhenriquez.rehabilicop.data_access.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Rol {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRol;
    
    private String nombre; 
        
    @ManyToMany(mappedBy = "roles")
    @JsonBackReference(value="usuarios")
    private Collection<Usuario> usuarios;
 
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch (FetchMode.SELECT)
	@JoinTable(
        name = "RolPermiso",
        joinColumns = {@JoinColumn(name = "idRol", referencedColumnName = "idRol")},
        inverseJoinColumns = {@JoinColumn(name = "idPermiso", referencedColumnName = "idPermiso")})
    private Collection<Permiso> permisos;
}
