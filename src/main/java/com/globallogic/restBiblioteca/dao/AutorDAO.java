package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Autor;

public interface AutorDAO {
	void insertAutor(Autor autor);
	List<Autor> findAllAutores();
	Autor getAutorByID(Long id);
	List<Autor> getAutorByName(String nombre, String apellido);
}
