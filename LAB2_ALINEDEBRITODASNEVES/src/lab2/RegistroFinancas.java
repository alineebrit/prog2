package lab2;
/**
* Classe responsavel pelo registros de finanças, calculando o total de ganhos, as despesas e o total disponivel.
* @author Aline de Brito das Neves.
*/
public class RegistroFinancas {
	

    private int[] todasEntradas;
    
    private int valorInicial;
    private int todasDespesas;
    private int totalGanhos;
/**
* 
* Constroi um registro de finanças, a partir de um valor inicial e quantidade de ganhos.
* @param valorInicial
* @param quantidadeGanhos
*/
public RegistroFinancas(int valorInicial, int quantidadeGanhos) {

	this.valorInicial = valorInicial;
    this.todasEntradas = new int[quantidadeGanhos];

    }
/**Pega os valores que estão no array e adiciona em calcula total de ganhos.
* @param valorCentavos
* @param posicaoGanho
*/
public void adicionaGanhos(int valorCentavos, int posicaoGanho) {

	this.todasEntradas[posicaoGanho - 1] = valorCentavos;
    this.totalGanhos = calculaTotalGanhos();

    }
/**
* Faz um somatorio na variavel.
* @return a soma dos ganhos.
*/
public int calculaTotalGanhos(){
	int soma = 0;
    for (int i = 0; i < this.todasEntradas.length; i++) {
            soma += this.todasEntradas[i];
        }
    return soma;
    }
/** Percorre o array e retorna todos as entradas de exibe ganhos.
* @return a exibicao de ganhos.
* */
public String exibeGanhos() {
	String exibicaoGanho = "";
    for (int i = 0; i < this.todasEntradas.length - 1; i++) {
    	exibicaoGanho += i + 1 + " - " + this.todasEntradas[i] + "\n";
            } 
        exibicaoGanho += this.todasEntradas.length + " - " + this.todasEntradas[this.todasEntradas.length - 1];
        return exibicaoGanho;
    }
/**
* Define paga despesa, e adiciona todas despesas a valor centavos.
* @param valorCentavos
*/
public void pagaDespesa(int valorCentavos) {
	this.todasDespesas += valorCentavos;
    }
/** Retorna a String que representa o registro de financas. A representacao segue o formato de total recebidos, despesas totais e o total disponivel.
* @return a representação em String do registro  de finanças.
*/
public String toString() {
	return "Total recebidos: " + (this.valorInicial + this.totalGanhos)
                + ", Despesas totais: " + this.todasDespesas
                + ", Total disponível: " +
                ((this.valorInicial + this.totalGanhos) - this.todasDespesas);
    }
}

