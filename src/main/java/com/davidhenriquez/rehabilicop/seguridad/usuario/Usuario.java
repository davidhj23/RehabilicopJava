package com.davidhenriquez.rehabilicop.seguridad.usuario;

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
import com.davidhenriquez.rehabilicop.listas.cama.Cama;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idUsuario;	
	
	private String identificacion;
	
	private String username;
	
	@JsonIgnore
	private String password;
	
	private String email;
	private boolean enabled;
	
	private String nombres;
	private String apellidos;
	private String direccion;	
	private String telefono;
	private String celular;
	
	private String ocupacion;
	private Date fechaDeNacimiento;
	private Date fechaDeIngreso;
	private UUID idMedico;
	private UUID idEnfermero;	
		
	private Date fechaDeRemision;
	private String numeroRemision;
	private String acompanante;
    private String direccionAcompanante;	
    private String telefonoAcompanante;
    private String ciudadAcompanante;
    
    private UUID idAdminisionista;
	
	@ManyToOne	
	@JoinColumn(name="idTipoDocumento", nullable=false)
	private TipoDocumento tipoDocumento;
	
	@ManyToOne	
	@JoinColumn(name="idEstadoCivil", nullable=true)
	private EstadoCivil estadoCivil;
	
	@ManyToOne	
	@JoinColumn(name="idAseguradora", nullable=true)
	private Aseguradora aseguradora;
	
	@ManyToOne	
	@JoinColumn(name="idTipoEntidad", nullable=true)
	private TipoEntidad tipoEntidad;
	
	@ManyToOne	
	@JoinColumn(name="idSede", nullable=true)
	private Sede sede;
	
	@ManyToOne	
	@JoinColumn(name="idAtencion", nullable=true)
	private Atencion atencion;
	
	@ManyToOne	
	@JoinColumn(name="idCama", nullable=true)
	private Cama cama;
	
	@ManyToOne	
	@JoinColumn(name="idParentesco", nullable=true)
	private Parentesco parentesco;
	
	@ManyToOne	
	@JoinColumn(name="idDiagnosticoPrincipal", nullable=true)
	private Cie10 diagnosticoPrincipal;
	
	@ManyToOne	
	@JoinColumn(name="idDiagnosticoSecundario", nullable=true)
	private Cie10 diagnosticoSecundario;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
        name = "UsuarioRol",
        joinColumns = {@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")},
        inverseJoinColumns = {@JoinColumn(name = "idRol", referencedColumnName = "idRol")})
	private Collection<Rol> roles;
}
