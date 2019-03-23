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

import lombok.Data;

@Entity
@Data
public class MedicamentosOrdenMedica {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idMedicamentosOrdenMedica;	
	
	@ManyToOne	
	@JoinColumn(name="idMedicamento", nullable=true)
	private Medicamento medicamento;
	
	@ManyToOne	
	@JoinColumn(name="idDosis", nullable=true)
	private Dosis dosis;
	
	private Integer cantidadSolicitada;
	private Integer cantidadEntregada;	
	
	@ManyToOne	
	@JoinColumn(name="idOrdenMedica", nullable=true)
	private OrdenMedica ordenMedica;
}
