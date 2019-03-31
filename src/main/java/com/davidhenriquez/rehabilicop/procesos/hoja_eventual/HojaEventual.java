package com.davidhenriquez.rehabilicop.procesos.hoja_eventual;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class HojaEventual {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idHojaEventual;	
	
	private Date fecha;
	private String descripcion;
	
	@ManyToOne	
	@JoinColumn(name="idTipoEvolucion", nullable=true)
	private TipoEvolucion tipoEvolucion;
	
	@ManyToOne	
	@JoinColumn(name="idUsuario", nullable=true)
	private Usuario usuario;	
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
