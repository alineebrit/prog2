package controle;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class MainControle {


	public static void main(String[] args) {
		ControleAluno aluno = new ControleAluno();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while(true) {
			escolha = menu(scanner);
			comando(escolha, aluno, scanner);
		}
	}
		
		private static String menu(Scanner scanner) {
			System.out.println(
					"\n---\nMENU\n" + 
							"(C)adastrar Aluno\n" + 
							"(E)xibir Aluno\n" + 
							"(N)ovo Grupo\n" + 
							"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
							"(R)egistrar Aluno que Respondeu\n" +
							"(I)mprimir Alunos que Responderam\n" +
							"(O)lhaí quais Grupos o Aluno Tá.\n" + 
							"(S)im, quero Fechar o Programa!\n" + 
							"Opção> ");
			return scanner.nextLine().toUpperCase();
		}
		
		
		private static void comando(String opcao, ControleAluno aluno, Scanner scanner) {
			switch (opcao) {
			case "C":
				cadastrarAluno(aluno, scanner);
				break;
			case "E":
				consultaAluno(scanner, aluno);
				break;
			case "N":
				cadastraGrupo(aluno, scanner);
				break;
			case "A":
				alocaOuPertinenciaAGrupo(scanner, aluno);
				break;
			case "R":
				alunoQueRespondeQuestoesNoQuadro(scanner, aluno);
				break;
			case "I":
				imprimirAlunosQueRespondeQuestoesNoQuadro(aluno);
				break;
			case "O":
				checagemDosGrupos(scanner, aluno);
				break;
			case "S":
				sair();
				break;
			default:
				System.out.println("Opção inválida!");
			}
		
	}
		
		private static void cadastrarAluno(ControleAluno aluno, Scanner scanner) {
			System.out.print("\nMatrícula: ");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.print("\nNome: ");
			String nome = scanner.nextLine();
			if(nome ==null || nome.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.print("\nCurso: ");
			String curso = scanner.nextLine();
			if(curso ==null || curso.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			String mensagem = aluno.cadastrarAluno(nome, matricula, curso);
			System.out.println(mensagem);
			}
			}
			}
		}
		
		private static void consultaAluno(Scanner scanner, ControleAluno aluno) {
			System.out.println("\nMatrícula: ");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			String informacao = aluno.consultaAluno(matricula);
			System.out.println("Aluno: " + informacao);
			}
		}
		
		private static void cadastraGrupo(ControleAluno aluno, Scanner scanner) {
			System.out.println("\nGrupo: ");
			String nomeDoGrupo = scanner.nextLine();
			if(nomeDoGrupo ==null || nomeDoGrupo.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.println("\nTamanho: ");
			String tamanho = scanner.nextLine();
			String mensagem = aluno.cadastraGrupo(nomeDoGrupo, tamanho);		
			System.out.println(mensagem);
			
			}
		}
		
		private static void alocaOuPertinenciaAGrupo(Scanner scanner, ControleAluno aluno) {
			System.out.println("(A)locar Aluno ou (P)ertinência a Grupo");
			String escolha = scanner.nextLine().toUpperCase();
			switch(escolha) {
				case "A":
					alocaGrupo(scanner, aluno);
					break;
				case "P":
					pertinenciaAGrupo(scanner, aluno);
					break;
					}
			}
			
//
		private static void alocaGrupo(Scanner scanner, ControleAluno aluno) {
			System.out.println("\nMatricula: ");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.println("\nGrupo: ");
			String nomeGrupo = scanner.nextLine();
			if(nomeGrupo ==null || nomeGrupo.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			String situacao = aluno.alocaOuPertinenciaAGrupo(matricula, nomeGrupo);
			System.out.println(situacao);
			}
			}
		}
			
		private static void pertinenciaAGrupo(Scanner scanner, ControleAluno aluno) {
			System.out.println("\nGrupo: ");
			String nomeDoGrupo = scanner.nextLine();
			if(nomeDoGrupo ==null || nomeDoGrupo.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.println("\nMatricula: ");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			String condicao = aluno.pertinenciaAGrupo(nomeDoGrupo, matricula);
			System.out.println(condicao);
			}
			}
		}
		
		private static void alunoQueRespondeQuestoesNoQuadro(Scanner scanner, ControleAluno aluno) {
			System.out.println("\nMatricula: ");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			System.out.println(aluno.alunoQueRespondeQuestoesNoQuadro(matricula));
			}
		}
	
		public static void imprimirAlunosQueRespondeQuestoesNoQuadro(ControleAluno aluno) {
			System.out.println("\nAlunos:");
			System.out.println(aluno.imprimirAlunosQueRespondeQuestoesNoQuadro());
		}
		
		private static void checagemDosGrupos(Scanner scanner, ControleAluno aluno) {
			System.out.println("\nAluno:");
			String matricula = scanner.nextLine();
			if(matricula ==null || matricula.isBlank()){
				  System.out.println("Entrada inválida");
			} 
			else {
			String situacao= aluno.checagemDosGrupos(matricula);
			System.out.println(situacao);
			}		
		}
		
		private static void sair() {
			System.out.println("\nVolte sempre");
			System.exit(0);
		}
		
}