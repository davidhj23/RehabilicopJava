package com.davidhenriquez.rehabilicop.procesos.evolucion;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Data
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "getAllEvoluciones",
                                    procedureName = "evoluciones",
                                    resultClasses = Evoluciones.class,
        parameters = {@StoredProcedureParameter(name = "id_aseguradora", type = String.class, mode = ParameterMode.IN),
        			  @StoredProcedureParameter(name = "year_param", type = Integer.class, mode = ParameterMode.IN),
        			  @StoredProcedureParameter(name = "month_param", type = Integer.class, mode = ParameterMode.IN)
        })
})
public class Evoluciones implements Serializable {
    
	@Id
    @Column(name = "idEvolucion")
    private UUID idEvolucion;
	
	@Column(name = "aseguradora")
    private String aseguradora;
    @Column(name = "fechaEvolucion")
    private Date fechaEvolucion;
    @Column(name = "idPaciente")
    private UUID idPaciente;
    @Column(name = "nombrePaciente")
    private String nombrePaciente;
    @Column(name = "idTipoEvolucion")
    private UUID idTipoEvolucion;
    @Column(name = "tipoEvolucion")
    private String tipoEvolucion;
    @Column(name = "descripcionEvolucion")
    private String descripcionEvolucion;
    @Column(name = "idResponsable")
    private UUID idResponsable;
    @Column(name = "responsable")
    private String responsable;
}