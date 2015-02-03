package com.globallogic.restBiblioteca.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "libro")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idLibro")
public class Libro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_LIBRO", nullable = false)
	private Long idLibro;

	@Column(name = "ISBN", nullable = false, unique = true)
	private String isbn;

	@Column(name = "NOMBRE")
	private String nombre;

	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
	@JoinTable(name = "LIBRO_AUTOR", joinColumns = { @JoinColumn(name = "ID_LIBRO") }, inverseJoinColumns = { @JoinColumn(name = "ID_AUTOR") })
	private Set<Autor> autores = new HashSet<Autor>();

	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
	@JoinTable(name = "LIBRO_EDITORIAL", joinColumns = { @JoinColumn(name = "ID_LIBRO") }, inverseJoinColumns = { @JoinColumn(name = "ID_EDITORIAL") })
	private Set<Editorial> editoriales = new HashSet<Editorial>();

	@ManyToMany(fetch = FetchType.EAGER,cascade = { CascadeType.ALL })
	@JoinTable(name = "LIBRO_GENERO", joinColumns = { @JoinColumn(name = "ID_LIBRO") }, inverseJoinColumns = { @JoinColumn(name = "ID_GENERO") })
	private Set<Genero> generos = new HashSet<Genero>();
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="libro")
	@JsonIgnore
	private Set<Ejemplar> ejemplares;

	public Set<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Set<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Set<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Set<Editorial> editoriales) {
		this.editoriales = editoriales;
	}

	public Set<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

	public Libro() {

	}

	public Libro(String isbn, String nombre) {
		this.isbn = isbn;
		this.nombre = nombre;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}

	public Long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Long idLibro) {
		this.idLibro = idLibro;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Libro) {
			Libro libro = (Libro) obj;

			if (this.isbn.equals(libro.getIsbn())
					&& this.nombre.equals(libro.getNombre()))
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", nombre=" + nombre + ", autores="
				+ autores + "]";
	}

}
