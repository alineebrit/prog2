package sistemaBiblitex;
import java.util.HashMap;
/**
 * Classe responsável por implementar o padrão ContagemLogger.
 * @author @author Aline de Brito Das Neves.
 *
 */
public class ContagemLogger implements TipoLogger{
	
	private HashMap<String, Integer>contagemDeLogger;
	
/**
 * Constrói um objeto do tipo ContagemLogger.
 */
	public ContagemLogger() {
		this.contagemDeLogger = new HashMap<>();
	}
	
/**
 * Recebe o nome do método invocado, e contabiliza no mapa de contagemDeLogger, se esse método ainda não consta no mapa, ele é colocado, e o seu valor é 1. Caso contrário, o valor desse método é incrementando em 1.
 */
	public void setNomeDoMetodo(String nomeDoMetodo) {
		if(nomeDoMetodo == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(nomeDoMetodo.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		
		if(this.contagemDeLogger.get(nomeDoMetodo) == null) {
			contagemDeLogger.put(nomeDoMetodo, 1);
		}
		else {
			contagemDeLogger.put(nomeDoMetodo, contagemDeLogger.get(nomeDoMetodo)+1);
		}
	}
	
/**
 * Método que define o valor do atributo parametro.
 */
	public void setParametro(String parametro) {
		
	}

/**
 * Retorna a string formatada que representa o método ContagemLogger.
 * @return a string saida formatada.
 */
	public String toString() {
		String saida = "";
		for(String chaves: this.contagemDeLogger.keySet()){
			saida += chaves + " - " + contagemDeLogger.get(chaves) + "\n";
		}
		
		return saida;
				
	}

/**
 * Retorna em String a representação do nome da classe implementada.
 * @return ContagemLogger, o nome da classe.
 */
	@Override
	public String getNome() {
	
		return "ContagemLogger";
	}
	
}
