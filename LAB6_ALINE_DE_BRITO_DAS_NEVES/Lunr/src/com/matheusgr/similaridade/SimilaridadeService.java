package com.matheusgr.similaridade;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa a similaridade.
 */
public class SimilaridadeService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         SimilaridadeService.
	 */
	public SimilaridadeService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Calcula e retorna a similaridade.
	 * 
	 * Para o cálculo da similaridade:
	 * <ul>
	 * <li>Pega o documento 1</li>
	 * <li>Pega o documento 2</li>
	 * <li>Pega os termos do documento 1 e coloca em um conjunto (Termos1)</li>
	 * <li>Pega os termos do documento 2 e coloca em um conjunto (Termos2)</li>
	 * <li>Calcula a interseção entre Termos1 e Termos2 (Inters)</li>
	 * <li>Calcula a união entre Termos1 e Termos2 (Uniao)</li>
	 * <li>A similaridade é o tamanho de Inters sobre o tamanho do conjunto
	 * Uniao</li>
	 * </ul>
	 * 
	 * @param docId1 Documento 1.
	 * @param docId2 Documento 2.
	 * @return Valor de similaridade (entre 0 e 1, inclusives) representando a
	 *         semelhança entre os documentos.
	 */
	public double similaridade(String docId1, String docId2) {
		Optional<Documento> documento1 = this.documentoService.recuperaDocumento(docId1);
		Optional<Documento> documento2 = this.documentoService.recuperaDocumento(docId2);
		
		Documento doc1 = documento1.get();
		Documento doc2 = documento2.get();
		
		String[] textodoc1 = doc1.getTexto();
		String[] textodoc2 = doc2.getTexto();
		
		Set<String> setdoc1 = new HashSet<>();
		for(String a: textodoc1) {
		    setdoc1.add(a);
		}
		
		Set<String> setdoc2 = new HashSet<>();
		for(String a: textodoc2) {
		    setdoc2.add(a);
		}
		
		Set<String> uniao = new HashSet<String>(setdoc1); 
		uniao.addAll ( setdoc2 );
		
		Set<String> intersection = new HashSet<String>(setdoc1); 
		intersection.retainAll(setdoc2);
		
		double similaridade = (double) intersection.size() / uniao.size();
		return similaridade;
	}

}
