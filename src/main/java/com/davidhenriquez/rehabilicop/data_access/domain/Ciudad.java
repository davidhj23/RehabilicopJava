package com.davidhenriquez.rehabilicop.data_access.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Ciudad {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCiudad;
	
	@NotNull
	private String nombre;
	
	@ManyToOne	
	@JoinColumn(name = "idEstado", nullable=false)
	private Estado estado;
}
