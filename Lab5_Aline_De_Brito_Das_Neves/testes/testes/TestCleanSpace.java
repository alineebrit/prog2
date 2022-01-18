package testes;
import sistemaBiblitex.CleanSpace;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestCleanSpace {	
	
	@Test
	public void testaConstrutor(){
		CleanSpace cleanSpace = new CleanSpace();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			CleanSpace cleanSpace = new CleanSpace();
			cleanSpace.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	CleanSpace cleanSpace = new CleanSpace();
			cleanSpace.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testaTransforma() {
		CleanSpace cleanSpace = new CleanSpace();
			assertEquals("oi,comovcvai?", cleanSpace.transforma("oi, como vc vai?"));
	}
	
}
