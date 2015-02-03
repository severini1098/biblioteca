package com.globallogic.restBiblioteca.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="ejemplar")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id_ejemplar")
public class Ejemplar implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_EJEMPLAR", nullable = false)
	private Long id_ejemplar;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="PRESTADO")
	private Boolean prestado;
	
	@Column(name="RESERVADO")
	private Boolean reservado;
	
	@ManyToOne
	@JoinColumn(name="idLibro")
	@JsonIgnore
	private Libro libro;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="ejemplar")
	@JsonIgnore
	private Set<Prestamo> prestamos;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idUsuario")
	private Usuario usuarioEjemplar;
	
	
	public Set<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Set<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Usuario getUsuarioEjemplar() {
		return usuarioEjemplar;
	}

	public void setUsuarioEjemplar(Usuario usuarioEjemplar) {
		this.usuarioEjemplar = usuarioEjemplar;
	}

	public long getId_ejemplar() {
		return id_ejemplar;
	}

	public void setId_ejemplar(long id_ejemplar) {
		this.id_ejemplar = id_ejemplar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getPrestado() {
		return prestado;
	}

	public void setPrestado(Boolean prestado) {
		this.prestado = prestado;
	}

	public Boolean getReservado() {
		return reservado;
	}

	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	
	
	
	
	
}
