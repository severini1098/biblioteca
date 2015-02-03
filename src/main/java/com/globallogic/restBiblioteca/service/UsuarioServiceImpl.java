package com.globallogic.restBiblioteca.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.restBiblioteca.dao.UsuarioDAO;



import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.model.Prestamo;
import com.globallogic.restBiblioteca.model.Reserva;
import com.globallogic.restBiblioteca.model.Usuario;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	private Usuario usuario = new Usuario();

	@Override
	public void insertUsuario(Usuario usuario) {
		usuarioDAO.insertarUsuario(usuario);
		
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		return usuarioDAO.findAllUsuarios(); 
	}

	@Override
	public Usuario getUsuarioByID(Long id) {
		return usuarioDAO.getUsuarioByID(id);
	}

	@Override
	public Set<Ejemplar> getEjemplaresByUsuarioId(Long id) {
		usuario = usuarioDAO.getUsuarioByID(id);
		if(usuario!=null) return new HashSet<Ejemplar>(usuario.getEjemplares());
		return null;
	}
	public Set<Reserva> getReservaByUsuarioId(Long id){
		usuario = usuarioDAO.getUsuarioByID(id);
		if(usuario!=null) return new HashSet<Reserva>(usuario.getReservas());
		return null;
	}
	public Set<Prestamo> getPrestamoByUsuarioId(Long id){
		usuario = usuarioDAO.getUsuarioByID(id);
		if(usuario!=null) return new HashSet<Prestamo>(usuario.getPrestamos());
		return null;
	}
	
	
	
}
