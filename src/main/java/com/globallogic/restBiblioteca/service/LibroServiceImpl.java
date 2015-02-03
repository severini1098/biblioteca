package com.globallogic.restBiblioteca.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.restBiblioteca.dao.AutorDAO;
import com.globallogic.restBiblioteca.dao.LibroDAO;
import com.globallogic.restBiblioteca.exception.BibliotecaBusinessException;
import com.globallogic.restBiblioteca.model.Autor;
import com.globallogic.restBiblioteca.model.Libro;
@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	private LibroDAO libroDAO;
	
	@Autowired
	private AutorService autorService;
	
	@Transactional
	public void insertarLibro(Libro libro) {
		libroDAO.insertarLibro(libro);
	}

	@Transactional
	public List<Libro> findAllLibros() {
		return libroDAO.findAllLibros();
	}

	@Transactional
	public Libro getLibroByID(Long id) {
		Libro resultado = libroDAO.getLibroByID(id);
		if(libroDAO.getLibroByID(id)!=null) return resultado;
		else throw new BibliotecaBusinessException("1001", "");
	}
	
	@Transactional
	public List<Libro> getLibrosByAutorID(Long id){
		Autor autorByID = autorService.getAutorByID(id);
		if(autorByID != null){
			List<Libro>librosDeAutor = new ArrayList<Libro>(autorByID.getLibros());
			return librosDeAutor;
		}
		return null;
	}

}
