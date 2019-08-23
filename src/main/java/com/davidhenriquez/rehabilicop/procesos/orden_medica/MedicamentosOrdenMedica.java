package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.Epicrisis;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.TratamientoFarmacologico;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JoinColumn(name="idDosis", referencedColumnName = "idDosis", nullable=true)
	private Dosis frecuencia;
	
	private Integer cantidadSolicitada;
	private Integer cantidadEntregada;	
	
	@ManyToOne	
	@JoinColumn(name="idOrdenMedica", nullable=true)
	private OrdenMedica ordenMedica;
	
	@OneToMany(mappedBy="medicamentosOrdenMedica")	
	@JsonBackReference(value="Administracion")	
	private Collection<Administracion> administraciones;
}
