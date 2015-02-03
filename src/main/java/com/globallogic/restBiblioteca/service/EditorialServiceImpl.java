package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.dao.EditorialDAO;
import com.globallogic.restBiblioteca.model.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialServiceImpl implements EditorialService{

	@Autowired
	private EditorialDAO editorialDAO;

	@Transactional
	public void insertEditorial(Editorial editorial) {
		editorialDAO.insertEditorial(editorial);
		
	}

	@Transactional
	public List<Editorial> findAllEditoriales() {
		return editorialDAO.findAllEditoriales();
	}
	@Transactional
	public Editorial getEditorialByID(Long id) {
		return editorialDAO.getEditorialByID(id);
	}
	
}
