package lab2;
/**
* Classe responsavel por acompanhar o descanso do aluno, de acordo com as horas de descanso, e da quantidade de semanas.
* @author Aline de Brito das Neves.
*/
public class Descanso {

	  private int horasDeDescanso;
	  private int quantidadesDeSemana = 1;
	  private String status = "cansado";

/**
* Constroi um descanso a partir das horas de descanso, e da quantidade de semanas.
* * A quantidade de semana nunca vai ser 0. 
*/
public Descanso() {
	
	  }
/** Define horas de descanso, igual a valor.
* @param valor
*/
public void defineHorasDescanso(int valor) {
	this.horasDeDescanso = valor;
	  }
/** Define quantidades de semana, igual a valor.
* @param valor
*/
public void defineNumeroSemanas(int valor) {
	this.quantidadesDeSemana = valor;
	  }
/*** Retorna a String que representa o status geral do aluno. A representação segue o formato de cansado ou descando.
* @return a representação em String de cansado ou descansado.
*/
public String getStatusGeral() {

	int horas = horasDeDescanso / quantidadesDeSemana;
					
	if(horas < 26) {
		status = "cansado";
					}
	else {
		status = "descansado";
				}
		return this.status;
	  }
	}
