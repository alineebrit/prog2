package sistemaBiblitex;

/**
 *  Classe responsável por implementar o padrão EspalhandoAmor.
 * @author Aline de Brito Das Neves.
 *
 */
public class EspalhandoAmor implements AlgoritmoTransformacao{

	private String original;
	private String transformada;

/**
 * Classe responsável por construir o método EspalhandoAmor.
 */
	public EspalhandoAmor() {
		
	}
	
/**
 * Retorna a string que representa a transformação com EspalhandoAmor. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @return Transformada, a classe transformada.
 */
	@Override
	public String transforma(String original) {
		if(original == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(original.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		this.original= original;
		String transformada = original.replaceAll("\\s+","<3");
		this.transformada = transformada;
		return transformada;
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 *@return EspalhandoAmor, o nome da classe.
 */
	@Override
	public String getNome() {
	
		return "EspalhandoAmor";
	}
	
/**
 * Retorna em String a representação da frase original.
 * @return Original, a frase original.
 */
	@Override
	public String getOriginal() {
	
		return this.original;
	}
	
/**
 * Retorna em String a representação da frase transformada.
 * @return Transformada, a frase transformada.
 */
	@Override
	public String getTransformada() {
		
		return this.transformada;
	}
	
}
