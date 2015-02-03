package com.globallogic.restBiblioteca.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.globallogic.restBiblioteca.model.Autor;
import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.model.Libro;
import com.globallogic.restBiblioteca.service.AutorService;
import com.globallogic.restBiblioteca.service.EditorialService;
import com.globallogic.restBiblioteca.service.LibroService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
	public static void main(String[] args) {



//		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/dataBase/hibernate.xml");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/config/environment.xml");
		EditorialService editorialService = (EditorialService) ctx.getBean("editorialServiceImpl");
		LibroService libroService = (LibroService) ctx.getBean("libroServiceImpl");
		AutorService autorService = (AutorService) ctx.getBean("autorServiceImpl");
		
		List<Autor> autores = autorService.getAutorByName("Jorge LUIS", "borges");		
		System.out.println(autores);
		
		
//		List<Editorial> list = editorialService.findAllEditoriales();
//		System.out.println("User count: " + list.size());

//		Editorial ed = new Editorial();
//		ed.setNombre("Cúspide");
//		Autor autor = new Autor();
//		autor.setNombre("Jorge Luis");
//		autor.setApellido("Borges");
//		autorService.insertAutor(autor);
//		System.out.println("Autor insertado: " +autor.toString());
//		Set<Autor> autores = new HashSet<Autor>();
//		autores.add(autor);
//		
//		Libro libro = new Libro();
//		libro.setAutores(autores);
//		libro.setIsbn("123456789");
//		libro.setNombre("El Aleph");
//		
//		Libro libro2 = new Libro("123456779", "Ficciones");
//		libro2.setAutores(autores);
//		System.out.println("Libro agregado "+libro.toString());
//		System.out.println("Libro agregado "+libro2.toString());
//		libroService.insertarLibro(libro);
//		libroService.insertarLibro(libro2);
		
//		editorialService.insertEditorial(ed);
//		System.out.println("Editorial inserted!");
//
//		list = editorialService.findAllEditoriales();
//		System.out.println("Editoriales count: " + list.size());
//		
//		for (Editorial item : list){
//			System.out.println("Editorial ID: " +item.getIdEditorial() +" nombre: "+item.getNombre());
//		}
		
//		System.out.println("Test for Authors");
//		Autor aut1 = new Autor();
//		aut1.setApellido("Card");
//		aut1.setNombre("Orson Scott");
//		System.out.println(aut1);

	}
}
