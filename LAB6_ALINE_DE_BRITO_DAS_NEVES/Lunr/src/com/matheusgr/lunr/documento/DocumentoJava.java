package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

/**
 * Documento base java. As palavras-chave da linguagem ainda são preservadas
 * (como public, private, etc), mas elimina-se documentação e comentários.
 */
public class DocumentoJava extends DocumentosEmGeral {



	/**
	 * Cria o DocumentoJava, extraindo o texto base.
	 * 
	 * @param id       ID do documento a ser criado.
	 * @param original Código java original.
	 */
	public DocumentoJava(String id, String original) {
		super(id, original);
		var transformaTexto = new TransformaTexto();
		var txt = transformaTexto.transforma(TransformaTexto.Algoritmos.java, original);
		this.limpo = (new TransformaTexto()).transforma(TransformaTexto.Algoritmos.clean, txt).strip();
		

	}

	/**
	 * Método responsável por ver se é nulo, se as classes são as mesmas, e compara se os ids são iguais.
	 * @return true se forem iguais, ou false se não forem.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentoJava other = (DocumentoJava) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Método responsável por retornar as informações do DocumentoJava.
	 * @return toString formatado.
	 */
	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.limpo;
	}

	/**
	 * Método responsável por retornar metadados referente ao documento, características próprias do documento.
	 * @return Mapa com os metadados descrito em forma textual.
	 */
	@Override
	public Map<String, String> getMetadados() {
		if (this.metadados != null) {
			return this.metadados;
		}
		this.metadados = extractData(this.original);
		this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
		this.metadados.put("TAMANHO", "" + this.limpo.length());
		this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		this.metadados.put("TIPO", "" + "java");
		return this.metadados;
	}

	/*
	 * Metadados particulares de java: número de imports e autor da classe.
	 */
	private Map<String, String> extractData(String original2) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("IMPORTS", "" + ((this.limpo.length() - this.limpo.replaceAll("import ", "").length()) / 7));
		metadados2.put("AUTHOR", "" + (this.original.indexOf("@author") != -1 ? "TRUE" : ""));
		return metadados2;
	}

}
