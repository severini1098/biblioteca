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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="prestamo")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idPrestamo")
public class Prestamo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PRESTAMO", nullable = false, unique = true)
	private Long idPrestamo;
	@Column(name="FECHA_PRESTAMO")
	private Date fechaPrestamo;
	@Column(name="FECHA_DEVOLUCION")
	private Date fechaDevolucion;
	@Column(name="FECHA_DEVUELTO")
	private Date fechaDevuelto;
	
	@ManyToOne
	@JoinColumn(name="id_ejemplar")
	@JsonIgnore
	private Ejemplar ejemplar;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	@JsonIgnore
	private Usuario usuarioPrestamo;
 
	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Date getFechaDevuelto() {
		return fechaDevuelto;
	}

	public void setFechaDevuelto(Date fechaDevuelto) {
		this.fechaDevuelto = fechaDevuelto;
	}

	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public void setEjemplar(Ejemplar ejemplar) {
		this.ejemplar = ejemplar;
	}

	public Usuario getUsuarioPrestamo() {
		return usuarioPrestamo;
	}

	public void setUsuarioPrestamo(Usuario usuarioPrestamo) {
		this.usuarioPrestamo = usuarioPrestamo;
	}
	

}
