package sistemaBiblitex;
/**
 * Interface que é implementada por diversas classes que representam algoritmos de transformações.
 * @author Aline de Brito Das Neves.
 *
 */
public interface AlgoritmoTransformacao {

/**
 * Esse método recebe uma String original, e de acordo com a classe que é implementada, realiza uma transformação e retorna essa string transformada.
 * @param original, a frase original.
 * @return Transformada, a string transformada.
 */
	public String transforma(String original);
	
/**
 * Esse método retorna em String a representação do nome da classe implementada.
 * @return o nome da classe.
 */
	public String getNome();
	
/**
 * Esse método retorna em String a representação da frase original.
 * @return Original, a frase original.
 */
	public String getOriginal();
	
/**
 * Esse método retorna em String a representação da frase transformada.
 * @return Transformada, a frase transformada.
 */
	public String getTransformada();
}
