package lab2;
/**
* Classe responsavel por calcular a media da disciplina, mostra as notas, e se o aluno foi aprovado.
* @author Aline de Brito das Neves.
*/
public class Disciplina {

	private String nomeDisciplina;
	private int quantidadeDeHoras;
	private double notas[] = {0,0,0,0};

/**
 * /**
* Constroi a disciplina, a partir do nome da disciplina.
* @param nomeDisciplina
*/
public Disciplina(String nomeDisciplina) {
    this.nomeDisciplina = nomeDisciplina;
}
/*** Cadastra a quantidade de horas a partir de horas.
* @param horas
*/
public void cadastraHoras (int horas) {
	quantidadeDeHoras += horas;
			
}
/**
* Retorna um double a partir do calculo da media de notas.
* @return a media das notas.
*/
private double calculaMediaDasNotas() {
  double mediaDasNotas = 0;
	for(int i = 0; i<notas.length; i++) {
		mediaDasNotas += notas[i];
	}
	  return mediaDasNotas /= 4;
}
/**
* Percorre o array, e cadastra as notas.
*/
public void cadastraNota(int nota, double valorNota) {
  notas[nota - 1] = valorNota;
}
/**
* Retorna um boolean se a media do aluno for maior ou igual a 7.
* @return true ou false, se o aluno for aprovado.
*/
public boolean aprovado() {
  return calculaMediaDasNotas() >= 7.0;
}
/**
* Retorna a String que representa a disciplina . A representação segue o formato, nome de disciplina, quantidade de horas, media das notas e cada nota.
* @return a representação em String da disciplina.
*/
public String toString() {
  return this.nomeDisciplina + " " + this.quantidadeDeHoras + " " + calculaMediaDasNotas() +"[ " + this.notas[0] + ", " + this.notas[1] + ", " + this.notas[2] + ", " + this.notas[3] + "]";
  }
}

