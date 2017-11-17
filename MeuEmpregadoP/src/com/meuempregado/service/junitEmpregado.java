package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.meuempregado.model.Empregado;

public class junitEmpregado {

	@Test
	public void TesteUnit() throws Exception {
		
		/*Empregado e = new Empregado();
		e.setId(1);
		e.setNomeCompleto("Leonardo da Vinte");
		e.setEmail("sant0sl@outlook.com");
		e.setSenha("123123");
		e.setDataNascimento("19/10/1998");
		e.setCpf("111.111.111-11");
		e.setRg("11.111.111-1");
		e.setTelefoneFixo("(41)1111-1111");
		e.setTelefoneCelular("(41)11111-1111");
		e.setCep("83750000");
		e.setEnderecoRua("St. Highway to Hell");
		e.setEnderecoNumero(666);
		e.setComplemento("House");
		e.setBairro("Heaven");
		e.setCidade("Lapa");
		e.setUf("PR");
		e.setAtivo(true);
		e.setSexo(false);
		e.setDescricao("Facear");*/
		
		//-------------------------------------------
		//Instanciando Service do Empregado
		EmpregadoService es = new EmpregadoService();
		
		//Instanciando vari�veis para teste
		Empregado mostrar = new Empregado();
		List<Empregado> listar = new ArrayList<>();
		//-------------------------------------------

		/*M�todo de inserir informa��es no banco de dados*/
		//es.inserir(e);
		
		/*M�todo de alterar informa��es no banco de dados*/
		//es.alterar(e);
		
		//-------------------------------------------
		
		/*M�todo para listar todos os registros do banco de dados*/
		listar = es.listar();
		
		/*M�todo para listar empregados a partir de um campo de pesquisa. Filtrando por(cidade, bairro, endere�o ou cep)*/
		//listar = es.filtrar("heav");
		
		/*M�todo para buscar cep atrav�s de WebService*/
		/*mostrar.setCep("81900400");
		es.buscarCEP(mostrar);*/
		
		//----------------Mostra informa��es no console-----------------
		System.out.println(mostrar);
		System.out.println(listar);
	}
	
}
