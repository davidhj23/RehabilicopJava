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

import com.davidhenriquez.rehabilicop.listas.apariencia.Apariencia;
import com.davidhenriquez.rehabilicop.listas.gesta.Gesta;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class ExamenFisico {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico;
	
	@ManyToOne	
	@JoinColumn(name="idApariencia", nullable=false)
	private Apariencia apariencia;
	private String descripcionApariencia;
	
	private String signoVitalTa;
	private String signoVitalFc;
	private String signoVitalFr;
	private String signoVitalT;
	
	@ManyToOne	
	@JoinColumn(name = "idMidriasis", referencedColumnName = "idOpcion", nullable=false)
	private Opcion midriasis;
	@ManyToOne	
	@JoinColumn(name = "idMiosis", referencedColumnName = "idOpcion", nullable=false)
	private Opcion miosis;
	@ManyToOne	
	@JoinColumn(name = "idAnisocordia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion anisocordia;
	@ManyToOne	
	@JoinColumn(name = "idpinral", referencedColumnName = "idOpcion", nullable=false)
	private Opcion pinral;
	
	@ManyToOne	
	@JoinColumn(name = "idOtorragia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion otorragia;	
	@ManyToOne	
	@JoinColumn(name = "idOtoliquia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion otoliquia;
	@ManyToOne	
	@JoinColumn(name = "idRinoloquia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion rinoloquia;
	@ManyToOne	
	@JoinColumn(name = "idEpixtasis", referencedColumnName = "idOpcion", nullable=false)
	private Opcion epixtasis;
	@ManyToOne	
	@JoinColumn(name = "idMurmulloVesicular", referencedColumnName = "idOpcion", nullable=false)
	private Opcion murmulloVesicular;
	
	@ManyToOne	
	@JoinColumn(name = "idEstertoresCrepitantes", referencedColumnName = "idOpcion", nullable=false)
	private Opcion estertoresCrepitantes;
	@ManyToOne	
	@JoinColumn(name = "idRoncus", referencedColumnName = "idOpcion", nullable=false)
	private Opcion roncus;
	@ManyToOne	
	@JoinColumn(name = "idSibilancias", referencedColumnName = "idOpcion", nullable=false)
	private Opcion sibilancias;
	@ManyToOne	
	@JoinColumn(name = "idSilencioAuscultorio", referencedColumnName = "idOpcion", nullable=false)
	private Opcion silencioAuscultorio;
	@ManyToOne	
	@JoinColumn(name = "idMurmulloVesicularPulmones", referencedColumnName = "idOpcion", nullable=false)
	private Opcion murmulloVesicularPulmones;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
}
