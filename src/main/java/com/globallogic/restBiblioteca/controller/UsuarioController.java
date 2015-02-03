package com.globallogic.restBiblioteca.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.model.Prestamo;
import com.globallogic.restBiblioteca.model.Reserva;
import com.globallogic.restBiblioteca.model.Usuario;
import com.globallogic.restBiblioteca.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method= RequestMethod.GET, value="/biblioteca/usuario")
	public List<Usuario> getAllUsuarios(){
		List<Usuario> result = usuarioService.findAllUsuarios();
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/usuario/{id}")
	public Usuario getUsuario(@PathVariable("id") Long idUsuario){
		return usuarioService.getUsuarioByID(idUsuario);
	}
	
	@RequestMapping(value = "/biblioteca/usuario", 
					method = RequestMethod.POST, 
					headers="Accept=application/xml, application/json", 
					produces="application/json")
	public @ResponseBody Usuario addUsuario(@RequestBody Usuario usuario){
		usuarioService.insertUsuario(usuario);
		return usuario;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/usuario/{id}/ejemplar")
	public Set<Ejemplar> getEjemplaresByUsuarioId(@PathVariable("id") Long idUsuario){
		return usuarioService.getEjemplaresByUsuarioId(idUsuario);
	}
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/usuario/{id}/prestamo")
	public Set<Prestamo> getPrestamosByUsuarioId(@PathVariable("id") Long idUsuario){
		return usuarioService.getPrestamoByUsuarioId(idUsuario);
	}
	@RequestMapping(method=RequestMethod.GET, value="/biblioteca/usuario/{id}/reserva")
	public Set<Reserva> getReservasByUsuarioId(@PathVariable("id") Long idUsuario){
		return usuarioService.getReservaByUsuarioId(idUsuario);
	}
}
