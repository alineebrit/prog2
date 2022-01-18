package sistemaBiblitex;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Classe responsável por implementar o padrão TransformaTexto.
 * @author Aline de Brito Das Neves.
 *
 */
public class TransformaTexto{

	private HashMap<String, AlgoritmoTransformacao>tiposDeTransformacoes;
	private int contador = 0;
	private TipoLogger logger;
	private ArrayList<String>historico;
	
/**
 * Classe responsável por construir o método TransformaTexto.
 */
	public TransformaTexto() {
		this.tiposDeTransformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.tiposDeTransformacoes.put("CaMeLcAsE", new CaMeLcAsE());
		this.tiposDeTransformacoes.put("Clean", new Clean());
		this.tiposDeTransformacoes.put("CleanSpace", new CleanSpace());
		this.tiposDeTransformacoes.put("EspalhandoAmor", new EspalhandoAmor());
		this.tiposDeTransformacoes.put("InterrogaParaPonto", new InterrogaParaPonto());
		this.tiposDeTransformacoes.put("UpperCase", new UpperCase());
	
	}
	
/**
 * Classe responsável por construir o método TransformaTexto, de acordo com o TipoLogger.
 * @param logger Logger.
 */
	public TransformaTexto(TipoLogger logger) {
		this.tiposDeTransformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.logger = logger;
		this.tiposDeTransformacoes.put("CaMeLcAsE", new CaMeLcAsE());
		this.tiposDeTransformacoes.put("Clean", new Clean());
		this.tiposDeTransformacoes.put("CleanSpace", new CleanSpace());
		this.tiposDeTransformacoes.put("EspalhandoAmor", new EspalhandoAmor());
		this.tiposDeTransformacoes.put("InterrogaParaPonto", new InterrogaParaPonto());
		this.tiposDeTransformacoes.put("UpperCase", new UpperCase());
	
	}

/**
 * Retorna a string que representa a transformação. Se o Logger existir, e ele for ConsoleLogger ou TimeConsoleLogger, o toString dele é concatenado. Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @param tipo Tipo de Logger.
 * @param mensagem Mensagem.
 * @return saida no padrão Logger.
 */
	public String transforma(String tipo, String mensagem) {
		if(tipo == null || mensagem == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(tipo.isBlank() || mensagem.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		contador ++;
		AlgoritmoTransformacao t = this.tiposDeTransformacoes.get(tipo);
		t.transforma(mensagem);
		String historico = "";
		historico += t.getOriginal() + "-> " + tipo + "-> " + t.getTransformada();
		this.historico.add(historico);
		String saida = "";
		if(logger != null) {
			
			logger.setNomeDoMetodo("transforma");
			logger.setParametro(tipo);
			
			if(logger.getNome().equals("ConsoleLogger")||logger.getNome().equals("TimeConsoleLogger")) {
				saida += logger.toString() + "\n";
				
			}
		
		}
			saida += t.getTransformada();
			return saida;
	}
	
/**
 * Retorna a string que representa o cadastro das transformações do tipo Logger.Porém, se os métodos forem inválidos, é retornada uma exceção.
 * @param tipo Tipo de Logger.
 * @param algoritmo Algoritmo de transformação.
 * @return a saida de acordo com o padrão Logger.
 */
	public String cadastraTransformacao(String tipo, AlgoritmoTransformacao algoritmo) {
		if(tipo == null || algoritmo == null) {
			throw new NullPointerException("Entrada Inválida.");
		}
		
		if(tipo.isBlank()) {
			throw new IllegalArgumentException("Entrada Inválida.");
		}
		
		String saida = "";
		
		if(logger != null) {
			
			logger.setNomeDoMetodo("cadastraTransformacao");
			logger.setParametro(tipo);
			
			if(logger.getNome().equals("ConsoleLogger")||logger.getNome().equals("TimeConsoleLogger")) {
				saida += logger.toString() + "\n";
				
			}
		}
		
		this.tiposDeTransformacoes.put(tipo, algoritmo);
		return saida;
	}
	
/**
 * Retorna a string que representa as transformações, organizadas por ordem alfabética.
 * @return nomes da lista. 
 */
	public String listaTransformacoes() {
		ArrayList<String> lista = new ArrayList<>();
		for (String a:this.tiposDeTransformacoes.keySet()) {
			lista.add(a);
		}
		
	lista.sort(null);
	
	String nomes = "";
	for(String nome: lista) {
		nomes += nome + "\n";
	}
	return nomes;	
}
	
/**
 * Retorna a string que representa a saida do tipo Logger e a contagem das transformações.
 * @return a string e a contagem.
 */
	public String contagemDeTransformacoes() {
		
		String saida = "";
		
		if(logger != null) {
			
			logger.setNomeDoMetodo("contagemDeTransformacoes");
			logger.setParametro("");
			
			if(logger.getNome().equals("ConsoleLogger")||logger.getNome().equals("TimeConsoleLogger")) {
				saida += logger.toString() + "\n";
				
			}
		}
		
		return saida + contador;	
	}
	
/**
 * Retorna a string que representa a listagem original.
 * @return a string da listagem original.
 */
	public String listagemDeOriginais() {
		
		String saida = "";
		
		if(logger != null) {
			
			logger.setNomeDoMetodo("listagemDeOriginais");
			logger.setParametro("");
			
			if(logger.getNome().equals("ConsoleLogger")||logger.getNome().equals("TimeConsoleLogger")) {
				saida += logger.toString() + "\n";
				
			}
		}
		String lista = "";
		for (AlgoritmoTransformacao a: this.tiposDeTransformacoes.values()) {
			if(a.getOriginal() != null) {
			lista += a.getOriginal() +"\n";
			}
		}
			return saida + lista;
	}
	
/**
 * Retorna a string que representa a listagem de histórico.
 * @param parametro Parametro.
 * @return a string do histórico.
 */
	public String listagemDeHistorico(int parametro) {

		String saida = "";
		
		if(logger != null) {
			
			logger.setNomeDoMetodo("listagemDeHistorico");
			logger.setParametro(Integer.toString(parametro));
			
			if(logger.getNome().equals("ConsoleLogger")||logger.getNome().equals("TimeConsoleLogger")) {
				saida += logger.toString() + "\n";
				
			}
		}	
		String lista = "";
		lista += this.historico.get(parametro);
			return saida + lista;
	}
	
}
