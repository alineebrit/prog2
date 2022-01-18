package sistemaBiblitex;
/**
 * Classe responsável por implementar o padrão TimeConsoleLogger.
 * @author Aline de Brito Das Neves.
 *
 */
public class TimeConsoleLogger implements TipoLogger {
	
	private String nomeDoMetodo;
	private double tempo;
	private String parametro;
	
/**
 * Constrói um objeto do tipo TimeConsoleLogger.
 */
	public TimeConsoleLogger() {
		
	}

/**
 * Método que define o valor do atributo nomeDoMetodo, e do tempo.
 */
	public void setNomeDoMetodo(String nomeDoMetodo) {
		this.nomeDoMetodo = nomeDoMetodo;
		this.tempo = System.currentTimeMillis();
	}
	
/**
 * Método que define o valor do atributo parametro.
 * @param parametro, Parametro.
 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
/**
 * Retorna a string formatada que representa o método TimeConsoleLogger.
 * @return a string formatada de TimeConsoleLogger.
 */
	public String toString() {
		return "[ " + nomeDoMetodo + " - " + tempo + "ms]" + " " + parametro;
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 * @return ConsoleLogger, o nome da classe.
 */
	@Override
	public String getNome() {
		
		return "TimeConsoleLogger";
	}
}


