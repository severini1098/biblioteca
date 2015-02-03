package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Libro;

public interface LibroDAO {
	void insertarLibro(Libro libro);
	List<Libro> findAllLibros();
	Libro getLibroByID(Long id);
}
