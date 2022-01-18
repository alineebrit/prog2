package testes;

import org.junit.jupiter.api.Test;
import sistemaBiblitex.EspalhandoAmor;
import static org.junit.jupiter.api.Assertions.*;

public class TestEspalhandoAmor {
	
	@Test
	public void testaConstrutor(){
		EspalhandoAmor espalhandoAmor = new EspalhandoAmor();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			EspalhandoAmor espalhandoAmor = new EspalhandoAmor();
			espalhandoAmor.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	EspalhandoAmor espalhandoAmor = new EspalhandoAmor();
	    	espalhandoAmor.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testaTransforma() {
		EspalhandoAmor espalhandoAmor = new EspalhandoAmor();
			assertEquals("oi,<3como<3vc<3vai?", espalhandoAmor.transforma("oi, como vc vai?"));
	}
}
