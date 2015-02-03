package com.globallogic.restBiblioteca.dto;

import java.util.Set;

public class LibroDTO {
	private String isbn; 
	private String nombre;
	private Set<Long> idEditoriales;
	private Set<Long> idAutores;
	private Set<Long> idGeneros;
	
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
	public Set<Long> getIdEditoriales() {
		return idEditoriales;
	}
	public void setIdEditoriales(Set<Long> idEditoriales) {
		this.idEditoriales = idEditoriales;
	}
	public Set<Long> getIdAutores() {
		return idAutores;
	}
	public void setIdAutores(Set<Long> idAutores) {
		this.idAutores = idAutores;
	}
	public Set<Long> getIdGeneros() {
		return idGeneros;
	}
	public void setIdGeneros(Set<Long> idGeneros) {
		this.idGeneros = idGeneros;
	}
	
}
