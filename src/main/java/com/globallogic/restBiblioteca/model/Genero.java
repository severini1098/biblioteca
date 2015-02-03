package com.globallogic.restBiblioteca.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="genero")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idGenero")
public class Genero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_GENERO", nullable = false)
	private Long idGenero;
	@Column(name="NOMBRE", nullable = false)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="generos")
	@JsonIgnore
	private Set<Libro> libros = new HashSet<Libro>();
	
	public Set<Libro> getLibros() {
		return libros;
	}
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return "Genero [idGenero=" +idGenero + ", nombre=" + nombre + "]";
	} 
	
	
}
