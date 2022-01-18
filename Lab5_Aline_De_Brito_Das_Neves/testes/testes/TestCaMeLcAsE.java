package testes;
import org.junit.jupiter.api.Test;
import sistemaBiblitex.CaMeLcAsE;
import static org.junit.jupiter.api.Assertions.*;

public class TestCaMeLcAsE {
	
	@Test
	public void testConstrutor(){
		CaMeLcAsE camelcase = new CaMeLcAsE();
		
		}
	
	@Test
	public void testTransformaNulo() {
		try{
			CaMeLcAsE camelcase = new CaMeLcAsE();
			camelcase.transforma(null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaVazio() {
	    try{
	    	CaMeLcAsE camelcase = new CaMeLcAsE();
	    	camelcase.transforma("");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	
	@Test
	public void testTransforma() {
		CaMeLcAsE camelcase = new CaMeLcAsE();
			assertEquals("Oi, CoMo vC VaI",camelcase.transforma("oi, como vc vai"));
	}
}
