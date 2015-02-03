package restBiblioteca;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.globallogic.restBiblioteca.model.Autor;
import com.globallogic.restBiblioteca.model.Editorial;
import com.globallogic.restBiblioteca.service.EditorialService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring/dataBase/hibernate.xml")
public class DBTest {
	
	@Autowired
	public EditorialService editorialService;
	
	public EditorialService getEditorialService() {
		return editorialService;
	}

	public void setEditorialService(EditorialService editorialService) {
		this.editorialService = editorialService;
	}

	@Before
	public void loadData(){
		
		//Creaci�n de editoriales
		Editorial ed1 = new Editorial();
		Editorial ed2 = new Editorial();
		
		//Carga de editiariales con valores
		ed1.setNombre("Editorial Atlantida");
		ed2.setNombre("Editorial Universo");
		
		//Carga de Autores
		Autor aut1 = new Autor();
		Autor aut2 = new Autor();
		
		aut1.setNombre("Orson Scott");
		aut1.setApellido("Card");
		aut2.setNombre("Paulo");
		aut2.setApellido("Coelho");
	}
	
	 @Test
	 public void testSaveEditorial(){
//		 ApplicationContext ctx = new ClassPathXmlApplicationContext("/spring/dataBase/hibernate.xml");
//		 EditorialService editorialService = (EditorialService) ctx.getBean("editorialServiceImpl");
		 Editorial ed1 = new Editorial(); 
		 ed1.setNombre("Editorial Atl�ntida");
		 editorialService.insertEditorial(ed1);
		 Set<Editorial> editoriales = new HashSet<Editorial>(editorialService.findAllEditoriales());
		 
		 for (Editorial item: editoriales){
			 System.out.println("Editorial: " + item.getNombre());
		 }
		 
	 }
}
