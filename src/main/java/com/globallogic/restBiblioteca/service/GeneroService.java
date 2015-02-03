package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.model.Genero;


public interface GeneroService {
	void insertGenero(Genero genero);
	List<Genero> findAllGeneros();
	Genero getGeneroByID(Long id);
	void deleteGenero(Long idGenero);
}
