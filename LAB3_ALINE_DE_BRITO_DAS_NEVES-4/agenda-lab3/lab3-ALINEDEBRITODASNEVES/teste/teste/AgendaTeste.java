package teste;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import agenda.Agenda;
import agenda.Contato;

public class AgendaTeste {

	private Agenda agenda;

	@BeforeEach
	void preparaAgenda() {
		
		/** Prepara inicialmente contatos para ser testados.
		 * 
		 */
		this.agenda = new Agenda();
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio","98788-8979");
		this.agenda.cadastraContato(2, "Livia", "Sampaio","9999-0001");
		this.agenda.cadastraContato(3, "Nazareno", "Jesus","9999-1001");
		
		/** Prepara os favoritos
		 * 
		 */
		this.agenda.adicionarFavoritos(1,1);
		this.agenda.adicionarFavoritos(2,2);
		this.agenda.adicionarFavoritos(3,3);
		
		
	}
	
	/** Testa o adicionar favoritos em agenda.
	 * 
	 */
	@Test 
	void testaAdicionarFavoritos() {
		agenda.cadastraContato(6, "Maria", "Dores", "98856-5696");
		assertEquals(null, agenda.adicionarFavoritos(1,1));
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 6!", agenda.adicionarFavoritos(6, 6));
		assertEquals(null, agenda.adicionarFavoritos(12,12));
		
	}

	/** Testa o listar favoritos em agenda.
	 * 
	 */
	@Test 
	void testaListarFavoritos() {
			
		assertEquals("1 - Matheus Gaudencio\n2 - Livia Sampaio\n3 - Nazareno Jesus", agenda.listarFavoritos());
		
	}
	
	/** Testa o exibir contatos em agenda.
	 * 
	 */
	@Test 
	void testaExibirContato() {
		agenda.adicionaTag(3,"bonito",3); 
		assertEquals("❤️ Nazareno Jesus\n9999-1001\nbonito", agenda.exibirContato(3));
		
	}
	
	/** Teste se tem favoritos na agenda.
	 * 
	 */
	@Test 
	void testaTemEmFavoritos() {
		Contato contato1 = new Contato("Matheus", "Gaudencio","98788-8979");
		Contato contato2 = new Contato("Amanda", "Farias", null);
			
		assertEquals(true , agenda.temEmFavoritos(contato1));
		assertEquals(false , agenda.temEmFavoritos(contato2));
	}
		
	/** Testa o listar contatos em agenda.
	 * 
	 */
	@Test 
	void testaListarContatos() {
			
		assertEquals("1 - Matheus Gaudencio\n2 - Livia Sampaio\n3 - Nazareno Jesus", agenda.listarContatos());
			
	}
		
	/** Testa o adiciona tag na agenda.
	 * 	
	 */
	@Test 
	void testaAdicionaTag() {
		agenda.cadastraContato(4,"Aline", "Brito", "99600-0281");
		agenda.adicionaTag(4, "fofa", 4);
			
		assertEquals("Aline Brito\n99600-0281\nfofa" , agenda.exibirContato(4));
	}
			
	/** Testa se cadastra o contato na agenda.
	 * 	
	 */
	@Test 
	void testaCadastraContato() {
			
		assertEquals("CONTATO INVALIDO",agenda.cadastraContato(10, "Matheus", "Gaudencio", ""));
		assertEquals("CONTATO INVALIDO", agenda.cadastraContato(11, "", "Sampaio", "9999-0001"));
		assertEquals("CONTATO JA CADASTRADO", agenda.cadastraContato(1, "Matheus", "Gaudencio","98788-8979"));
		assertEquals("CADASTRO COM SUCESSO", agenda.cadastraContato(4, "Aline", "Brito", "996000281"));
		assertEquals("POSIÇÃO INVÁLIDA", agenda.cadastraContato(102, "Rebecca", "Sousa", "899999999"));
	}


}
