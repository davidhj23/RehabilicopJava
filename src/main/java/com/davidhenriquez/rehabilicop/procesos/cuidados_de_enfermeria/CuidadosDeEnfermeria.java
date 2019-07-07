package com.davidhenriquez.rehabilicop.procesos.cuidados_de_enfermeria;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.Epicrisis;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.TratamientoFarmacologico;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class CuidadosDeEnfermeria {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idCuidadosDeEnfermeria;	
	
	private Date fecha;
	
	private String hallazgos;
	private String acciones;
	private String evaluacion;
	
	@ManyToOne	
	@JoinColumn(name="idCie10", nullable=true)
	private Cie10 dxEnfermeria;
	
	@ManyToOne	
	@JoinColumn(name="idUsuario", nullable=true)
	private Usuario usuario;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}
