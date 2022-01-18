package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sistemaBiblitex.Clean;
import sistemaBiblitex.ConsoleLogger;
import sistemaBiblitex.TransformaTexto;


public class TestTransformaTexto {

	@Test
	public void testConstrutor1(){
		TransformaTexto transformaTexto = new TransformaTexto();
		
		}
	
	@Test
	public void testConstrutor2(){
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
		
		}
	
	@Test
	public void testTransformaComTipoNulo() {
		try{
			TransformaTexto transformaTexto = new TransformaTexto();
			transformaTexto.transforma(null, "Eu quero férias!");	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaComTipoVazio() {
	    try{
	    	TransformaTexto transformaTexto = new TransformaTexto();
	    	transformaTexto.transforma("", "Eu quero férias!");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testTransformaComMensagemNula() {
		try{
			TransformaTexto transformaTexto = new TransformaTexto();
			transformaTexto.transforma("Clean", null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testTransformaComMensagemVazia() {
	    try{
	    	TransformaTexto transformaTexto = new TransformaTexto();
	    	transformaTexto.transforma("Clean", "");	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testTransforma() {
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
			assertEquals("[transforma] Clean\nvc tá bem",transformaTexto.transforma("Clean", "vc tá bem?"));
	}
	
	@Test
	public void testCadastraTransformacaoComTipoNulo() {
		try{
			TransformaTexto transformaTexto = new TransformaTexto();
			Clean clean = new Clean();
			transformaTexto.cadastraTransformacao(null, clean);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testCadastraTransformacaoComTipoVazio() {
	    try{
	    	TransformaTexto transformaTexto = new TransformaTexto();
	    	Clean clean = new Clean();
	    	transformaTexto.cadastraTransformacao("", clean);	
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada Inválida.",e.getMessage());
	     }
	}
	
	@Test
	public void testCadastraTransformacaoAlgoritmoNulo() {
		try{
			TransformaTexto transformaTexto = new TransformaTexto();
			transformaTexto.cadastraTransformacao("LimpaSinais", null);	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada Inválida.",npe.getMessage());
	     }
	}
	
	@Test
	public void testCadastraTransformacaoSemLogger() {
		Clean clean = new Clean();
		TransformaTexto transformaTexto = new TransformaTexto();
		assertEquals("",transformaTexto.cadastraTransformacao("LimpaSinais",clean));
	}
	
	@Test
	public void testCadastraTransformacaoComLogger() {
		Clean clean = new Clean();
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
		assertEquals("[cadastraTransformacao] LimpaSinais\n",transformaTexto.cadastraTransformacao("LimpaSinais",clean));
	}
	
	@Test
	public void testListaTransformacoes() {
		TransformaTexto transformaTexto = new TransformaTexto();
		assertEquals("CaMeLcAsE\nClean\nCleanSpace\nEspalhandoAmor\nInterrogaParaPonto\nUpperCase\n",transformaTexto.listaTransformacoes());
	}
	
	@Test
	public void testContagemDeTransformacoesSemLogger() {
		TransformaTexto transformaTexto = new TransformaTexto();
		transformaTexto.transforma("Clean", "vc tá bem?");
		transformaTexto.transforma("EspalhandoAmor", "vc tá bem?");
		assertEquals("2",transformaTexto.contagemDeTransformacoes());
	}
	
	@Test
	public void testContagemDeTransformacoesComLogger() {
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
		transformaTexto.transforma("Clean", "vc tá bem?");
		transformaTexto.transforma("EspalhandoAmor", "vc tá bem?");
		assertEquals("[contagemDeTransformacoes] \n2",transformaTexto.contagemDeTransformacoes());
	}
	
	@Test
	public void testListagemDeOriginaisSemLogger() {
		TransformaTexto transformaTexto = new TransformaTexto();
		transformaTexto.transforma("EspalhandoAmor", "Aline é linda!");
		transformaTexto.transforma("InterrogaParaPonto", "Aline é linda!");
		transformaTexto.listagemDeOriginais();
		assertEquals("Aline é linda!\nAline é linda!\n",transformaTexto.listagemDeOriginais());
	}
	
	@Test
	public void testListagemDeOriginaisComLogger() {
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
		transformaTexto.transforma("EspalhandoAmor", "Aline é linda!");
		transformaTexto.transforma("InterrogaParaPonto", "Aline é linda!");
		transformaTexto.listagemDeOriginais();
		assertEquals("[listagemDeOriginais] \nAline é linda!\nAline é linda!\n",transformaTexto.listagemDeOriginais());
	}

	@Test
	public void testListagemDeHistoricoSemLogger() {
		TransformaTexto transformaTexto = new TransformaTexto();
		transformaTexto.transforma("EspalhandoAmor", "Aline é linda!");
		assertEquals("Aline é linda!-> EspalhandoAmor-> Aline<3é<3linda!",transformaTexto.listagemDeHistorico(0));
	}

	@Test
	public void testListagemDeHistoricoComLogger() {
		ConsoleLogger consoleLogger = new ConsoleLogger();
		TransformaTexto transformaTexto = new TransformaTexto(consoleLogger);
		transformaTexto.transforma("EspalhandoAmor", "Aline é linda!");
		assertEquals("[listagemDeHistorico] 0\nAline é linda!-> EspalhandoAmor-> Aline<3é<3linda!",transformaTexto.listagemDeHistorico(0));
	}
	
	
}




