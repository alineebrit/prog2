package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * 
 * @author Aline de Brito das Neves.
 *
 */
public class BuscaAvancada implements InterfaceDeBuscas{

	private Map<String, String> termos; 
	
	/**
	 * Constrói a classe BuscaAvancada, de acordo com os parâmetros.
	 * @param termos Termos de Busca.
	 */
	public BuscaAvancada(Map<String, String> termos) {
		this.termos = termos;
	}
	
	/**
	 * Método responsável por realizar a busca a partir da consulta ao DocumentoService.
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada operação.
	 */
	@Override
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (Documento d : ds.busca(termos)) {
			respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
		}
		return respostaDocumento;
	}

	/**
	 * Método responsável por descrever uma consulta com o intuito de explicar o motivo consulta que foi realizada.
	 * @return Descrição da busca.
	 */
	@Override
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.termos.size()][];
		int contador = 0;
		
		for (String a: this.termos.keySet()) {
			resultado[contador] = new String[] {"TERMO " + (contador + 1), a, this.termos.get(a)};
			contador += 1;
		}
		return resultado;
		
	}

	
}
