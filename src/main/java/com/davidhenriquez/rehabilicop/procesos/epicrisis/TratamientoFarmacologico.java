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
import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class TratamientoFarmacologico {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idTratamientoFarmacologico;	
	
	@ManyToOne	
	@JoinColumn(name="idMedicamento", nullable=true)
	private Medicamento medicamento;
	
	@ManyToOne	
	@JoinColumn(name="idDosis", nullable=true)
	private Dosis dosis;
	
	private Date desde;
	private Date hasta;	
	
	@ManyToOne	
	@JoinColumn(name="idEpicrisis", nullable=true)
	private Epicrisis epicrisis;
}