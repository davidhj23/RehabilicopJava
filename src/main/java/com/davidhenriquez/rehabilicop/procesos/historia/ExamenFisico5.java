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

import com.davidhenriquez.rehabilicop.listas.estado_conciencia.EstadoConciencia;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class ExamenFisico5 {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico5;
	
	@ManyToOne
	@JoinColumn(name = "idEstadoConciencia", referencedColumnName = "idEstadoConciencia", nullable=true)
	private EstadoConciencia estadoConciencia;
	
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idPersona", referencedColumnName = "idOpcion", nullable=true)
	private Opcion persona;
	@ManyToOne
	@JoinColumn(name = "idEspacio", referencedColumnName = "idOpcion", nullable=true)
	private Opcion espacio;
	@ManyToOne
	@JoinColumn(name = "idTiempo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion tiempo;		
	
	@ManyToOne
	@JoinColumn(name = "idEuprosexico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion euprosexico;
	@ManyToOne
	@JoinColumn(name = "idHipoprosexico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion hipoprosexico;	
	
	@ManyToOne
	@JoinColumn(name = "idEutimico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion eutimico;
	@ManyToOne
	@JoinColumn(name = "idDepresivo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion depresivo;
	@ManyToOne
	@JoinColumn(name = "idExpensivo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion expensivo;
	@ManyToOne
	@JoinColumn(name = "idHiperprosexico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion hiperprosexico;

	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "idOrigenNormal", referencedColumnName = "idOpcion", nullable=true)
	private Opcion orgienNormal;
	@ManyToOne
	@JoinColumn(name = "idAcustica", referencedColumnName = "idOpcion", nullable=true)
	private Opcion acustica;
	@ManyToOne
	@JoinColumn(name = "idConcreto", referencedColumnName = "idOpcion", nullable=true)
	private Opcion concreto;
	@ManyToOne
	@JoinColumn(name = "idPobrezaIdeativa", referencedColumnName = "idOpcion", nullable=true)
	private Opcion pobrezaIdeativa;
	
	@ManyToOne
	@JoinColumn(name = "idCursoNormal", referencedColumnName = "idOpcion", nullable=true)
	private Opcion cursoNormal;
	@ManyToOne
	@JoinColumn(name = "idBridipsiquia", referencedColumnName = "idOpcion", nullable=true)
	private Opcion bridipsiquia;
	@ManyToOne
	@JoinColumn(name = "idTaquipsiquia", referencedColumnName = "idOpcion", nullable=true)
	private Opcion taquipsiquia;
	@ManyToOne
	@JoinColumn(name = "idFugasDeIdea", referencedColumnName = "idOpcion", nullable=true)
	private Opcion fugasDeIdea;
	
	@ManyToOne
	@JoinColumn(name = "idIdeasDelirantes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ideasDelirantes;
	@ManyToOne
	@JoinColumn(name = "idIdeasRefenciales", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ideasRefenciales;
	@ManyToOne
	@JoinColumn(name = "idIdeasObsesivas", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ideasObsesivas;
	@ManyToOne
	@JoinColumn(name = "idPensamientoMago", referencedColumnName = "idOpcion", nullable=true)
	private Opcion pensamientoMago;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
