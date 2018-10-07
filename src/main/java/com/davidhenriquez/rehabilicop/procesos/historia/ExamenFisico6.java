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

import com.davidhenriquez.rehabilicop.listas.alimentacion.Alimentacion;
import com.davidhenriquez.rehabilicop.listas.alucinacion.Alucinacion;
import com.davidhenriquez.rehabilicop.listas.asfixia.Asfixia;
import com.davidhenriquez.rehabilicop.listas.comprensible.Comprensible;
import com.davidhenriquez.rehabilicop.listas.curso.Curso;
import com.davidhenriquez.rehabilicop.listas.estado_conciencia.EstadoConciencia;
import com.davidhenriquez.rehabilicop.listas.inteligencia.Inteligencia;
import com.davidhenriquez.rehabilicop.listas.introspeccion.Introspeccion;
import com.davidhenriquez.rehabilicop.listas.memoria2.Memoria2;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;

import lombok.Data;

@Entity
@Data
public class ExamenFisico6 {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idExamenFisico6;
	
	@ManyToOne
	@JoinColumn(name = "idComprensible", referencedColumnName = "idComprensible", nullable=true)
	private Comprensible comprensible;
	@ManyToOne
	@JoinColumn(name = "idDisartrias", referencedColumnName = "idOpcion", nullable=true)
	private Opcion disartrias;	
	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "idCurso", nullable=true)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "idAsfixias", referencedColumnName = "idAsfixia", nullable=true)
	private Asfixia asfixias;
	
	@ManyToOne
	@JoinColumn(name = "idAlucinaciones", referencedColumnName = "idAlucinacion", nullable=true)
	private Alucinacion alucinaciones;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "idFijacion", referencedColumnName = "idMemoria2", nullable=true)
	private Memoria2 fijacion;
	@ManyToOne
	@JoinColumn(name = "idReciente", referencedColumnName = "idMemoria2", nullable=true)
	private Memoria2 reciente;
	@ManyToOne
	@JoinColumn(name = "idRemota", referencedColumnName = "idMemoria2", nullable=true)
	private Memoria2 remota;
	
	@ManyToOne
	@JoinColumn(name = "idInteligencia", referencedColumnName = "idInteligencia", nullable=true)
	private Inteligencia inteligencia;
	@ManyToOne
	@JoinColumn(name = "idIntrospeccion", referencedColumnName = "idIntrospeccion", nullable=true)
	private Introspeccion introspeccion;
	@ManyToOne
	@JoinColumn(name = "idProspeccion", referencedColumnName = "idIntrospeccion", nullable=true)
	private Introspeccion prospeccion;
	@ManyToOne
	@JoinColumn(name = "idJuicio", referencedColumnName = "idIntrospeccion", nullable=true)
	private Introspeccion juicio;
	
	@ManyToOne
	@JoinColumn(name = "idAlimentacion", referencedColumnName = "idAlimentacion", nullable=true)
	private Alimentacion alimentacion;		
	
	private String tipoAlimenticio;
	
	@ManyToOne
	@JoinColumn(name = "idAdecuado", referencedColumnName = "idOpcion", nullable=true)
	private Opcion adecuado;	
	@ManyToOne
	@JoinColumn(name = "idHipersomnio", referencedColumnName = "idOpcion", nullable=true)
	private Opcion hipersomnio;	
	@ManyToOne
	@JoinColumn(name = "idInsomnio", referencedColumnName = "idOpcion", nullable=true)
	private Opcion insomnio;	
	@ManyToOne
	@JoinColumn(name = "idCociliacion", referencedColumnName = "idOpcion", nullable=true)
	private Opcion cociliacion;	
	@ManyToOne
	@JoinColumn(name = "idReconciliacion", referencedColumnName = "idOpcion", nullable=true)
	private Opcion reconciliacion;
	@ManyToOne
	@JoinColumn(name = "idGlobal", referencedColumnName = "idOpcion", nullable=true)
	private Opcion global;	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
