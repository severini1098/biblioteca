package com.globallogic.restBiblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.restBiblioteca.dao.EjemplarDAO;
import com.globallogic.restBiblioteca.model.Ejemplar;

@Service
@Transactional
public class EjemplarServiceImpl implements EjemplarService {
	@Autowired
	private EjemplarDAO ejemplarDAO;
	
	@Override
	public void insertarEjemplar(Ejemplar ejemplar) {
		ejemplarDAO.insertarEjemplar(ejemplar);
		
	}

	@Override
	public List<Ejemplar> findAllEjemplares() {
		return ejemplarDAO.findAllEjemplares();
	}

	@Override
	public Ejemplar getEjemplarByID(Long id) {
		return ejemplarDAO.getEjemplarByID(id);
	}
	
}
