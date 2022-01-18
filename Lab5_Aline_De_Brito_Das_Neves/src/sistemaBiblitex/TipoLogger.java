package sistemaBiblitex;
/**
 * Interface que é implementada por diversas classes que representam o TipoLogger.
 * @author Aline de Brito Das Neves.
 *
 */
public interface TipoLogger {
/**
 * Método que define o valor do atributo nomeDoMetodo.
 * @param nomeDoMetodo, Nome do método.
 */
	public void setNomeDoMetodo(String nomeDoMetodo);
	
/**
 * Método que define o valor do atributo parametro.
 * @param parametro, Parametro.
 */
	public void setParametro(String parametro); 
	
/**
 * Retorna a string formatada que representa o método.
 * @return a string formatada.
 */
	public String toString();
	
/**
 * Retorna em String a representação do nome da classe implementada.
 * @return o nome da classe.
 */
	public String getNome();
}
