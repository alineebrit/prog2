package controle;
import java.util.ArrayList;
/**
 * Classe responsável por organizar o grupo, de acordo com o nome do grupo e o tamanho do grupo, que pode ter ou não.
 * @author Aline de Brito das Neves.
 *
 */
public class Grupo {

private String nomeDoGrupo;
private int tamanho = -1;
private ArrayList<Aluno>alunosDoGrupo;
private boolean temTamanho = false;

/**
 * Constrói um grupo, a partir do nome do grupo e o tamanho do grupo. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @param nome Nome do grupo.
 * @param tamanho Tamanho do grupo.
 */
	public Grupo(String nome, int tamanho) {
		
		if(nome == null){
			throw new NullPointerException("Entrada inválida");
		}

		if(nome.isBlank()){
			 throw new IllegalArgumentException("Entrada inválida");
		}
		this.nomeDoGrupo = nome;
		this.tamanho = tamanho;
		this.alunosDoGrupo = new ArrayList();
		this.temTamanho = true;
	}
/**
 * Constrói um grupo, a partir do nome do grupo, caso não tiver tamanho. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @param nome Nome do grupo.
 */
	public Grupo(String nome) {
		
		if(nome == null){
			throw new NullPointerException("Entrada inválida");
		}

		if(nome.isBlank()){
			 throw new IllegalArgumentException("Entrada inválida");
		}
		
		this.nomeDoGrupo = nome;
		this.alunosDoGrupo = new ArrayList();
	}
	
/**
 * Retorna um boolean com true ou false, caso o grupo esteja cheio.
 * @return Um boolean com false ou true.
 */
	public boolean grupoTaCheio() {
		if(this.tamanho > -1) {
			if(this.tamanho == this.alunosDoGrupo.size()) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

/**
 * Retorna um boolean com true se alunos do grupo pertencer ao grupo ou false se ele não pertencer.
 * @param aluno Aluno.
 * @return Um boolean com true ou false.
 */
	public boolean pertenceGrupo(Aluno aluno) {
		return this.alunosDoGrupo.contains(aluno);
	}

/**
 * Retorna uma string caso o grupo esteja cheio ou se o aluno for cadastrado.
 * @param aluno Aluno.
 * @return A string com a mensagem de grupo cheio ou aluno cadastrado.
 */
	public String adicionaAluno(Aluno aluno) {
		if (this.tamanho == this.alunosDoGrupo.size()) {
			return "GRUPO CHEIO";
		}
		this.alunosDoGrupo.add(aluno);
		return "CADASTRADO";
	}

/**
 * Retorna a String que representa o nome do grupo.
 * @return Nome do grupo.
 */
	public String getNome() {
		return this.nomeDoGrupo;
	}
	
}
