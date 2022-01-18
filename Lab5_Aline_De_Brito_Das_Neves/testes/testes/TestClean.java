package testes;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import sistemaBiblitex.Clean;

public class TestClean {
	
	@Test
	public void testaConstrutor(){
		Clean clean = new Clean();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			Clean clean = new Clean();
			clean.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	Clean clean = new Clean();
			clean.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testaTransforma() {
		Clean clean = new Clean();
			assertEquals("oi como vc vai" ,clean.transforma("oi, como vc vai?"));
	}
	
	
}