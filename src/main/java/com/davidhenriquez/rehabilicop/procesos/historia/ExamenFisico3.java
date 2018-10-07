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
public class ExamenFisico3 {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico3;
	
	@ManyToOne
	@JoinColumn(name = "idLlenadoCapilarAlterado", referencedColumnName = "idOpcion", nullable=true)
	private Opcion llenadoCapilarAlterado;
	@ManyToOne
	@JoinColumn(name = "idPulsoAusentes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion pulsoAusentes;
	@ManyToOne
	@JoinColumn(name = "idDeformidad", referencedColumnName = "idOpcion", nullable=true)
	private Opcion deformidad;
	@ManyToOne
	@JoinColumn(name = "idMovilidadAlterada", referencedColumnName = "idOpcion", nullable=true)
	private Opcion movilidadAlterada;
	@ManyToOne
	@JoinColumn(name = "idPulsosPerifericosPresentes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion pulsosPerifericosPresentes;
	
	@ManyToOne
	@JoinColumn(name = "idCianosis", referencedColumnName = "idOpcion", nullable=true)
	private Opcion cianosis;
	@ManyToOne
	@JoinColumn(name = "idIctericia", referencedColumnName = "idOpcion", nullable=true)
	private Opcion ictericia;
	@ManyToOne
	@JoinColumn(name = "idPalidezMucocutanea", referencedColumnName = "idOpcion", nullable=true)
	private Opcion palidezMucocutanea;
	@ManyToOne
	@JoinColumn(name = "idHematomasEquimosisHeridas", referencedColumnName = "idOpcion", nullable=true)
	private Opcion hematomasEquimosisHeridas;
	@ManyToOne
	@JoinColumn(name = "idCicatricesTatuajes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion cicatricesTatuajes;
	@ManyToOne
	@JoinColumn(name = "idSinAlteracionesEvidentes", referencedColumnName = "idOpcion", nullable=true)
	private Opcion sinAlteracionesEvidentes;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
