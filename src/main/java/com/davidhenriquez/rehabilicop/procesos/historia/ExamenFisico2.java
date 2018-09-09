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
	@JoinColumn(name = "idFrotePericardial", referencedColumnName = "idOpcion", nullable=false)
	private Opcion frotePericardial;
	@ManyToOne	
	@JoinColumn(name = "idRuidosNoAuscultables", referencedColumnName = "idOpcion", nullable=false)
	private Opcion ruidosNoAuscultables;
	@ManyToOne	
	@JoinColumn(name = "idArritmico", referencedColumnName = "idOpcion", nullable=false)
	private Opcion arritmico;
	@ManyToOne	
	@JoinColumn(name = "idSoplo", referencedColumnName = "idOpcion", nullable=false)
	private Opcion soplo;
	@ManyToOne	
	@JoinColumn(name = "idRsCsRsSinSoplo", referencedColumnName = "idOpcion", nullable=false)
	private Opcion rsCsRsSinSoplo;
	
	@ManyToOne	
	@JoinColumn(name = "idHepatomegalia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion hepatomegalia;
	@ManyToOne
	@JoinColumn(name = "idEsplenomegalia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion esplenomegalia;
	@ManyToOne
	@JoinColumn(name = "idMasaPalpable", referencedColumnName = "idOpcion", nullable=false)
	private Opcion masaPalpable;
	@ManyToOne
	@JoinColumn(name = "idSignosDeIrritacionPeritoneal", referencedColumnName = "idOpcion", nullable=false)
	private Opcion signosDeIrritacionPeritoneal;
	@ManyToOne
	@JoinColumn(name = "idSinAlteracionesEvidente", referencedColumnName = "idOpcion", nullable=false)
	private Opcion sinAlteracionesEvidente;
	@ManyToOne
	@JoinColumn(name = "idIieoParalitico", referencedColumnName = "idOpcion", nullable=false)
	private Opcion IieoParalitico;
	@ManyToOne
	@JoinColumn(name = "idAscitis", referencedColumnName = "idOpcion", nullable=false)
	private Opcion ascitis;	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
}
