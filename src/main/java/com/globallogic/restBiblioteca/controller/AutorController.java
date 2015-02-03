package com.globallogic.restBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.model.Autor;
import com.globallogic.restBiblioteca.service.AutorService;

@RestController
public class AutorController {

		@Autowired
		private AutorService autorService;
		
		@RequestMapping(method = RequestMethod.GET, value = "/biblioteca/autor")
		public List<Autor> getAllAutores(){
			List<Autor> result = autorService.findAllAutores();
			return result;
		}
		
		@RequestMapping(method = RequestMethod.GET, value = "biblioteca/autor/{id}")
		public Autor getAutor(@PathVariable("id") Long idAutor){
			return autorService.getAutorByID(idAutor);
		}
		
		@RequestMapping(value = "/biblioteca/autor",
				method = RequestMethod.POST,
				headers = "Accept=application/xml, application/json",
				produces="application/json")
		public @ResponseBody Autor addAutor(@RequestBody Autor autor){
				autorService.insertAutor(autor);
				return autor;
		}
}
