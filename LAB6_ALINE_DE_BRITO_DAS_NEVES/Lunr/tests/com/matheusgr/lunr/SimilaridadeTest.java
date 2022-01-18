package com.matheusgr.lunr;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimilaridadeTest extends BaseTest{
	
	@Test
	public void testSimilaridadeEntreDoisTextos() {
		assertEquals(0.5,this.similaridadeController.similaridade(TEXTO1_ID, TEXTO2_ID));
	}

	@Test
	public void testSimilaridadeEntreTextoJavaEHtml() {
		assertEquals(0.014925373134328358,this.similaridadeController.similaridade(JAVA_ID, HTML_ID));
	}
	
	@Test
	public void testSimilaridadeEntreTextoJavaETexto2() {
		assertEquals(0.022727272727272728,this.similaridadeController.similaridade(JAVA_ID, TEXTO2_ID));
	}
	
	@Test
	public void testSimilaridadeEntreTextoJavaETexto1() {
		assertEquals(0.023809523809523808,this.similaridadeController.similaridade(JAVA_ID, TEXTO1_ID));
	}
	
	@Test
	public void testSimilaridadeEntreTextoHtmlETexto1() {
		assertEquals(0.009259259259259259,this.similaridadeController.similaridade(HTML_ID, TEXTO1_ID));
	}
	
	@Test
	public void testSimilaridadeEntreTextoHtmlETexto2() {
		assertEquals(0.00909090909090909,this.similaridadeController.similaridade(HTML_ID, TEXTO2_ID));
	}
	
}
