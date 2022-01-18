package agenda;
/** A agenda que contém uma lista com contatos de posições. Nela pode existir 100 contatos e entre eles, 10 favoritos.
 * 
 * @author Aline de Brito das Neves
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_AGENDA_FAVORITOS = 10;
	
	private Contato[] contatos;
	private Contato[] favoritos;
	
	/** Classe responsável por criar uma agenda.
	 * 
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_AGENDA_FAVORITOS];
	}
	
	/** Retorna null se a posição for inválida e quando a pessoa já existe na lista de favoritos, e quando o contato é favoritado, retorna a mensagem "CONTATO FAVORITADO NA POSIÇÃO", mais a posição em que o contato está favoritado.
	 * 
	 * @param posicaoDeFavoritos Posição do favorito na agenda.
	 * @param posicaoDeContatos Posição do contato na agenda.
	 * @return a String contato favoritado na posição, caso ela atenda os requisitos.
	 */
	public String adicionarFavoritos(int posicaoDeFavoritos, int posicaoDeContatos) {
		if (ehPosicaoValida(posicaoDeContatos) && contatos[posicaoDeContatos - 1] != null ) {
			Contato contato = contatos[posicaoDeContatos - 1];
			if(posicaoDeFavoritos >= 1 && posicaoDeFavoritos <= 10) {
				for(int i = 0; i < favoritos.length; i++) {
					if(favoritos[i] != null && favoritos[i].getNome().equals(contato.getNome()) && favoritos[i].getSobrenome().equals(contato.getSobrenome())) {
						return null; 
						
					}
					
				}
				favoritos[posicaoDeFavoritos - 1] = contato;
				return "CONTATO FAVORITADO NA POSIÇÃO" + " " + posicaoDeContatos + "!";
			}
		}
		return null;
	}
	
	/** Retorna em String os contatos que está em favoritos.
	 * 
	 * @return Os contatos de favoritos.
	 */
	public String listarFavoritos() {
		String saida = "";
		for (int i = 0; i < TAMANHO_AGENDA_FAVORITOS; i++) {
			if (favoritos[i] != null) {
				String contato = (i+1) + " - " + favoritos[i].toString();
				saida += contato + "\n";
			}
		}
		return saida.trim();
	}
		
	
	/** Acessa a lista de contatos mantida.
	 * 
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/** Retorna os dados de um contato em particular.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não tiver contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	/** Retorna uma String de um contato em particular favoritado com a tag.
	 * 
	 * @param posicao Posição do contato na agenda.
	 * @return a String Completa de um contato favoritado e a tag na agenda. Null se nao tiver contato na posição.
	 */
	public String exibirContato(int posicao) {
		if (ehPosicaoValida(posicao) && contatos[posicao - 1] != null) {
			Contato contato = getContato(posicao - 1);
			String favorito = "";
			if(temEmFavoritos(contato)) {
				favorito = "❤️ "; 
			}
			return favorito + contato.toString() + "\n" + contato.getTelefone() + "\n" + contato.listarTags();
		}
		return null;
	}
	
	/** Retorna um boolean, se o contato está ou não em favoritos.
	 * 
	 * @param contato Contato de agenda.
	 * @return Um boolean com false ou true.
	 */
	public boolean temEmFavoritos(Contato contato) {
		for (int i = 0; i < TAMANHO_AGENDA_FAVORITOS; i++) {
			if (favoritos[i] != null && favoritos[i].getNome().equals(contato.getNome()) && favoritos[i].getSobrenome().equals(contato.getSobrenome())) {
				return true;
			}
		}
		return false;
	}
	
	/** Retorna uma String contendo os contato que estão em agenda.
	 * 
	 * @return Os contatos de agenda.
	 */
	public String listarContatos() {
		String lista = "";
		for (int i = 0; i < TAMANHO_AGENDA; i++) {
			if (contatos[i] != null) {
				String contato = (i+1) + " - " + contatos[i].toString();
				System.out.println(contato);
				lista += contato + "\n";
			}
		}
		return lista.trim();
	}
	
	/** Adiciona a tag no contato.
	 * 
	 * @param posicaoDeContato Posição de contato na Agenda.
	 * @param tag Tag que é para ser adicionada.
	 * @param posicaoDeTag Posição de tag na agenda.
	 */
	public void adicionaTag(int posicaoDeContato, String tag, int posicaoDeTag) {
		contatos[posicaoDeContato - 1].adicionaTag(posicaoDeTag, tag);
		
	}
			
	private boolean ehPosicaoValida(int posicao) {
		return posicao >= 1 && posicao <= 100;
	}
	
	/** Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (telefone == null || telefone.trim() == "" ) {
			return "CONTATO INVALIDO";
		}
		if (nome == null || nome.trim() == "") {
			return "CONTATO INVALIDO";
		}
		if (ehPosicaoValida(posicao)) {
			Contato contato = new Contato(nome, sobrenome, telefone);
			for (int i = 0; i < TAMANHO_AGENDA; i++) {
				if(contatos[i] != null && nome.equals(contatos[i].getNome()) && sobrenome.equals(contatos[i].getSobrenome())) {
					return "CONTATO JA CADASTRADO";
				}
		
			}
			
			contatos[posicao - 1] = contato;
			return "CADASTRO COM SUCESSO";
			
		}
		return "POSIÇÃO INVÁLIDA";	
	}
	
	
}