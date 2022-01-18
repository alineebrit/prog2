package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;
/**
 * Interface que é implementada por diversas classes que representam as buscas.
 * @author Aline de Brito Das Neves.
 *
 */
public interface InterfaceDeBuscas {
	
/**
 * Método responsável por realizar a busca a partir da consulta ao DocumentoService.
 * @param ds DocumentoService a ser utilizado para busca.
 * @return Mapa com os documentos encontrados e o fator de relevância de cada operação.
 */
	public Map<Documento, Integer> busca(DocumentoService ds);

/**
 * Método responsável por descrever uma consulta com o intuito de explicar o motivo consulta que foi realizada.
 * @return Descrição da busca.
 */
	public String[][] descreveConsulta();
	
}