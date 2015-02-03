package com.globallogic.restBiblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.restBiblioteca.dao.GeneroDAO;
import com.globallogic.restBiblioteca.model.Genero;
@Service
public class GeneroServiceImpl implements GeneroService {
	
	@Autowired
	private GeneroDAO generoDAO;
	
	@Transactional
	public void insertGenero(Genero genero) {
		generoDAO.insertarGenero(genero);

	}

	@Transactional
	public List<Genero> findAllGeneros() {
		return generoDAO.findAllGeneros();
	}

	@Transactional
	public Genero getGeneroByID(Long id) {
		return generoDAO.getGeneroByID(id);
	}

	@Transactional
	public void deleteGenero(Long idGenero) {
		generoDAO.deleteGenero(idGenero);
	}

}
