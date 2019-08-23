package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.Epicrisis;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.TratamientoFarmacologico;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class Administracion {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idAdministracion;
	
	private String fecha;	
	private String hora;
	private String ampm;
	
	private String valida;
		
	@ManyToOne	
	@JoinColumn(name = "idAdministra", referencedColumnName = "idUsuario", nullable=true)
	private Usuario administra;
	
	@ManyToOne	
	@JoinColumn(name="idMedicamentoOrdenMedica", nullable=true)
	private MedicamentosOrdenMedica medicamentosOrdenMedica;
}
