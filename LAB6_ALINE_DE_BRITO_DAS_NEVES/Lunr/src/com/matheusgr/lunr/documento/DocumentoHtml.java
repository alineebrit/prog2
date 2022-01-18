package com.matheusgr.lunr.documento;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import biblitex.TransformaTexto;

/**
 * DocumentoHTML representa e extrai dados de um HTML.
 * 
 * Os termos extraídos são obtidos dos textos dos nós do HTML. São ignorados
 * nome de tags ou de propriedades. Por não ser um texto bem formulado, limpa-se
 * da melhor forma possível o HTML.
 * 
 * Os metadados são obtidos de características do documento, mas de detalhes
 * descritos na tag HEAD.
 */
public class DocumentoHtml extends DocumentosEmGeral {

	private static final String HEAD_METADADO = "HEAD";
	

	/**
	 * Construtor padrão. Realiza o processamento de extração do HTML.
	 * 
	 * @param id ID do documento a ser criado.
	 * @param original HTML do documento a ser criado.
	 */
	public DocumentoHtml(String id, String original) {
		super(id, original);
		var transformaTexto = new TransformaTexto();
		var txt = transformaTexto.transforma(TransformaTexto.Algoritmos.html, original);
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
		DocumentoHtml other = (DocumentoHtml) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Método responsável por retornar as informações do DocumentoHtml.
	 * @return toString formatado.
	 */
	@Override
	public String toString() {
		return "===" + this.id + System.lineSeparator() + this.getMetadados().get(HEAD_METADADO)
				+ System.lineSeparator() + "===" + this.limpo;
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
		this.metadados = extractHead(this.original);
		this.metadados.put("LINHAS", "" + this.original.chars().filter((value) -> '\n' == value).count());
		this.metadados.put("TAMANHO", "" + this.limpo.length());
		this.metadados.put("METADATADATE", "" + System.currentTimeMillis());
		this.metadados.put("TIPO", "" + "html");
		return this.metadados;
	}

	/*
	 * Os metadados do HTML incluem, especificamente:
	 * - Quantidade de tags, estimada a partir da quantidade de símbolos <
	 * - Todo o corpo da tag <head>
	 */
	private Map<String, String> extractHead(String original2) {
		Map<String, String> metadados2 = new HashMap<>();
		metadados2.put("BRUTE_TAGS", "" + this.original.chars().filter((value) -> '<' == value).count());
		String meta = "";
		int headStart = original2.toLowerCase().indexOf("<head>");
		if (headStart != -1) {
			int headEnd = original2.toLowerCase().indexOf("</head>");
			if (headEnd != -1) {
				meta = original2.substring(headStart, headEnd);
			}
		}
		metadados2.put(HEAD_METADADO, meta);
		return metadados2;
	}
}
