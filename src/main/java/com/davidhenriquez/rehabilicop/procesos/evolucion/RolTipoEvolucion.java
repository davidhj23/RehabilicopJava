package com.davidhenriquez.rehabilicop.procesos.evolucion;

import java.util.Collection;
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
import com.davidhenriquez.rehabilicop.listas.sede.Sede;
import com.davidhenriquez.rehabilicop.procesos.admision.Admision;
import com.davidhenriquez.rehabilicop.procesos.historia.Antecedente;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico2;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico3;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico4;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico5;
import com.davidhenriquez.rehabilicop.procesos.historia.ExamenFisico6;
import com.davidhenriquez.rehabilicop.procesos.historia.Farmacologico;
import com.davidhenriquez.rehabilicop.procesos.historia.GinecoObstetricio;
import com.davidhenriquez.rehabilicop.procesos.historia.Historia;
import com.davidhenriquez.rehabilicop.procesos.historia.Patologico;
import com.davidhenriquez.rehabilicop.procesos.historia.Toxico;
import com.davidhenriquez.rehabilicop.procesos.historia.Traumatico;
import com.davidhenriquez.rehabilicop.seguridad.rol.Rol;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;

import lombok.Data;

@Entity
@Data
public class RolTipoEvolucion {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idRolTipoEvolucion;	
	
	@ManyToOne	
	@JoinColumn(name="idRol", nullable=true)
	private Rol rol;
	
	@ManyToOne	
	@JoinColumn(name="idTipoEvolucion", nullable=true)
	private TipoEvolucion tipoEolucion;
}
