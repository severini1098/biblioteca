package com.globallogic.restBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.model.Genero;
import com.globallogic.restBiblioteca.service.GeneroService;

@RestController
public class GeneroController {
	
	@Autowired
	private GeneroService generoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/biblioteca/genero")
	public List<Genero> getAllGeneros(){
		List<Genero> result = generoService.findAllGeneros();
		return result;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/biblioteca/genero/{id}")
	public Genero getGenero(@PathVariable("id") Long idGenero){
		return generoService.getGeneroByID(idGenero);
	}
	
	@RequestMapping(method = RequestMethod.POST, 
					value = "/biblioteca/addGenero",
					headers = "Accept=application/xml, application/json", 
					produces="application/json")
	public @ResponseBody Genero addGenero(@RequestBody Genero genero){
		generoService.insertGenero(genero);
		return genero;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/biblioteca/deleteGenero/{id}")
	public String deleteGenero(@PathVariable("id") Long idGenero){
		generoService.deleteGenero(idGenero);
		return "Genero" +idGenero +" eliminado";
	}
				
}
