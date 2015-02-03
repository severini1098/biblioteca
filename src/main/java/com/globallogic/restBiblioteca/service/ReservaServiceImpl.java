package com.globallogic.restBiblioteca.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.restBiblioteca.dao.ReservaDAO;
import com.globallogic.restBiblioteca.model.Reserva;
@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {
	@Autowired
	private ReservaDAO reservaDAO;
	
	@Override
	public void addReserva(Reserva reserva) {
		reservaDAO.addReserva(reserva);

	}

	@Override
	public List<Reserva> findAllReservas() {
		return reservaDAO.findAllReservas();
	}

	@Override
	public Reserva getReservaByID(Long id) {
		return reservaDAO.getReservaByID(id);
	}

}
