package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Ejemplar;
@Repository
public class EjemplarDAOImpl implements EjemplarDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	@Override
	public void insertarEjemplar(Ejemplar ejemplar) {
		getSession().saveOrUpdate(ejemplar);
		
	}

	@Override
	public List<Ejemplar> findAllEjemplares() {
		Criteria criteria = getSession().createCriteria(Ejemplar.class);
		List<Ejemplar> results = criteria.list();
		return results;
	}

	@Override
	public Ejemplar getEjemplarByID(Long id) {
		Session session = getSession();
		Ejemplar result = (Ejemplar) session.get(Ejemplar.class, id);
		return result;
	}
	

}
