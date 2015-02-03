package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jpa.criteria.expression.function.UpperFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Autor;

@Repository
public class AutorDAOImpl implements AutorDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	
	public void insertAutor(Autor autor) {
		getSession().saveOrUpdate(autor);
		
	}

	
	public List<Autor> findAllAutores() {
		Criteria criteria = getSession().createCriteria(Autor.class);
		List<Autor> results = criteria.list();
		return results;
	}
	
	public List<Autor> getAutorByName(String nombreAutor, String apellidoAutor){
		
		Query query = getSession().createSQLQuery("SELECT * FROM AUTOR WHERE UPPER(NOMBRE) like ? AND UPPER(APELLIDO) like ?").addEntity(Autor.class);
		query.setString(0, (nombreAutor).toUpperCase());
		query.setString(1, (apellidoAutor).toUpperCase());
		List<Autor> pusList = query.list();
		return pusList;

	}
	
	public Autor getAutorByID(Long id) {
		Session session = getSession();
		Autor result = (Autor)session.get(Autor.class, id);
		return result;
	}
	

}
