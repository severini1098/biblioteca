package com.globallogic.restBiblioteca.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "reserva")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_reserva")
public class Reserva implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_RESERVA", nullable = false, unique=true)
	private Long id_reserva;
	
	@Column(name="FECHA_DISPONIBLE")
	private Date fecha_disponible;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuarioReserva;
		
	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public Date getFecha_disponible() {
		return fecha_disponible;
	}

	public void setFecha_disponible(Date fecha_disponible) {
		this.fecha_disponible = fecha_disponible;
	}

	public Usuario getUsuarioReserva() {
		return usuarioReserva;
	}

	public void setUsuarioReserva(Usuario usuarioReserva) {
		this.usuarioReserva = usuarioReserva;
	}
	
	

}
