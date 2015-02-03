package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Ejemplar;

public interface EjemplarDAO {
	void insertarEjemplar(Ejemplar ejemplar);
	List<Ejemplar> findAllEjemplares();
	Ejemplar getEjemplarByID(Long id);

}
