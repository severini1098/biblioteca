package com.globallogic.restBiblioteca.service;

import java.util.List;
import java.util.Set;

import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.model.Prestamo;
import com.globallogic.restBiblioteca.model.Reserva;
import com.globallogic.restBiblioteca.model.Usuario;


public interface UsuarioService {
	void insertUsuario(Usuario usuario);
	List<Usuario> findAllUsuarios();
	Usuario getUsuarioByID(Long id);
	Set<Ejemplar> getEjemplaresByUsuarioId(Long id);
	Set<Reserva> getReservaByUsuarioId(Long id);
	Set<Prestamo> getPrestamoByUsuarioId(Long id);
}
