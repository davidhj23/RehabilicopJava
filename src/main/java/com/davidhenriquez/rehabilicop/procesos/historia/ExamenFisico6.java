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

import com.davidhenriquez.rehabilicop.listas.alucinacion.Alucinacion;
import com.davidhenriquez.rehabilicop.listas.asfixia.Asfixia;
import com.davidhenriquez.rehabilicop.listas.curso.Curso;
import com.davidhenriquez.rehabilicop.listas.estado_conciencia.EstadoConciencia;
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
	
	private String comprensible;
	
	@ManyToOne
	@JoinColumn(name = "idDisartrias", referencedColumnName = "idOpcion", nullable=false)
	private Opcion disartrias;	
	@ManyToOne
	@JoinColumn(name = "idCurso", referencedColumnName = "idOpcion", nullable=false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name = "idAsfixias", referencedColumnName = "idOpcion", nullable=false)
	private Asfixia Asfixias;
	
	@ManyToOne
	@JoinColumn(name = "idDisartrias", referencedColumnName = "idOpcion", nullable=false)
	private Alucinacion alucinaciones;
	
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "idFijacion", referencedColumnName = "idOpcion", nullable=false)
	private Memoria2 fijacion;
	@ManyToOne
	@JoinColumn(name = "idReciente", referencedColumnName = "idOpcion", nullable=false)
	private Memoria2 reciente;
	@ManyToOne
	@JoinColumn(name = "idRemota", referencedColumnName = "idOpcion", nullable=false)
	private Memoria2 remota;
		
	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
}
