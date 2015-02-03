package com.globallogic.restBiblioteca.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globallogic.restBiblioteca.dao.AutorDAO;
import com.globallogic.restBiblioteca.dao.LibroDAO;
import com.globallogic.restBiblioteca.model.Autor;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorDAO autorDAO;
	
	@Transactional
	public void insertAutor(Autor autor) {
		autorDAO.insertAutor(autor);
		
	}

	@Transactional
	public List<Autor> findAllAutores() {
		return autorDAO.findAllAutores();
	}

	@Transactional
	public Autor getAutorByID(Long id) {
		return autorDAO.getAutorByID(id);
	}
	
	@Transactional
	public List<Autor> getAutorByName(String nombre, String apellido){
		return autorDAO.getAutorByName(nombre, apellido);
	}
}
