package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
        		name = "getMedicamentosOrdenMedica",
                procedureName = "GetMedicamentosOrdenMedica",
                resultClasses = MedicamentosOrdenMedicaSP.class,
                parameters = {@StoredProcedureParameter(name = "id_orden_medica", type = String.class, mode = ParameterMode.IN)})
})
public class MedicamentosOrdenMedicaSP implements Serializable {
    
	@Id
	@Column(name = "id_medicamentos_orden_medica")
    private UUID idMedicamentosOrdenMedica;
	
	@Column(name = "id_orden_medica")
    private UUID idOrdenMedica;
	
    @Column(name = "id_medicamento")
    private UUID idMedicamento;
    @Column(name = "medicamento")
    private String medicamento;
    @Column(name = "id_dosis_mom")
    private UUID idDosisMom;
    @Column(name = "dosis_mom")
    private String dosisMom;
    @Column(name = "cantidad_entregada")
    private Integer cantidadEntregada;
    @Column(name = "cantidad_solicitada")
    private Integer cantidadSolicitada;
    @Column(name = "fecha_mom")
    private Date fechaMom;
}