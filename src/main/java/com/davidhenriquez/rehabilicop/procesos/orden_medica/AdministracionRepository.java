package com.davidhenriquez.rehabilicop.procesos.orden_medica;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.JpaRepository;

import com.davidhenriquez.rehabilicop.listas.dosis.Dosis;
import com.davidhenriquez.rehabilicop.listas.medicamento.Medicamento;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.Epicrisis;
import com.davidhenriquez.rehabilicop.procesos.epicrisis.TratamientoFarmacologico;
import com.davidhenriquez.rehabilicop.seguridad.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

public interface AdministracionRepository extends JpaRepository<Administracion, UUID> {

}