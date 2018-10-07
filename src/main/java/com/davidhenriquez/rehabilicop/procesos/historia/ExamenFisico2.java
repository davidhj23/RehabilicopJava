package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.apariencia.Apariencia;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class ExamenFisico2 {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico2;
	
	@ManyToOne	
	@JoinColumn(name = "idFrotePericardial", referencedColumnName = "idOpcion", nullable=true)
	private Opcion frotePericardial;
	@ManyToOne	
	@JoinColumn(name = "idRuidosNoAuscultables", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ruidosNoAuscultables;
	@ManyToOne	
	@JoinColumn(name = "idArritmico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion arritmico;
	@ManyToOne	
	@JoinColumn(name = "idSoplo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion soplo;
	@ManyToOne	
	@JoinColumn(name = "idRsCsRsSinSoplo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion rsCsRsSinSoplo;
	
	@ManyToOne	
	@JoinColumn(name = "idHepatomegalia", referencedColumnName = "idOpcion", nullable=true)
	private Opcion hepatomegalia;
	@ManyToOne
	@JoinColumn(name = "idEsplenomegalia", referencedColumnName = "idOpcion", nullable=true)
	private Opcion esplenomegalia;
	@ManyToOne
	@JoinColumn(name = "idMasaPalpable", referencedColumnName = "idOpcion", nullable=true)
	private Opcion masaPalpable;
	@ManyToOne
	@JoinColumn(name = "idSignosDeIrritacionPeritoneal", referencedColumnName = "idOpcion", nullable=true)
	private Opcion signosDeIrritacionPeritoneal;
	@ManyToOne
	@JoinColumn(name = "idSinAlteracionesEvidentes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion sinAlteracionesEvidentes;
	@ManyToOne
	@JoinColumn(name = "idIieoParalitico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion iieoParalitico;
	@ManyToOne
	@JoinColumn(name = "idAscitis", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ascitis;	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
