package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
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
	
	@Override
	public void insertarUsuario(Usuario usuario) {
	   getSession().saveOrUpdate(usuario);
		
	}

	@Override
	public List<Usuario> findAllUsuarios() {
		Criteria criteria = getSession().createCriteria(Usuario.class);
		List<Usuario> results = criteria.list();
		return results;
	}

	@Override
	public Usuario getUsuarioByID(Long id) {
		Session session = getSession();
		Usuario result = (Usuario)session.get(Usuario.class, id);
		return result;
	}
	

}
