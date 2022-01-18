package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import  com.matheusgr.lunr.documento.DocumentoHtml;
import  com.matheusgr.lunr.documento.DocumentoTexto;

public class DocumentoTextoTest {
		@Test
		public void testaConstrutor(){
			DocumentoTexto documentoTexto = new DocumentoTexto("0222", "trueiru");
		}
		
		@Test
		public void testaOEquals(){
			DocumentoHtml d1= new DocumentoHtml("01","lili");
			DocumentoTexto documentoTexto = new DocumentoTexto("0222", "trueiru");
			Object documentoJava;
			assertEquals(false,d1.equals(documentoTexto));
		}
		
		
		@Test
		public void testaToString(){
			DocumentoTexto documentoTexto = new DocumentoTexto("0222", "trueiru");
			assertEquals("===0222\ntrueiru" ,documentoTexto.toString());
		}
		
		@Test
		public void testaGetMetadados(){
			DocumentoTexto documentoTexto = new DocumentoTexto("0222", "LINHAS");
			assertEquals("0", documentoTexto.getMetadados().get("LINHAS"));
		}
		
	}

