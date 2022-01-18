package testes;

import org.junit.jupiter.api.Test;
import sistemaBiblitex.InterrogaParaPonto;
import static org.junit.jupiter.api.Assertions.*;

public class TestInterrogaParaPonto {

	@Test
	public void testaConstrutor(){
		InterrogaParaPonto interrogaParaPonto = new InterrogaParaPonto();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			InterrogaParaPonto interrogaParaPonto = new InterrogaParaPonto();
			interrogaParaPonto.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	InterrogaParaPonto interrogaParaPonto = new InterrogaParaPonto();
	    	interrogaParaPonto.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testaTransforma() {
		InterrogaParaPonto interrogaParaPonto = new InterrogaParaPonto();
			assertEquals("tudo bem.", interrogaParaPonto.transforma("tudo bem?"));
	}
}
