package com.davidhenriquez.rehabilicop.seguridad.rol;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
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
import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.seguridad.permiso.Permiso;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idRol;	
    
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
