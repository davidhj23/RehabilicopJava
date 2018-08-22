package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.gesta.Gesta;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class GinecoObstetricio {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idGinecoObstetricio;	
	
	private String partos;
	private String abortos;
	private String semanas;
	private String menarquias;
	private String fum;
	
	@ManyToOne	
	@JoinColumn(name="idEmbarazoActual", nullable=false)
	private Opcion embarazoActual;
	
	@ManyToOne	
	@JoinColumn(name="idGesta", nullable=false)
	private Gesta gesta;	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
}
