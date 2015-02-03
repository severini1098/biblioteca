package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.model.Autor;

public interface AutorService {
	void insertAutor(Autor autor);
	List<Autor> findAllAutores();
	Autor getAutorByID(Long id);
	List<Autor> getAutorByName(String nombre, String apellido);
}
