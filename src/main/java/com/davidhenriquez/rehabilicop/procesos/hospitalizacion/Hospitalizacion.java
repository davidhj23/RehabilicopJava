package com.davidhenriquez.rehabilicop.procesos.hospitalizacion;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.davidhenriquez.rehabilicop.configuracion.evolucion.TipoEvolucion;
import com.davidhenriquez.rehabilicop.listas.cie10.Cie10;
import com.davidhenriquez.rehabilicop.listas.opcion.Opcion;
import com.davidhenriquez.rehabilicop.listas.via_ingreso.ViaIngreso;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class Hospitalizacion {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idHospitaliacion;	
	
	private Date fechaIngreso;
	private String horaIngreso;
	private String ampmIngreso;
	
	private Date fechaSalida;
	private String horaSalida;
	private String ampmSalida;
	
	private String diasEstacia;
	private String acudiente;
	
	@ManyToOne
	@JoinColumn(name = "idEmbarazada", referencedColumnName = "idOpcion", nullable=true)
	private Opcion embarazada;
	private String semanas;
	@ManyToOne
	@JoinColumn(name = "idAccidenteDeTrabajo", referencedColumnName = "idOpcion", nullable=true)
	private Opcion accidenteDeTrabajo;
	@ManyToOne
	@JoinColumn(name = "idAccidenteDeTransito", referencedColumnName = "idOpcion", nullable=true)
	private Opcion accidenteDeTransito;
	@ManyToOne
	@JoinColumn(name = "idOtroTipoDeAccidente", referencedColumnName = "idOpcion", nullable=true)
	private Opcion otroTipoDeAccidente;
	
	@ManyToOne
	@JoinColumn(name = "idEventoCatastrofico", referencedColumnName = "idOpcion", nullable=true)
	private Opcion eventoCatastrofico;
	@ManyToOne
	@JoinColumn(name = "idLesionPorAgresion", referencedColumnName = "idOpcion", nullable=true)
	private Opcion lesionPorAgresion;
	@ManyToOne
	@JoinColumn(name = "idLesionAutoInfligida", referencedColumnName = "idOpcion", nullable=true)
	private Opcion lesionAutoInfligida;
	
	@ManyToOne
	@JoinColumn(name = "idMaltrato", referencedColumnName = "idOpcion", nullable=true)
	private Opcion maltrato;
	@ManyToOne
	@JoinColumn(name = "idEnfermedadGeneral", referencedColumnName = "idOpcion", nullable=true)
	private Opcion enfermedadGeneral;
	@ManyToOne
	@JoinColumn(name = "idEnfermedadProfesional", referencedColumnName = "idOpcion", nullable=true)
	private Opcion enfermedadProfesional;
	
	@ManyToOne	
	@JoinColumn(name="idViaIngreso", nullable=true)
	private ViaIngreso viaIngreso;
	
	@ManyToOne	
	@JoinColumn(name="idDiagnosticoDeIngreso", nullable=true)
	private Cie10 diagnosticoDeIngreso;
	
	@ManyToOne	
	@JoinColumn(name="idDiagnosticoDeEgreso", nullable=true)
	private Cie10 diagnosticoDeEgreso;
	
	@ManyToOne	
	@JoinColumn(name="idComplicacion", nullable=true)
	private Cie10 complicacion;
	
	@ManyToOne	
	@JoinColumn(name="idCausaDeLaMuerte", nullable=true)
	private Cie10 causaDeLaMuerte;
	
	@ManyToOne	
	@JoinColumn(name="idEnfermedadSobregenerada", nullable=true)
	private Cie10 enfermedadSobregenerada;
	
	@ManyToOne	
	@JoinColumn(name="idUsuario", nullable=true)
	private Usuario usuario;
	
	@ManyToOne	
	@JoinColumn(name="idHistoria", nullable=true)
	private Historia historia;
}