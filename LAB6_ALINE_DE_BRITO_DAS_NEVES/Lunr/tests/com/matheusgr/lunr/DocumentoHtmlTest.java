package com.matheusgr.lunr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import  com.matheusgr.lunr.documento.DocumentoHtml;
import  com.matheusgr.lunr.documento.DocumentoJava;
import com.matheusgr.lunr.documento.DocumentoTexto;

public class DocumentoHtmlTest {

	@Test
	public void testaConstrutor(){
		DocumentoHtml documentoHtml = new DocumentoHtml("0222", "trueiru");
	}
	
	@Test
	public void testaOEquals(){
		DocumentoJava d1=new DocumentoJava("01","package 23;");
		DocumentoHtml d2 = new DocumentoHtml("02","lili");
		Object documentoHtml;
		assertEquals(false,d1.equals(d2));
	}
	
	
	@Test
	public void testaToString(){
		DocumentoHtml documentoHtml = new DocumentoHtml("0002", "ausaus");
		assertEquals("===0002\n\n===ausaus" ,documentoHtml.toString());
	}
	
	@Test
	public void testaGetMetadados(){
		DocumentoHtml documentoHtml = new DocumentoHtml("0222", "LINHAS");
		assertEquals("0", documentoHtml.getMetadados().get("LINHAS"));
	}
}
