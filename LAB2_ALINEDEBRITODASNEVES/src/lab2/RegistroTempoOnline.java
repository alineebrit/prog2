package lab2;
/**
* Classe responsavel por determinar o tempo que o aluno passa estudando em determinada disciplina, e se ele esta se dedicando conforme o esperado.
* @author Aline de Brito das Neves.
*/
public class RegistroTempoOnline {

	private String nomeDisciplina;
	private int tempoOnlineEsperado;
	private int registroTempoOnline;

/** Constroi um registro de tempo online, a partir do tempo online, e do tempo esperado.
* Por padrão considera-se que a disciplina comeca com 60 horas, e o tempo esperado de dedicacao eh 120.
* @param nomeDisci
* @param horas
*/
public RegistroTempoOnline(String nomeDisci, int horas) {
	this.nomeDisciplina = nomeDisci; 
    this.tempoOnlineEsperado = horas;
  }
/** Adiciona o tempo online ao tempo.
* @param tempo
*/
public void adicionaTempoOnline(int tempo){
	this.registroTempoOnline += tempo;
  }
/** Defini o nome da disciplina.
* Tempo online esperado eh definido como 0.
* Tempo online esperado eh definido como padrao em 120.
* @param nomeDisci
*/
public RegistroTempoOnline(String nomeDisci){
	this.nomeDisciplina = nomeDisci;
    this.tempoOnlineEsperado = 0;
    this.tempoOnlineEsperado = 120;
  }
/** Retorna um boolean, se resgistro de tempo online for maior ou igual ao tempo oonline esperado.
* @return false ou true.
*/
public boolean atingiuMetaTempoOnline() {
	return (registroTempoOnline >= tempoOnlineEsperado);

}
/**Retorna o tempo online. A representaçao segue o formato disciplina, 
* registro de tempo online e o registro de tempo esperado.
* @return a representaçao de registro de tempo online
*/
public String toString() {
	return this. nomeDisciplina +" "+ this.registroTempoOnline + "/" + this.tempoOnlineEsperado;
  }
}