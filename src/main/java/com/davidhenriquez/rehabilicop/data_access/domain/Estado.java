package com.davidhenriquez.rehabilicop.data_access.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Estado {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEstado;
	
	@NotNull
	private String nombre;
	
	@ManyToOne	
    @JoinColumn(name = "idPais", nullable=false)
	private Pais pais;
	
	@OneToMany
	@JsonBackReference(value="ciudades")
	@JoinColumn(name="idEstado")
	private Collection<Ciudad> ciudades;
}
