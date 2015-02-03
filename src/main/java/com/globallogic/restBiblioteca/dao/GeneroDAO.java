package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Genero;

public interface GeneroDAO {
	void insertarGenero(Genero genero);
	List<Genero> findAllGeneros();
	Genero getGeneroByID(Long id);
	void deleteGenero(Long idGenero);
	
}
