package com.globallogic.restBiblioteca.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.model.Reserva;

@Repository
public class ReservaDAOImpl implements ReservaDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public Session getSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Override
	public void addReserva(Reserva reserva) {
		getSession().saveOrUpdate(reserva);

	}

	@Override
	public List<Reserva> findAllReservas() {
		Criteria criteria = getSession().createCriteria(Reserva.class);
		List<Reserva> results = criteria.list();
		return results;
	}

	@Override
	public Reserva getReservaByID(Long id) {
		Session session = getSession();
		Reserva result = (Reserva) session.get(Reserva.class, id);
		return result;
	}

}
