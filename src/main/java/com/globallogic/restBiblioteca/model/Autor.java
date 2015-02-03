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
@Table(name="autor")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idAutor")
public class Autor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_AUTOR", nullable = false)
	private Long idAutor;
	
	@Column(name ="NOMBRE", nullable = false)
	private String nombre;	
	
	@Column(name="APELLIDO", nullable = false)
	private String apellido;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="autores")
	@JsonIgnore
	private Set<Libro> libros = new HashSet<Libro>();

	public Long getIdAutor() {
		return idAutor;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombre=" + nombre
				+ ", apellido=" + apellido + "]";
	}
	
	public Autor(){
		
	}
	public Autor(String nombre, String apellido){
		this.nombre = nombre; 
		this.apellido = apellido;
	}
	
}
