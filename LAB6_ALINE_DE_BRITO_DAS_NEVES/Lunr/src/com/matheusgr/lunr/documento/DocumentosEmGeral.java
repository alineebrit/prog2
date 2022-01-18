package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;
/**
 * Herança que é implementada por diversas classes que representam os documentos.
 * @author Aline de Brito das Neves.
 *
 */
public abstract class DocumentosEmGeral implements Documento{

	protected String id;
	protected String original;
	protected String limpo;
	protected Map<String, String> metadados;
	protected String[] split;

	/**
	 * Cria o DocumentoEmGeral, de acordo com os parâmetros.
	 * @param id Identificação do documento.
	 * @param original Código java original.
	 */
	public DocumentosEmGeral(String id, String original) {
		this.id = id;
		this.original = original;
		
	}
	
	/**
	 * Método responsável por retornar a quantidade de texto útil, sendo definido como a quantidade de caracteres úteis (sem caracteres estranhos e sem espaços) sobre o total de caracteres original (incluindo espaços).
	 * @return Percentual de texto útil (entre 0 e 1, inclusives).
	 */
	@Override
	public double metricaTextoUtil() {
		long extractedSize = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanSpaces, this.limpo).length();
		return (1.0 * extractedSize) / this.original.length();
	}

	/**
	 * Método responsável por retornar a identificação do documento. A documentação é definida pelo próprio documento e é uma String sem formatação específica.
	 * @return Identificação do documento.
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**
	 * Método responsável por retornar os termos do texto em formato de String. Não podem existir termos vazios (só de espaços, tabulações ou string vazia).
	 * @return array de Strings.
	 */
	@Override
	public String[] getTexto() {
		if (this.split == null) {
			this.split = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.cleanLines, this.limpo)
					.split(" ");
			Arrays.sort(this.split);
		}
		return this.split;
	}

	/**
	 * Método responsável por retornar em hashCode a identificação do documento.
	 * @return hashCode a identificação do documento.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	/**
	 * Método responsável por retornar as informações do documento.
	 */
	@Override
	public abstract String toString();

	/**
	 * Método responsável por retornar metadados referente ao documento, características próprias do documento.
	 * @return Mapa com os metadados descrito em forma textual.
	 */
	@Override
	public abstract Map<String, String> getMetadados();
}
