package com.globallogic.restBiblioteca.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.restBiblioteca.dto.LibroDTO;
import com.globallogic.restBiblioteca.mappers.LibroMapper;
import com.globallogic.restBiblioteca.model.Libro;
import com.globallogic.restBiblioteca.service.AutorService;
import com.globallogic.restBiblioteca.service.EditorialService;
import com.globallogic.restBiblioteca.service.GeneroService;
import com.globallogic.restBiblioteca.service.LibroService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibroController {
	
	@Autowired
	private LibroService libroService;
	@Autowired
	private LibroMapper libroMapper;
		
	@RequestMapping(method = RequestMethod.GET, value ="/biblioteca/libro")
	public List<Libro> getAllLibros(@RequestParam(value="autorID", required = false)Long autorID){
		List<Libro> result = new ArrayList<Libro>();
		if(autorID == null){
			result = (List<Libro>)libroService.findAllLibros();
		}
		if(autorID !=null){
			result = libroService.getLibrosByAutorID(autorID);
		}
		return result;
	}
		
	
	@RequestMapping(method= RequestMethod.GET, value="/biblioteca/libro/{id}")
	public Libro getLibro(@PathVariable("id") Long idLibro){
		return libroService.getLibroByID(idLibro);
	}
	
	@RequestMapping(value = "/biblioteca/libro",
					method = RequestMethod.POST,
					headers = "Accept=application/xml, application/json", 
					produces="application/json")
	public @ResponseBody Libro addLibro(@RequestBody LibroDTO libroDTO){
		Libro libro = new Libro();
		libro = libroMapper.libroDTOMapper(libroDTO);
		libroService.insertarLibro(libro);
		return libro;		
	}
}
