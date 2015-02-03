package com.globallogic.restBiblioteca.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.globallogic.restBiblioteca.dto.EjemplarDTO;
import com.globallogic.restBiblioteca.model.Ejemplar;
import com.globallogic.restBiblioteca.model.Libro;
import com.globallogic.restBiblioteca.model.Usuario;
import com.globallogic.restBiblioteca.service.LibroService;
import com.globallogic.restBiblioteca.service.UsuarioService;

@Component
public class EjemplarMapper {
	@Autowired
	LibroService libroService;
	@Autowired
	UsuarioService usuarioService;
	private Libro libro = new Libro();
	private Usuario usuario = new Usuario();
	private Ejemplar ejemplar = new Ejemplar();
	
	public Ejemplar ejemplarDTOMapper(EjemplarDTO ejemplarDTO){

		libro = libroService.getLibroByID(ejemplarDTO.getIdLibro());
		usuario = usuarioService.getUsuarioByID(ejemplarDTO.getIdUsuario());
		ejemplar.setEstado(ejemplarDTO.getEstado());
		ejemplar.setLibro(libro);
		ejemplar.setPrestado(ejemplarDTO.getPrestado());
		ejemplar.setReservado(ejemplarDTO.getReservado());
		ejemplar.setUsuarioEjemplar(usuario);
		return ejemplar; 
	}

}
