package com.davidhenriquez.rehabilicop.listas.aseguradora;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Aseguradora{
	
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID idAseguradora;
	
    private String nombre; 
    
    @ManyToOne	
	@JoinColumn(name="idAuditor", nullable=true)
	private Usuario auditor;
    
    @OneToMany(mappedBy="aseguradora")
	@JsonBackReference(value="usuarios")	
	private Collection<Usuario> usuarios;
}
