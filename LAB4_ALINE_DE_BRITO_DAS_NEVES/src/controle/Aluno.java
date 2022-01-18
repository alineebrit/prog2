package controle;
import java.util.ArrayList;
/**
 * Classe responsável por organizar o aluno, de acordo com o nome, matricula e o curso.
 * @author Aline de Brito das Neves.
 *
 */
public class Aluno {

	

private String nome;
private String matricula;
private String curso;
private ArrayList <Grupo> grupos;

/**
 * Constrói um aluno, a partir de nome, matricula e curso. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @param nome Nome do aluno.
 * @param matricula Matricula do aluno.
 * @param curso Curso do aluno.
 */
	public Aluno(String nome, String matricula, String curso) {
		
		if(nome == null || matricula == null || curso==null){
			   throw new NullPointerException("Entrada inválida");
		}

		if(nome.isBlank() || matricula.isBlank() || curso.isBlank()){
			  throw new IllegalArgumentException("Entrada inválida");
		}
		
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.grupos = new ArrayList<>();
		
	}
/**
 * Retorna a String que representa os dados do um aluno.
 * @return Os dados do aluno.
 */
	public String getAluno() {
		return matricula + " "+ "-"+ " "+ nome +" "+ "-" + " " + curso;
	}
	
/**
 * Adiciona o nome do grupo, ao grupo.
 * @param grupo Grupo.
 */
	public void adicionaNomeDeGrupo(Grupo grupo) {
		this.grupos.add(grupo);
	}

/**
 * Retorna a String que representa os nomes dos grupos.
 * @return Nome do grupo;
 */
	public ArrayList<Grupo> getGrupos() {
		return this.grupos;
	}

	public String getMatricula() {
		return this.matricula;
	}
}

