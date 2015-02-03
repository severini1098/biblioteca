package com.globallogic.restBiblioteca.service;

import java.util.List;

import com.globallogic.restBiblioteca.model.Reserva;

public interface ReservaService {
	void addReserva(Reserva reserva);
	List<Reserva> findAllReservas();
	Reserva getReservaByID(Long id);
}
