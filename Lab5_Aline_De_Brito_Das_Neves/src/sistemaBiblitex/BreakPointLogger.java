package sistemaBiblitex;
/**
 * Classe responsável por implementar o padrão BreakPointLogger.
 * @author Aline de Brito Das Neves.
 *
 */
public class BreakPointLogger implements TipoLogger{
	
	private String nomeDoMetodo;
	private int contador = 0;
	
/**
 * Constrói um objeto do tipo BreakPointLogger.
 * @param nomeDoMetodo Nome do método.
 */
	public BreakPointLogger(String nomeDoMetodo) {
		if(nomeDoMetodo == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(nomeDoMetodo.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		
		this.nomeDoMetodo = nomeDoMetodo;
	}
	
/**
 * Método que opera como um contador de nomeDoMetodo.
 */
	public void setNomeDoMetodo(String nomeDoMetodo) {
		if(nomeDoMetodo == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(nomeDoMetodo.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		if(this.nomeDoMetodo.equals(nomeDoMetodo)) {
			contador += 1;
		}
	}
	
/**
 * Método que define o valor do atributo parametro.
 */
	public void setParametro(String parametro) {
		
	}
	
/**
 * Retorna a string formatada que representa o método BreakPointLogger.
 * @return a string formatada de BreakPointLogger.
 */
	public String toString() {
	
		return "[" + "INVOCADO - " + nomeDoMetodo + "]" + "\n" + contador;
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 * @return BreakPointLogger, o nome da classe.
 */
	@Override
	public String getNome() {
		
		return "BreakPointLogger";
	}
}