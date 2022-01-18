package testes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.ControleAluno;
import controle.Grupo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

public class TestControleAluno {
			
	@Test
	public void testCadastrarAlunoNomeNulo() {
		try{
			ControleAluno controle = new ControleAluno();
			controle.cadastrarAluno("12",null,"cc");	         
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	@Test
	public void testCadastrarAlunoMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.cadastrarAluno(null, "Aline", "cc");        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	@Test
	public void testCadastrarAlunoCursoNulo() {
		 try{
			 ControleAluno controle = new ControleAluno();
			 controle.cadastrarAluno("1","Livia"," ");
		 }catch(IllegalArgumentException npe){
			 assertEquals("Entrada inválida",npe.getMessage());
		 }
	} 
	
	@Test
	public void testCadastrarAlunoNomeVazio() {
	    try{
	    	ControleAluno controle = new ControleAluno();
	    	controle.cadastrarAluno("12"," ","cc");
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
	     }
	}
	
	@Test
	public void testCadastrarAlunoMatriculaVazia() {
	    try{
	    	ControleAluno controle = new ControleAluno();
	    	controle.cadastrarAluno(" ", "Aline", "cc"); 
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	@Test
	public void testCadastrarAlunoCursoVazio() {
	    try{
	    	ControleAluno controle = new ControleAluno();
	    	controle.cadastrarAluno("1","Livia"," ");
		}catch(IllegalArgumentException e){
			assertEquals("Entrada inválida",e.getMessage());
		}
	}
	   	 
	@Test
	public void testCadastrarAluno(){
		
	ControleAluno controle = new ControleAluno();
	controle.cadastrarAluno("Livia", "2", "cc");
		assertEquals("MATRICULA JÁ CADASTRADA!", controle.cadastrarAluno("Livia", "2", "cc"));
		assertEquals("CADASTRO REALIZADO!", controle.cadastrarAluno("Aline", "1","cc"));
	    }  
	
	@Test
	public void testConsultaAlunoMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.consultaAluno(null);        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	
	@Test
	public void testConsultaAlunoMatriculaVazia() {
	    try{
	    	ControleAluno controle = new ControleAluno();
	    	controle.consultaAluno(" "); 
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	
	@Test
	public void testConsultaAluno(){
		ControleAluno controle = new ControleAluno ();
		controle.cadastrarAluno("Arthur","3","cc");
		assertEquals("Aluno não cadastrado." ,controle.consultaAluno("1"));
		assertEquals("3 - Arthur - cc" , controle.consultaAluno("3"));
	}
	
	@Test
	public void testCadastraGrupoNomeDoGrupoNulo(){
		try{
			ControleAluno controle = new ControleAluno();
			controle.cadastraGrupo(null, "1");
		    }catch(NullPointerException npe){
		    assertEquals("Entrada inválida",npe.getMessage());
		}
		}

	@Test
	public void testCadastraGrupoNomeDoGrupoNulo2(){
		try{
			ControleAluno controle = new ControleAluno();
			controle.cadastraGrupo(null, "");
		    }catch(NullPointerException npe){
		    assertEquals("Entrada inválida",npe.getMessage());
		}
		}
	
	@Test
	public void testCadastraGrupoNomeDoGrupoVazio(){
	     try{
	    	 ControleAluno controle = new ControleAluno();
			controle.cadastraGrupo(" ", "");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	
	@Test
	public void testCadastraGrupoNomeDoGrupoVazio2(){
	     try{
	    	 ControleAluno controle = new ControleAluno();
			controle.cadastraGrupo(" ", "1");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	
	@Test
	public void testCadastraGrupo(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("3","Arthur","cc");	
	controle.cadastraGrupo("P2", "");
	
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastraGrupo("P2", ""));
		assertEquals("GRUPO JÁ CADASTRADO!", controle.cadastraGrupo("P2", "5"));
		assertEquals("CADASTRO REALIZADO!", controle.cadastraGrupo("adm", "90"));
		assertEquals("CADASTRO REALIZADO!", controle.cadastraGrupo("a", ""));
	}
	
	
	@Test
	public void testAlunoQueRespondeQuestoesNoQuadroMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.alunoQueRespondeQuestoesNoQuadro(null);        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	
	@Test
	public void testAlunoQueRespondeQuestoesNoQuadroMatriculaVazia() {
	    try{
	    	ControleAluno controle = new ControleAluno();
	    	controle.alunoQueRespondeQuestoesNoQuadro(" "); 
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	@Test
	public void testAlunoQueRespondeQuestoesNoQuadro(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("Arthur","3","cc");	
		assertEquals("ALUNO REGISTRADO!", controle.alunoQueRespondeQuestoesNoQuadro("3"));
		assertEquals("Aluno não cadastrado.", controle.alunoQueRespondeQuestoesNoQuadro("1"));
	}

	@Test
	public void testAlocaOuPertinenciaAGrupoNomeDoGrupoNulo(){
		try{
			ControleAluno controle = new ControleAluno();
			controle.alocaOuPertinenciaAGrupo(null, "1");
		    }catch(NullPointerException npe){
		    assertEquals("Entrada inválida",npe.getMessage());
		}
		}

	@Test
	public void testAlocaOuPertinenciaAGrupoNomeDoGrupoVazio(){
	     try{
	    	 ControleAluno controle = new ControleAluno();
	    	 controle.alocaOuPertinenciaAGrupo(" ", "1");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	
	@Test
	public void testAlocaOuPertinenciaAGrupoMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.alocaOuPertinenciaAGrupo("P2", null);        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	
	@Test
	public void testAlocaOuPertinenciaAGrupoMatriculaVazia() {
	    try{
	    	ControleAluno controle = new ControleAluno();
			controle.alocaOuPertinenciaAGrupo("P2", "");
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	@Test
	public void testAlocaOuPertinenciaAGrupo(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("Arthur","3","cc");	
	controle.cadastrarAluno("Livia","2","cc");
	controle.cadastrarAluno("Aline", "4", "cc");
	controle.cadastraGrupo("P2","" );
	controle.cadastraGrupo("lindo", "1");
	controle.alocaOuPertinenciaAGrupo("3", "lindo");
	controle.alocaOuPertinenciaAGrupo("2", "lindo");
		assertEquals("Grupo não cadastrado.", controle.alocaOuPertinenciaAGrupo("3", "Artes"));
		assertEquals("Aluno não cadastrado.", controle.alocaOuPertinenciaAGrupo("5", "P2"));
		assertEquals("GRUPO CHEIO", controle.alocaOuPertinenciaAGrupo("4", "lindo"));
		assertEquals("ALUNO ALOCADO!", controle.alocaOuPertinenciaAGrupo("2", "P2"));
		assertEquals("ALUNO JA ALOCADO!", controle.alocaOuPertinenciaAGrupo("2", "P2"));
	}
	
	
	@Test
	public void testPertinenciaAGrupoNomeDoGrupoNulo(){
		try{
			ControleAluno controle = new ControleAluno();
			controle.pertinenciaAGrupo("1", null);
		    }catch(NullPointerException npe){
		    assertEquals("Entrada inválida",npe.getMessage());
		}
		}

	@Test
	public void testPertinenciaAGrupoNomeDoGrupoVazio(){
	     try{
	    	 ControleAluno controle = new ControleAluno();
	    	 controle.pertinenciaAGrupo("1", " ");
	     }catch(IllegalArgumentException e){
	   assertEquals("Entrada inválida",e.getMessage());
	}
	}
	
	@Test
	public void testPertinenciaAGrupoMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.pertinenciaAGrupo(null, "cc");        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	
	@Test
	public void testPertinenciaAGrupoMatriculaVazia() {
	    try{
	    	Aluno aluno = new Aluno(" ", "Aline", "cc"); 
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	@Test
	public void testPertinenciaAGrupo(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("Arthur","3","cc");	
	controle.cadastrarAluno("Livia","2","cc");
	controle.cadastraGrupo("lindo", "");
	controle.alocaOuPertinenciaAGrupo("3", "lindo");
	controle.cadastraGrupo("P2", "");
	assertEquals("GRUPO NÃO CADASTRADO.", controle.pertinenciaAGrupo("Artes", "3"));
	assertEquals("ALUNO NÃO PERTENCE AO GRUPO.", controle.pertinenciaAGrupo("P2", "2"));
	assertEquals("ALUNO PERTENCE AO GRUPO", controle.pertinenciaAGrupo("lindo", "3"));
	}
	
	
	@Test
	public void testImprimirAlunosQueRespondeQuestoesNoQuadro(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("Arthur","3","cc");	
	
	controle.alunoQueRespondeQuestoesNoQuadro("3");

	assertEquals("1. 3 - Arthur - cc\n", controle.imprimirAlunosQueRespondeQuestoesNoQuadro());

	
	}

	
	@Test
	public void testChecagemDosGruposMatriculaNula() {
	   try{
		   ControleAluno controle = new ControleAluno();
		   controle.checagemDosGrupos(null);        
	     }catch(NullPointerException npe){
	    	 assertEquals("Entrada inválida",npe.getMessage());
	     }
	}
	
	
	@Test
	public void testChecagemDosGruposMatriculaVazia() {
	    try{ 
	    	ControleAluno controle = new ControleAluno();
	    	controle.checagemDosGrupos(" "); 
		 }catch(IllegalArgumentException e){
			 assertEquals("Entrada inválida",e.getMessage());
		}
	}
	
	@Test
	public void testChecagemDosGrupos(){

	ControleAluno controle = new ControleAluno ();
	controle.cadastrarAluno("Arthur","3","cc");	
	controle.cadastraGrupo("lindo", "");
	controle.cadastraGrupo("P2", "");
	controle.alocaOuPertinenciaAGrupo("3", "lindo");
	controle.alocaOuPertinenciaAGrupo("3", "P2");

	assertEquals("P2\nlindo\n", controle.checagemDosGrupos("3"));	
	}

	
	
}


