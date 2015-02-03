package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Override
	public void insertarLibro(Libro libro) {
		getSession().saveOrUpdate(libro);
		
	}
	
	@Override
	public List<Libro> findAllLibros() {
		Criteria criteria = getSession().createCriteria(Libro.class);		
		List<Libro> results = criteria.list();
		return results;
	}
	
	@Override
	public Libro getLibroByID(Long id) {
		Session session = getSession();
		Libro result = (Libro)session.get(Libro.class, id);
		return result;
	}
	
	

}
