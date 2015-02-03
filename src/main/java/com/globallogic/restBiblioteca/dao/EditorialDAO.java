package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Editorial;

public interface EditorialDAO {
	void insertEditorial(Editorial editorial);
	List<Editorial> findAllEditoriales();
	Editorial getEditorialByID(Long id);
}
