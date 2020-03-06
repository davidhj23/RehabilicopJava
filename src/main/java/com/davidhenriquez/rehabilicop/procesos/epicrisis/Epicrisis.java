package com.davidhenriquez.rehabilicop.procesos.epicrisis;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Epicrisis {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idEpicrisis;	
	
	private Date fechaDeIngreso;
	private String horaIngreso;
	private String ampmIngreso;
	
	private Date fechaDeContinuacion;
	
	private Date fechaDeEgreso;	
	private String horaEgreso;
	private String ampmEgreso;
	
	private String diasDeEstancia;
	
	private String justificacion;
	private String plan;
	
	@OneToMany(mappedBy="epicrisis")	
	@JsonBackReference(value="tratamientoFarmacologico")	
	private Collection<TratamientoFarmacologico> tratamientoFarmacologico;
	
	private Date fechaDeCreacion;
	
	@ManyToOne	
	@JoinColumn(name="idUsuario", nullable=true)
	private Usuario usuario;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}