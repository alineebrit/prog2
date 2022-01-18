package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.Grupo;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestAluno {

	@Test
	public void testaConstrutorDeAlunoComNomeNulo1(){
	     try{
	         Aluno aluno = new Aluno("12",null,"cc");	         
	     }catch(NullPointerException npe){
	   assertEquals("Entrada inválida",npe.getMessage());
	}
	}
	
	@Test
	public void testaConstrutorDeAlunoComNomeNulo2(){
	     try{
	    	Aluno aluno = new Aluno(null, "Aline", "cc");        
	     }catch(NullPointerException npe){
	   assertEquals("Entrada inválida",npe.getMessage());
	}
	}
	
	@Test
	public void testaConstrutorDeAlunoComNomeNulo3(){
	     try{
	         Aluno aluno= new Aluno("1","Livia",null);	         
	     }catch(NullPointerException npe){
	   assertEquals("Entrada inválida",npe.getMessage());
	}
	}
	
	@Test
	public void testaConstrutorDeAlunoComVazio1(){
	     try{
	         Aluno aluno = new Aluno("12"," ","cc");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}

	@Test
	public void testaConstrutorDeAlunoComVazio2(){
	     try{
	    	 Aluno aluno = new Aluno(" ", "Aline", "cc"); 
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	 
	 @Test
	public void testaConstrutorDeAlunoComVazio3(){
		 try{
			 Aluno aluno= new Aluno("1","Livia"," ");
		 }catch(IllegalArgumentException e){
	  assertEquals("Entrada inválida",e.getMessage());
		 }
		}   

	
	@Test
	public void testaConstrutor(){
		new Aluno("1","Aline", "cc");
	}
	
	@Test
	public void testaAdicionaNomeDeGrupo(){
		ArrayList<Grupo> grupos = new ArrayList<>();
		Grupo grupo = new Grupo ("cc");
		grupos.add(grupo);
		Aluno aluno = new Aluno ("1", "Aline", "cc");
		aluno.adicionaNomeDeGrupo(grupo);
		assertEquals(grupos,aluno.getGrupos());
	}
	}