package com.globallogic.restBiblioteca.mappers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.restBiblioteca.dto.LibroDTO;
import com.globallogic.restBiblioteca.model.Autor;
import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.model.Genero;
import com.globallogic.restBiblioteca.model.Libro;
import com.globallogic.restBiblioteca.service.AutorService;
import com.globallogic.restBiblioteca.service.EditorialService;
import com.globallogic.restBiblioteca.service.GeneroService;
import com.globallogic.restBiblioteca.service.LibroService;

@Component
public class LibroMapper {
	@Autowired
	private EditorialService editorialService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private GeneroService generoService;
	
	private Genero genero;
	private Editorial editorial;
	private Autor autor;
	
	public Libro libroDTOMapper(LibroDTO libroDTO){
		Libro libro = new Libro();
		libro.setAutores(obtenerAutores(libroDTO.getIdAutores()));
		libro.setEditoriales(obtenerEditoriales(libroDTO.getIdEditoriales()));
		libro.setGeneros(obtenerGeneros(libroDTO.getIdGeneros()));
		libro.setIsbn(libroDTO.getIsbn());
		libro.setNombre(libroDTO.getNombre());
		return libro;
		
	}
	public Set<Autor> obtenerAutores(Set<Long> idAutores){
		Set<Autor> autores = new HashSet<Autor>();
		autor = new Autor();
		for(Long iterador: idAutores){
			autor = autorService.getAutorByID(iterador.longValue());
			autores.add(autor);
		}
		return autores;
	}
	public Set<Editorial> obtenerEditoriales(Set<Long> idEditoriales){
		Set<Editorial> editoriales = new HashSet<Editorial>();
		for(Long iterador: idEditoriales){
			editorial = editorialService.getEditorialByID(iterador.longValue());
			editoriales.add(editorial);
		}
		return editoriales;
	}
	
	public Set<Genero> obtenerGeneros(Set<Long> idGeneros){
		Set<Genero> generos = new HashSet<Genero>();
		for (Long iterador: idGeneros){
			genero = generoService.getGeneroByID(iterador.longValue());
			generos.add(genero);
		}
		return generos;
	}
	
	
}
