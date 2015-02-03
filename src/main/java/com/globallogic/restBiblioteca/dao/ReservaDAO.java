package com.globallogic.restBiblioteca.dao;

import java.util.List;

import com.globallogic.restBiblioteca.model.Reserva;

public interface ReservaDAO {
	void addReserva(Reserva reserva);
	List<Reserva> findAllReservas();
	Reserva getReservaByID(Long id);
	

}
