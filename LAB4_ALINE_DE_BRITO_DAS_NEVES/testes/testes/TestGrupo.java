package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import controle.Aluno;
import controle.Grupo;

public class TestGrupo {
	
	@Test
	public void testaConstrutorDoGrupoComNomeNulo(){
		try{
			Grupo grupo= new Grupo(null);
		    }catch(NullPointerException npe){
		    assertEquals("Entrada inválida",npe.getMessage());
		}
		}

	@Test
	public void testaConstrutorDeAlunoComNomeVazio(){
	     try{
	    	 Grupo grupo= new Grupo(" ");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	
	@Test
	public void testaConstrutor(){
		new Grupo("lindas", 2);
		new Grupo("fofocas");
		
		}

	@Test 
	void testaGrupoTaCheio() {
		Grupo grupo = new Grupo("ar", 2);
		Aluno aluno1 = new Aluno ("1","aline", "c");
		Aluno aluno2 = new Aluno ("2","livia", "c");
		Aluno aluno3 = new Aluno ("3","arthur", "c");
		grupo.adicionaAluno(aluno1);
		grupo.adicionaAluno(aluno2);
		assertEquals(true , grupo.grupoTaCheio());
		assertEquals("GRUPO CHEIO",grupo.adicionaAluno(aluno3));
	
	}
	
	@Test 
	void testaPertenceGrupo() {
		Aluno aluno = new Aluno("2", "Livia","c"); 
		Aluno aluno2 = new Aluno("3","Aline","c");
		Grupo grupo = new Grupo("cc");
		grupo.adicionaAluno(aluno);
		assertTrue(grupo.pertenceGrupo(aluno));
		assertFalse( grupo.pertenceGrupo(aluno2));
	}
	
	@Test 
	void testaAdicionaAluno() {
		Aluno aluno = new Aluno("2", "Livia","c"); 
		Aluno aluno2 = new Aluno("1","Aline","c");
		Grupo grupo = new Grupo("cc", 1);
		assertEquals("CADASTRADO" , grupo.adicionaAluno(aluno));
		assertEquals("GRUPO CHEIO" , grupo.adicionaAluno(aluno2));
	}
	
	
}