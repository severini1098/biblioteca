package com.globallogic.restBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.dto.EjemplarDTO;
import com.globallogic.restBiblioteca.exception.BibliotecaBusinessException;
import com.globallogic.restBiblioteca.mappers.EjemplarMapper;
import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.service.EjemplarService;
import com.globallogic.restBiblioteca.utils.MessageMapper;
import com.globallogic.restBiblioteca.utils.Response;

@RestController 
public class EjemplarController {
	@Autowired
	private MessageMapper messageMapper;
	@Autowired 
	private EjemplarService ejemplarService;
	@Autowired
	private EjemplarMapper ejemplarMapper;
	
	@RequestMapping(method = RequestMethod.GET, value ="/biblioteca/ejemplar")
	public List<Ejemplar> getAllEjemplares(){
		List<Ejemplar> result = ejemplarService.findAllEjemplares();
		return result;
	}
	@RequestMapping(method = RequestMethod.GET, value="biblioteca/ejemplar/{id}")
	public Ejemplar getEjemplar(@PathVariable("id") Long idEjemplar){
		return ejemplarService.getEjemplarByID(idEjemplar);
	}
	
	@RequestMapping(value = "biblioteca/ejemplar",
					method=RequestMethod.POST,
					headers="Accept=application/xml, application/json", 
					produces="application/json")
	public @ResponseBody Ejemplar addEjemplar(@RequestBody EjemplarDTO ejemplarDTO){
			Ejemplar ejemplar = ejemplarMapper.ejemplarDTOMapper(ejemplarDTO);
			ejemplarService.insertarEjemplar(ejemplar);
		return ejemplar;
	}
	@ExceptionHandler(BibliotecaBusinessException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public Response handler(final BibliotecaBusinessException ex){
		return this.messageMapper.getResponseFor(ex.getErrCode());
	}

	
	
}
