package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.model.Genero;

@Repository
public class GeneroDAOImpl implements GeneroDAO {

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
	public void insertarGenero(Genero genero) {
		getSession().saveOrUpdate(genero);
	}

	@Override
	public List<Genero> findAllGeneros() {
		Criteria criteria = getSession().createCriteria(Genero.class);
		List<Genero> results = criteria.list();
		return results;
	}

	@Override
	public Genero getGeneroByID(Long id) {
		Session session = getSession();
		Genero result = (Genero)session.get(Genero.class, id);
		return result;
	}

	@Override
	public void deleteGenero(Long idGenero) {
		Session session = getSession();
		Genero genero = (Genero) session.load(Genero.class, new Long(idGenero));
		if(null != genero){
			session.delete(genero);
		}

	}

}
