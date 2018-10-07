package com.davidhenriquez.rehabilicop.procesos.historia;

import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
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
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
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
	
	private String tipoReaccion;
	private String sustancias;	
		
	private String podromosPersonalPremorbida;
	
	private String antecendentesFamiliaresPsiquiatricos;
	private String antecendentesFamiliaresNoPsiquiatricos;
	
	private String analisisManejo;
	
	private Date fechaDeInicio;	
	
	@OneToMany(mappedBy="historia")	
	@JsonBackReference(value="patologicos")	
	private Collection<Patologico> patologicos;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="antecedentes")	
	private Collection<Antecedente> antecedentes;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="traumaticos")	
	private Collection<Traumatico> traumaticos;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="farmacologicos")	
	private Collection<Farmacologico> farmacologicos;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="toxicos")	
	private Collection<Toxico> toxicos;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="ginecoObstetricios")	
	private Collection<GinecoObstetricio> ginecoObstetricios;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos")	
	private Collection<ExamenFisico> examenFisicos;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos2")	
	private Collection<ExamenFisico2> examenFisicos2;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos3")	
	private Collection<ExamenFisico3> examenFisicos3;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos4")	
	private Collection<ExamenFisico4> examenFisicos4;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos5")	
	private Collection<ExamenFisico5> examenFisicos5;
	
	@OneToMany(mappedBy="historia")
	@JsonBackReference(value="examenFisicos6")	
	private Collection<ExamenFisico6> examenFisicos6;
		
	private UUID idImpresionDiagnostica;
	
	@ManyToOne	
	@JoinColumn(name = "idMedico", referencedColumnName = "idUsuario", nullable=false)
	private Usuario medico;
    
    @ManyToOne	
	@JoinColumn(name = "idAutoriza", referencedColumnName = "idUsuario", nullable=false)
	private Usuario autoriza;
		
	@ManyToOne	
	@JoinColumn(name="idAdmision", nullable=false)
	private Admision admision;
}
