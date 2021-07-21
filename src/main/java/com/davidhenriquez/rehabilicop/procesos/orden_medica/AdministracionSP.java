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
        		name = "getAdministraciones",
                procedureName = "GetAdministraciones",
                resultClasses = AdministracionSP.class,
                parameters = {@StoredProcedureParameter(name = "id_medicamentos_orden_medica", type = String.class, mode = ParameterMode.IN)})
})
public class AdministracionSP implements Serializable {
    
	@Id	
	@Column(name = "id_administracion")
    private UUID idAdministracion;
	
	@Column(name = "id_medicamentos_orden_medica")
    private UUID idMedicamentosOrdenMedica;
    
   
    @Column(name = "id_dosis")
    private UUID idDosis;
    @Column(name = "dosis")
    private String dosis;
    @Column(name = "id_administra")
    private UUID idAdministra;
    @Column(name = "nombre_administra")
    private String nombreAdministra;
    @Column(name = "apellido_administra")
    private String apellidoAdministra;
    @Column(name = "fecha_adm")
    private String fechaAdm;
    @Column(name = "hora")
    private String hora;
    @Column(name = "ampm")
    private String ampm;
    @Column(name = "valida")
    private String valida;
}
