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
import com.davidhenriquez.rehabilicop.listas.tiempo_de_uso.TiempoDeUso;

import lombok.Data;

@Entity
@Data
public class Farmacologico {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idFaramacologio;	
	
	private String medicamento;
    private String dosis;
    private String tiempoDeUso;
    private String eventoAdverso;
    
    @ManyToOne	
	@JoinColumn(name = "idEficacia", referencedColumnName = "idOpcion", nullable=false)
	private Opcion eficacia;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=false)
	private Historia historia;
	
}
