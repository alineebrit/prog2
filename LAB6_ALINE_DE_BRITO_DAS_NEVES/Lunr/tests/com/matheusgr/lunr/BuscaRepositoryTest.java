package com.matheusgr.lunr;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import  com.matheusgr.lunr.busca.BuscaRepository;
import  com.matheusgr.lunr.busca.BuscaSimples;
import com.matheusgr.lunr.busca.HistoricoBusca;
import com.matheusgr.lunr.busca.InterfaceDeBuscas;
import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoDTO;
import com.matheusgr.lunr.documento.DocumentoHtml;

public class BuscaRepositoryTest {
	
	@Test
	public void testaConstrutor(){
		BuscaRepository buscaRepository = new BuscaRepository();
	}
	
	@Test
	public void testaHitoricoBusca(){
		BuscaRepository buscaRepository = new BuscaRepository();
		String[] array=new String[2];
		array[0]="teste";
		array[1]="oi";
		InterfaceDeBuscas buscaSimples = new BuscaSimples(array);
		Documento d = new DocumentoHtml("1","aaaa");
		DocumentoDTO dto=new DocumentoDTO(d);
		DocumentoDTO[] arraydedocs=new DocumentoDTO[1];
		arraydedocs[0]=dto;
		buscaRepository.adicionaBusca(buscaSimples, arraydedocs);
		String[] arr=new String[1];
		arr[0]="1";
		HistoricoBusca historicoBusca = new HistoricoBusca(buscaSimples, arr);
		assertEquals(historicoBusca.ids()[0],buscaRepository.recuperar(0).ids()[0]);
	}
	
}