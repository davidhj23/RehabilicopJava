package com.davidhenriquez.rehabilicop.configuracion.evolucion;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class ParametrizacionEvolucion {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idParametrizacionEvolucion;	
	
	private Date fecha;
	
	@ManyToOne	
	@JoinColumn(name="idTipoEvolucion", nullable=false)
	private TipoEvolucion tipoEvolucion;
}
