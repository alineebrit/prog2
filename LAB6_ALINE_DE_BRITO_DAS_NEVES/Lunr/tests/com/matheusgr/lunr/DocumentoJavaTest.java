package com.matheusgr.lunr;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import  com.matheusgr.lunr.documento.DocumentoHtml;
import  com.matheusgr.lunr.documento.DocumentoJava;

	public class DocumentoJavaTest {
		@Test
		public void testaConstrutor(){
			DocumentoJava documentoJava = new DocumentoJava("0222", "trueiru");
		}
		
		@Test
		public void testaOEquals(){
			DocumentoHtml d1= new DocumentoHtml("01","lili");
			DocumentoJava d2 = new DocumentoJava("02","package 23;");
			Object documentoJava;
			assertEquals(false,d1.equals(d2));
		}
		
		
		@Test
		public void testaToString(){
			DocumentoJava documentoJava = new DocumentoJava("0002", "ausaus");
			assertEquals("===0002\nausaus" ,documentoJava.toString());
		}
		
		@Test
		public void testaGetMetadados(){
			DocumentoJava documentoJava = new DocumentoJava("0222", "LINHAS");
			assertEquals("0", documentoJava.getMetadados().get("LINHAS"));
		}
		
	}
