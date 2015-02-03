package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.model.Editorial;


public interface EditorialService {
	void insertEditorial(Editorial editorial);
	List<Editorial> findAllEditoriales();
	Editorial getEditorialByID(Long id);
}
