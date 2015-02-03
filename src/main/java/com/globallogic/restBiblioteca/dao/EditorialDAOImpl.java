package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Editorial;


@Repository
public class EditorialDAOImpl implements EditorialDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertEditorial(Editorial editorial) {
		getSession().saveOrUpdate(editorial);
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	public List<Editorial> findAllEditoriales() {
		Criteria criteria = getSession().createCriteria(Editorial.class);
		List<Editorial> results = criteria.list();
		return results;
	}
	
	public Editorial getEditorialByID(Long id){
		Session session = getSession();
		Editorial result = (Editorial)session.get(Editorial.class, id);
		return result;
	}
	
}
