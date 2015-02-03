package com.globallogic.restBiblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.model.Reserva;
import com.globallogic.restBiblioteca.service.ReservaService;

@RestController
public class ReservaController {
	@Autowired
	private ReservaService reservaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/reserva")
	public List<Reserva> getAllReservas(){
		return reservaService.findAllReservas();
	}
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/reserva/{id}")
	public Reserva getReserva(@RequestParam("id") Long idReserva){
		return reservaService.getReservaByID(idReserva);
	}
//	@RequestMapping(value="/biblioteca/reserva",
//					method=RequestMethod.POST, 
//					headers="Accept=application/xml, application/json",
//					produces="application/json")
//	public @ResponseBody Reserva addReserva(@RequestBody Reserva reserva){
//		
//	}
	
}
