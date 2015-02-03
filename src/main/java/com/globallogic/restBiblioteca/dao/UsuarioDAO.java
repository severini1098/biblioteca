package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Usuario;

public interface UsuarioDAO {
	void insertarUsuario(Usuario usuario);
	List<Usuario> findAllUsuarios();
	Usuario getUsuarioByID(Long id);

}
