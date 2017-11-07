package com.meuempregado.service;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meuempregado.model.Empregado;

public class junitEmpregado {

	@Test
	public void TesteUnit() {
		
		/*Empregado e = new Empregado();
		//e.setId(2);
		e.setNomeCompleto("Daniel Fosquerau");
		e.setDataNascimento(new Date());
		e.setCpf("222.222.222-22");
		e.setRg("22.222.222-2");
		e.setTelefoneFixo("(41)2222-2222");
		e.setTelefoneCelular("(41)22222-2222");
		e.setCep("83750000");
		e.setEnderecoRua("Rua C");
		e.setEnderecoNumero(222);
		e.setComplemento("Casa");
		e.setBairro("Barça");
		e.setCidade("Lapa");
		e.setUf("PR");
		e.setEmail("danfosquerau@gmail.com");
		e.setSenha("222");
		e.setAtivo(true);
		e.setSexo(true);
		e.setDescricao("Teste");*/
		
		EmpregadoService es = new EmpregadoService();
		//es.inserir(e);
		
		//es.alterar(e);
		
		List<Empregado> listar = es.listar();
		//Método de filtro
		System.out.println(listar);
		
		//Empregado empregado = es.obter(1);
		//System.out.println(empregado);
		
	}
	
}
