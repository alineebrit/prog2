package agenda;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/** Interface com menus texto para manipular uma agenda de contatos.
 *
 * @author Aline de Brito das Neves
 *
 */
public class MainAgenda {
	static final String MENSAGEM_POSICAO_INVALIDA = "POSIÇÃO INVÁLIDA!";
	
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/** Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/** Interpreta a opção escolhida por quem está usando o sistema.
	 *  
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listarFavoritos(agenda);
			break;
		case "A":
			adicionaFavoritos(agenda, scanner);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato(s)> ");
		Scanner posicoesDeContatos = new Scanner(System.in);
		String[] posicoes = posicoesDeContatos.nextLine().split(" ");
		
		System.out.print("\nTag> ");
		Scanner tagScanner = new Scanner(System.in);
		String tag = tagScanner.next();
		
		System.out.print("\nPosicao tag> ");
		int posicaoTag = scanner.nextInt();
		
		for(int i = 0; i < posicoes.length; i++) {
		      int posicao = Integer.parseInt(posicoes[i]);
		      agenda.adicionaTag(posicao, tag, posicaoTag);
		}
			
	}

	private static void adicionaFavoritos(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posicaoContatos = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicaoFavoritos = scanner.nextInt();
		String saida = agenda.adicionarFavoritos(posicaoFavoritos, posicaoContatos);
		if(saida != null) {
			System.out.println(saida);
		}
	}
	
	private static void listarFavoritos(Agenda agenda) {
		System.out.println("\nFavoritos: ");
		System.out.println(agenda.listarFavoritos());
	
	}
	
	/** Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		agenda.listarContatos();
	}

	/** Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		String informacoesDoContato = agenda.exibirContato(posicao);
		if (informacoesDoContato != null) {
			System.out.println(informacoesDoContato);
		}
		else {
			System.out.println(MENSAGEM_POSICAO_INVALIDA);
		}
	}

	/** Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exibida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato.toString();
	}

	/** Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.next();
		System.out.print("\nTelefone> ");
		String telefone = scanner.next();
		String mensagem = agenda.cadastraContato(posicao, nome, sobrenome, telefone);
		System.out.println(mensagem);
	}

	/** Sai da aplicação.
	 * 
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/** Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}