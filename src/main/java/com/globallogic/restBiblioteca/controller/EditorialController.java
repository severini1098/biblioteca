package com.globallogic.restBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.service.EditorialService;

@RestController
public class EditorialController {

	@Autowired
	private EditorialService editorialService;

	@RequestMapping(method = RequestMethod.GET, value = "/biblioteca/editorial")
	public List<Editorial> getAllEditoriales() {
		List<Editorial> result = editorialService.findAllEditoriales();
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/biblioteca/editorial/{id}")
	public Editorial getEditorial(@PathVariable("id") Long idEditorial){
		return editorialService.getEditorialByID(idEditorial);
	}
	@RequestMapping(value = "/biblioteca/editorial", 
					method = RequestMethod.POST, 
					headers = "Accept=application/xml, application/json",
					produces="application/json")
	public @ResponseBody Editorial addEditorial(@RequestBody Editorial editorial){
		editorialService.insertEditorial(editorial);
		return editorial;
	}
	
	
}
