package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class ExamenFisico4 {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico4;
	
	@ManyToOne
	@JoinColumn(name = "idAlerta", referencedColumnName = "idOpcion", nullable=false)
	private Opcion alerta;
	@ManyToOne
	@JoinColumn(name = "idSomnolencia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion somnolencia;
	@ManyToOne
	@JoinColumn(name = "idEstupor", referencedColumnName = "idOpcion", nullable=false)
	private Opcion estupor;
	@ManyToOne
	@JoinColumn(name = "idComas", referencedColumnName = "idOpcion", nullable=false)
	private Opcion comas;
	@ManyToOne
	@JoinColumn(name = "idAgitacion", referencedColumnName = "idOpcion", nullable=false)
	private Opcion agitacion;
	
	@ManyToOne
	@JoinColumn(name = "idReflejosMuscoloTendinosooAlterados", referencedColumnName = "idOpcion", nullable=false)
	private Opcion reflejosMuscoloTendinosooAlterados;
	@ManyToOne
	@JoinColumn(name = "idSignosmeningeosPresentes", referencedColumnName = "idOpcion", nullable=false)
	private Opcion SignosmeningeosPresentes;
	@ManyToOne
	@JoinColumn(name = "idPerdidaDeLaSensibilidad", referencedColumnName = "idOpcion", nullable=false)
	private Opcion PerdidaDeLaSensibilidad;
	@ManyToOne
	@JoinColumn(name = "idInconctinenciaUrinariaOFecal", referencedColumnName = "idOpcion", nullable=false)
	private Opcion inconctinenciaUrinariaOFecal;
	@ManyToOne
	@JoinColumn(name = "idMovimientosAnormales", referencedColumnName = "idOpcion", nullable=false)
	private Opcion movimientosAnormales;
	@ManyToOne
	@JoinColumn(name = "idSinAlteracionesEvidente", referencedColumnName = "idOpcion", nullable=false)
	private Opcion sinAlteracionesEvidente;
	
	private String cabezaYCuello;	
	private String cardioPulmar;	
	private String abdomen;
	private String genitourinario;	
	private String extremidades;
	
	private String descripcion;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
}
