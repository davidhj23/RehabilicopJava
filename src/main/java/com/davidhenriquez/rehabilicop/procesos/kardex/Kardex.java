package com.davidhenriquez.rehabilicop.procesos.kardex;

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
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.listas.via_ingreso.ViaIngreso;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class Kardex {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idKardex;	
	
	private Date fecha;
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "idPendiente", referencedColumnName = "idOpcion", nullable=true)
	private Opcion pendiente;
	
	@ManyToOne
	@JoinColumn(name = "idRecibido", referencedColumnName = "idOpcion", nullable=true)
	private Opcion recibido;
	
	private Date fecha2;
	private String cuidados_de_enfermeria;
	
	@ManyToOne	
	@JoinColumn(name="idUsuario", nullable=true)
	private Usuario usuario;
		
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}