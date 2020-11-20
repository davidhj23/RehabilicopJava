package com.davidhenriquez.rehabilicop.procesos.orden_medica;

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
import javax.persistence.Transient;

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
public class OrdenMedica {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idOrdenMedica;	
	
	@OneToMany(mappedBy="ordenMedica")	
	@JsonBackReference(value="medicamentosOrdenMedica")	
	private Collection<MedicamentosOrdenMedica> medicamentosOrdenMedica;
	
	private Date fechaDeCreacion;
	private String Estado;
	
	@Transient
	private Boolean puedeCerrar; 
	
	@ManyToOne	
	@JoinColumn(name="idSolicitante", nullable=true)
	private Usuario solicitante;
	
	@ManyToOne	
	@JoinColumn(name="idQuienEntrega", nullable=true)
	private Usuario quienEntrega;
	
	@ManyToOne	
	@JoinColumn(name="idQuienRecibe", nullable=true)
	private Usuario quienRecibe;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}