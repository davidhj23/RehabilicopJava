package com.davidhenriquez.base.data_access.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Pais {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPais;
	
	@NotNull
	private String nombre;

	@OneToMany
	@JsonBackReference(value="estados")
	@JoinColumn(name="idPais")
	private Collection<Estado> estados;
}
