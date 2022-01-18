package sistemaBiblitex;
/**
 * Classe responsável por implementar o padrão Camelcase.
 * @author Aline de Brito Das Neves.
 *
 */
public class CaMeLcAsE implements AlgoritmoTransformacao{

	private String original;
	private String transformada;

/**
 * Classe responsável por construir o método CaMeLcAsE.
 */
	public CaMeLcAsE() {
		
	}

/**
 * Retorna a string que representa a transformação com CaMeLcAsE. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @return Transformada, a string transformada.
 */
	@Override
	public String transforma(String original) {
		if(original == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(original.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		this.original = original;
		String[] lista = original.split("");
		int contador = 0;
		this.transformada = "";
		while(true) {
			if(contador == lista.length) {
				break;
			}
			if(contador%2!=0) {
				transformada += lista[contador].toLowerCase();
			}
			else {
				transformada += lista[contador].toUpperCase();
			}
			contador += 1;
		}
		this.transformada = transformada;
		return transformada;
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 * @return CaMeLcAsE, o nome da classe.
 */
	@Override
	public String getNome() {
		
		return "CaMeLcAsE";
	}

/**
 * Retorna em String a representação da frase original.
 * @retunr Original, a frase original.
 */
	@Override
	public String getOriginal() {
	
		return this.original;
	}
	
/**
 * Retorna em String a representação da frase transformada.
 * @retunr Transformada, a frase transformada.
 */
	@Override
	public String getTransformada() {
		
		return this.transformada;
	}
	
}
