package teste;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import agenda.Contato;

public class ContatoTeste {
	
	private Contato contato1;
	private Contato contato2;
	private Contato contato3;

	@BeforeEach
	void preparaContato() {
		
		/**Prepara inicialmente contatos para ser testados.
		 * 
		 */
		this.contato1 = new Contato("Matheus", "Gaudencio","98788-8979");
		this.contato2 = new Contato("Livia", "Sampaio", "9999-0001");
		this.contato3 = new Contato("Nazareno", "Jesus", "9999-1001");
		
		/**Prepara tags.
		 * 
		 */
		this.contato1.adicionaTag(1, "show");
		this.contato2.adicionaTag(1, "linda");
		this.contato3.adicionaTag(1, "bonito");
		this.contato1.adicionaTag(2, "maneiro");
		this.contato2.adicionaTag(2, "maneira");
		this.contato3.adicionaTag(2, "legal");
	}
	
	/** Testa o construtor.
	 * 
	 */
	@Test
	void testaConstrutor() {
		new Contato("Bruna","Lucena","999998888");
	}
	
	/** Testa o to string.
	 * 
	 */
	@Test 
	void testaToString() {
		assertEquals("Matheus Gaudencio" , contato1.toString());
	}
	
	/** Testa o adiciona tag.
	 * 
	 */
	@Test 
	void testaAdiocionaTag() {

		assertEquals("Adicionada em tags!",contato1.adicionaTag(1,"show"));
		assertEquals("Adicionada em tags!",contato2.adicionaTag(1,"linda"));
		assertEquals("Adicionada em tags!",contato3.adicionaTag(1,"bonito"));
		assertEquals("Adicionada em tags!",contato1.adicionaTag(2,"maneiro"));
		assertEquals("Adicionada em tags!",contato2.adicionaTag(2,"maneira"));
		assertEquals("Adicionada em tags!",contato3.adicionaTag(2,"legal"));
	}
	
	/** Testa o listar tags.
	 * 
	 */
	@Test 
	void testaListarTags() {

		assertEquals("show maneiro",contato1.listarTags());
		assertEquals("linda maneira",contato2.listarTags());
		assertEquals("bonito legal",contato3.listarTags());
		}
	
	
}