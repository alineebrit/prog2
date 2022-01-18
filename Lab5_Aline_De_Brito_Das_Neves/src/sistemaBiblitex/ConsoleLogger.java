package sistemaBiblitex;
/**
 * Classe responsável por implementar o padrão ConsoleLogger.
 * @author Aline de Brito Das Neves.
 *
 */
public class ConsoleLogger implements TipoLogger{
	
	private String nomeDoMetodo;
	private String parametro;
	
/**
 * Constrói um objeto do tipo ConsoleLogger.
 */
	public ConsoleLogger() {
		
		}

	
/**
 * Método que define o valor do atributo nomeDoMetodo.
 * @param nomeDoMetodo, Nome do método.
 */
	public void setNomeDoMetodo(String nomeDoMetodo) {
		if(nomeDoMetodo == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(nomeDoMetodo.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		
		this.nomeDoMetodo = nomeDoMetodo;	
	}
	
/**
 * Método que define o valor do atributo parametro.
 * @param parametro, Parametro.
 */
	public void setParametro(String parametro) {
		if(parametro == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		this.parametro = parametro;
	}

/**
 * Retorna a string formatada que representa o método ConsoleLogger.
 * @return a string formatada de ConsoleLogger.
 */
	public String toString() {
		return "["+ nomeDoMetodo + "] "+ parametro;
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 * @return ConsoleLogger, o nome da classe.
 */
	@Override
	public String getNome() {
		
		return "ConsoleLogger";
	}
}

