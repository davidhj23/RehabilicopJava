package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.listas.aseguradora.Aseguradora;
import com.davidhenriquez.rehabilicop.listas.atencion.Atencion;
import com.davidhenriquez.rehabilicop.listas.estado_civil.EstadoCivil;
import com.davidhenriquez.rehabilicop.listas.parentesco.Parentesco;
import com.davidhenriquez.rehabilicop.listas.sede.Sede;
import com.davidhenriquez.rehabilicop.listas.tipo_documento.TipoDocumento;
import com.davidhenriquez.rehabilicop.listas.tipo_entidad.TipoEntidad;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
public class Historia {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idHistoria;	
	
	private String motivoConsulta;
	private String enfermedadActual;
	
	private String patologicoPsiquiatrico1;
	private String patologicoPsiquiatrico2;
	private String patologicoPsiquiatrico3;
	private UUID estadoPatologicoPsiquiatrico1;
	private UUID estadoPatologicoPsiquiatrico2;
	private UUID estadoPatologicoPsiquiatrico3;
	private String tiempoEvolucionPatologicoPsiquiatrico1;
	private String tiempoEvolucionPatologicoPsiquiatrico2;
	private String tiempoEvolucionPatologicoPsiquiatrico3;
	
	private String patologicoNoPsiquiatrico1;
	private String patologicoNoPsiquiatrico2;
	private String patologicoNoPsiquiatrico3;
	private UUID estadoPatologicoNoPsiquiatrico1;
	private UUID estadoPatologicoNoPsiquiatrico2;
	private UUID estadoPatologicoNoPsiquiatrico3;
	private String tiempoEvolucionPatologicoNoPsiquiatrico1;
	private String tiempoEvolucionPatologicoNoPsiquiatrico2;
	private String tiempoEvolucionPatologicoNoPsiquiatrico3;
	
	private String numeroPsiquiatrica;
	private String institucionPsiquiatrica;
	private Date fechaUltimaHospitalizacionPsiquiatrica;
	private UUID esLaPrimeraHospitalizacionPsiquiatrica;

	private String numeroNoPsiquiatrica;
	private String institucionNoPsiquiatrica;
	private Date fechaUltimaHospitalizacionNoPsiquiatrica;	
	
	private String analisisYmanejo;
	
	private Date fechaDeInicio;
		
	@ManyToOne	
	@JoinColumn(name="idAdmision", nullable=false)
	private Admision admision;
}
