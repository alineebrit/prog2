package controle;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe responsÃ¡vel por organizar com um controle, de acordo com alunos e os grupos.
 * @author Aline de Brito das Neves.
 *
 */
public class ControleAluno {

	private HashMap<String, Aluno> mapaMatriculaAlunos = new HashMap<>();
	private HashMap<String, Grupo> mapaGrupo = new HashMap<>();
	private ArrayList<Aluno>respondeQuestoesNoQuadro = new ArrayList();


/**
 * Classe responsÃ¡vel por criar um controle de aluno e grupo.
 */
	public ControleAluno() {

	}

/**
 * Retorna em String a mensagem em relaÃ§Ã£o ao cadastro do aluno. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param nome Nome do aluno.
 * @param matricula Matricula do aluno.
 * @param curso Curso do aluno.
 * @return A string retorno em relaÃ§Ã£o ao cadastro com a mensagem se ele foi realizado ou se jÃ¡ tinha cadastrado.
 */
	public String cadastrarAluno(String nome, String matricula, String curso) {
		
		if(nome == null || matricula == null || curso==null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(nome.isBlank() || matricula.isBlank() || curso.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		
		String retorno = "";
		if(temAlunoCadastrado(matricula) == true) {
			retorno = "MATRICULA JÁ CADASTRADA!";
		}
		if (temAlunoCadastrado(matricula) == false) {
			Aluno aluno = new Aluno(nome, matricula, curso);
			mapaMatriculaAlunos.put(matricula, aluno);	
			 retorno = "CADASTRO REALIZADO!";
		}
		return retorno;
	}

/**
 * Retorna um boolean com true se matricula estiver em mapa de matricula de alunos, senÃ£o retorna false.
 * @param matricula Matricula de aluno.
 * @return Um boolean com true ou false.
 */
	private boolean temAlunoCadastrado(String matricula) {
		return this.mapaMatriculaAlunos.containsKey(matricula);
	}

/**
 * Consulta se o aluno estÃ¡ ou nÃ£o cadastrado, de acordo com a matricula em mapa de matricula de alunos, se ele nÃ£o estiver, retorna a string com a mensagem, aluno nÃ£o cadastrado. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param matricula Matricula do aluno.
 * @return A string se o aluno nÃ£o estiver cadastrado.
 */
	public String consultaAluno(String matricula) {
		
		if(matricula == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if( matricula.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		if (temAlunoCadastrado(matricula)) {
			return mapaMatriculaAlunos.get(matricula).getAluno();
		} else {
			return "Aluno não cadastrado.";
		}
	}

/**
 * Cadastra o grupo de acordo com o nome do grupo e se ele tiver o tamanho, retornando a situaÃ§Ã£o do aluno em relaÃ§Ã£o ao grupo. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param nomeDoGrupo Nome do grupo.
 * @param tamanho Tamanho do grupo.
 * @return A string em relaÃ§Ã£o a situaÃ§Ã£o do grupo, se foi cadastrado ou se jÃ¡ era cadastrado.
 */
	public String cadastraGrupo(String nomeDoGrupo, String tamanho) {
		
		if(nomeDoGrupo == null || tamanho == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(nomeDoGrupo.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		
		if(temGrupo(nomeDoGrupo)) {
			return "GRUPO JÁ CADASTRADO!";
		}
		else {
			if(tamanho.length()> 0) {
				Integer tam = Integer.parseInt(tamanho);
				mapaGrupo.put(nomeDoGrupo.toUpperCase(), new Grupo(nomeDoGrupo, tam));
				return "CADASTRO REALIZADO!";
			}
			mapaGrupo.put(nomeDoGrupo.toUpperCase(), new Grupo(nomeDoGrupo));	
			return "CADASTRO REALIZADO!";
			
		}
		
	}

/**
 * Retorna um boolean com true se o nome do grupo estiver em mapa grupo, senÃ£o retorna false.
 * @param nomeDoGrupo Nome do grupo.
 * @return Um boolean com true ou false.
 */
	private boolean temGrupo(String nomeDoGrupo) {
		return mapaGrupo.containsKey(nomeDoGrupo.toUpperCase());
	}

/**
 * Registra o aluno que respondeu questÃµes no quadro, e retorna uma string em relÃ§Ã£o se ele foi registrado ou nÃ£o. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param matricula Matricula do aluno.
 * @return Uma string se o aluno foi ou nÃ£o registrado.
 */
	public String alunoQueRespondeQuestoesNoQuadro(String matricula) {
		
		if(matricula == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(matricula.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		if(mapaMatriculaAlunos.containsKey(matricula)) {
			respondeQuestoesNoQuadro.add(mapaMatriculaAlunos.get(matricula));

			return "ALUNO REGISTRADO!";
		}
		else {
			return "Aluno não cadastrado.";
		}
	}

/**
 * Cadastra o aluno no grupo, e retorna a string em relaÃ§Ã£o a esse cadastro, de acordo com a matricula e o nome do grupo. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param matricula Matricula do aluno.
 * @param nomeGrupo Nome do grupo.
 * @return A string em relaÃ§Ã£o a situaÃ§Ã£o do aluno alocado.
 */
	public String alocaOuPertinenciaAGrupo(String matricula, String nomeGrupo) {
	
		if(matricula == null || nomeGrupo == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(matricula.isBlank() || nomeGrupo.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		
		if (!temGrupo(nomeGrupo.toUpperCase())) {
			return "Grupo não cadastrado.";
		}	
		if (!temAlunoCadastrado(matricula)){
			return "Aluno não cadastrado.";
		}
		
		if(this.mapaGrupo.get(nomeGrupo.toUpperCase()).grupoTaCheio()) {
			return "GRUPO CHEIO";
		}	
		
		if(this.mapaGrupo.get(nomeGrupo.toUpperCase()).pertenceGrupo(this.mapaMatriculaAlunos.get(matricula)) == false) {
			this.mapaGrupo.get(nomeGrupo.toUpperCase()).adicionaAluno(this.mapaMatriculaAlunos.get(matricula));
			return "ALUNO ALOCADO!";
		}
		return "ALUNO JA ALOCADO!";
	}

/**
 * Verifica a situaÃ§Ã£o de pertinÃªncia do aluno ao grupo, de acordo com o nome do grupo e a matricula. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param nomeDoGrupo Nome do grupo.
 * @param matricula Matricula do aluno.
 * @return A string em relaÃ§Ã£o a pertinÃªncia do aluno ao grupo.
 */
	public String pertinenciaAGrupo(String nomeDoGrupo, String matricula) {
		
		if( nomeDoGrupo == null || matricula == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(nomeDoGrupo.isBlank() || matricula.isBlank() ){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		if (this.temGrupo(nomeDoGrupo) == false) {
			return "GRUPO NÃO CADASTRADO.";
		}
		
		if (!this.mapaGrupo.get(nomeDoGrupo.toUpperCase()).pertenceGrupo(this.mapaMatriculaAlunos.get(matricula))) {
			return "ALUNO NÃO PERTENCE AO GRUPO.";
			
		}
		return "ALUNO PERTENCE AO GRUPO";
	}
	
/**
 * Retorna em string os alunos que responderam as questÃµes no quadro.
 * @return a representaÃ§Ã£o dos alunos que responderam as questÃµes no quadro.
 */
	public String imprimirAlunosQueRespondeQuestoesNoQuadro() {
		String questoesNoQuadro = "";
		for (int i = 0; i <this.respondeQuestoesNoQuadro.size(); i++) {
			questoesNoQuadro += (i + 1)+ ". " + this.respondeQuestoesNoQuadro.get(i).getAluno() + "\n";
		}
		return questoesNoQuadro;
	}

/**
 * Faz a checagem dos grupos de acordo com a matricula do aluno em mapa grupo e retorna a lista de grupo que o aluno estar. PorÃ©m, se os mÃ©todos forem invÃ¡lidos, Ã© retornada uma exceÃ§Ã£o.
 * @param matricula Matricula do aluno.
 * @return A lista de grupo que aluno tÃ¡.
 */
	public String checagemDosGrupos(String matricula) {
		
		if(matricula == null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(matricula.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		
		String listaDeGrupo = "";
		for (Grupo grupo : this.mapaGrupo.values()) {
			if (grupo.pertenceGrupo(mapaMatriculaAlunos.get(matricula))) { 
				listaDeGrupo += grupo.getNome() + "\n";
			}
		}
		return listaDeGrupo;

	}
}
