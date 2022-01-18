package agenda;

/**
 * Classe responsável por organizar o contato, de acordo com o nome, sobrenome, telefone, tag e favoritos. Nele pode existir até 5 tags.
 * @author Aline de Brito das Neves
 *
 */
public class Contato {
	private String nome;
	private String sobrenome;
	private String telefone;
	private String[] tags;
	
	private static final int NUMERO_DE_TAGS = 5;
	private int contadorDeTags;
	
	/**
	 * Constrói um contato a partir do nome, sobrenome e telefone.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new String[NUMERO_DE_TAGS];
		this.contadorDeTags = 0;
	}
	
	/** Retorna a String que representa o nome no contato.
	 * 
	 * @return A representação em String do nome.
	 */
	public String getNome(){
		return nome;
	}
	
	/** Retorna a String que representa o sobrenome no contato.
	 * 
	 * @return A representação em String do sobrenome.
	 */
	public String getSobrenome(){
		return sobrenome;
	}
	
	/** Retorna a String que representa o telefone no contato.
	 * 
	 * @return A representação em String do telefone.
	 */
	public String getTelefone(){
		return telefone;
	}
	
	/** Retorna a String em concatenação do nome, mais um espaço e o sobrenome.
	 * 
	 * @return A String do nome com o sobrenome.
	 */
	public String toString() {
		return nome + " " + sobrenome;
	}
	
	/** Retorna a String "Adicionada em tags!", caso a tag seja adicionada, e se posicao de tag for de 1 até 5.
	 *  
	 * @param posicaoEmTags Posicao em tags do contato.
	 * @param tag String Tag do contato.
	 * @return A representação da String se ela for adicionada em tags.
	 */
	public String adicionaTag(int posicaoEmTags, String tag) {
		if(posicaoEmTags >= 1 && posicaoEmTags <= 5) {
			tags[posicaoEmTags - 1] = tag;
			this.contadorDeTags += 1;
			return "Adicionada em tags!";
		}
		return null;
	}
	
	/** Retorna a String que representa as tags no contato.
	 * 
	 * @return A String que representa as tags.
	 */
	public String[] getTags() {
		return tags;
	}
	
	/** O for vai percorrer o array, se a tag for diferente de null, vai ser adicionada a tag formatada, mais a concatenação de um espaço, porém na última tag, o espaço não estará presente.
	 * 
	 * @return A String que representa as tags formatadas.
	 */
	public String listarTags() {
		String tagsFormatadas = "";
		for(int i = 0; i < 5; i++) {
			if (tags[i] != null) {
					tagsFormatadas += tags[i] + " ";
				
			
			}
		}	
		return tagsFormatadas.trim();
		}
}