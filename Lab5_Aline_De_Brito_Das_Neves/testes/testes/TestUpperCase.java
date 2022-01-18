package testes;

import org.junit.jupiter.api.Test;
import sistemaBiblitex.UpperCase;
import static org.junit.jupiter.api.Assertions.*;

public class TestUpperCase {
	
	@Test
	public void testaConstrutor(){
		UpperCase upperCase = new UpperCase();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			UpperCase upperCase = new UpperCase();
			upperCase.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	UpperCase upperCase = new UpperCase();
	    	upperCase.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testaTransforma() {
		UpperCase upperCase = new UpperCase();
			assertEquals("OI, COMO VC VAI?", upperCase.transforma("oi, como vc vai?"));
	}

}
