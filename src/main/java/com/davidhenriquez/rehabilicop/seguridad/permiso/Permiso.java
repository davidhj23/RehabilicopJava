package com.davidhenriquez.rehabilicop.seguridad.permiso;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
public class Permiso {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPermiso;
 
    private String nombre;
 
    @ManyToMany(mappedBy = "permisos")
    @JsonBackReference(value="roles")        
    private Collection<Rol> roles;
}