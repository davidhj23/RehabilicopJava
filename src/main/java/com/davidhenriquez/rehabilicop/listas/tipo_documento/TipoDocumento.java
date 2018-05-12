package com.davidhenriquez.rehabilicop.listas.tipo_documento;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Entity
@Data
public class TipoDocumento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)		
	private Long idTipoDocumento;
	
	@NotNull
	private String nombre;
	
	@OneToMany(mappedBy="tipoDocumento")
	@JsonBackReference(value="usuarios")	
	private Collection<Usuario> usuarios;
}
