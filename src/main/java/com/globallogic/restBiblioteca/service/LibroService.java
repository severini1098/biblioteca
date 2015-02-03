package com.globallogic.restBiblioteca.service;

import java.util.List;
import java.util.Set;

import com.globallogic.restBiblioteca.model.Libro;

public interface LibroService {
	void insertarLibro(Libro libro);
	List<Libro> findAllLibros();
	Libro getLibroByID(Long id);
	List<Libro> getLibrosByAutorID(Long id);
}
