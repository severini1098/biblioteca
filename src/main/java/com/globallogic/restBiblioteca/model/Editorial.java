package com.globallogic.restBiblioteca.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="editorial")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idEditorial")
public class Editorial implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_EDITORIAL", nullable = false)	
	private Long idEditorial;
	
	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy="editoriales")
	@JsonIgnore
	private Set<Libro> libros = new HashSet<Libro>();
	
	public Set<Libro> getLibros() {
		return libros;
	}
	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	public Long getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(Long idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString(){
		return "idEditorial=" + this.idEditorial + ", nombre=" + this.nombre;
	}
	
}
