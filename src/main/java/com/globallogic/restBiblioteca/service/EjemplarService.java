package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.model.Ejemplar;

public interface EjemplarService {
	void insertarEjemplar(Ejemplar ejemplar);
	List<Ejemplar> findAllEjemplares();
	Ejemplar getEjemplarByID(Long id);
}
