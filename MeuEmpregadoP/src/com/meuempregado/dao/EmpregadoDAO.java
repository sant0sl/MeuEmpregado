package com.meuempregado.dao;

import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Empregado;

public class EmpregadoDAO implements iDAO<Empregado>{

	//Hibernate or JDBC configs and imports
	
	@Override
	public void inserir(Empregado objeto) {
		// Por fazer
	}

	@Override
	public void alterar(Empregado objeto) {
		// Por fazer	
	}

	@Override
	public List<Empregado> listarTudo() {
		// Por fazer
		return null;
	}
	
	//MÉTODO DE BUSCA GLOBAL
	
	public List<Empregado> buscarPorAtributos(String parametro) {
		List<Empregado> resultados = new ArrayList<Empregado>();
		
		// Por fazer
		
		return resultados;
	}
	
	//-----------------------------------------------------
	
	@Override
	public void deletar(Empregado objeto) {
		// NÃO TERÁ, APENAS ALTERAÇÃO DE STATUS DE ATIVIDADE
	}
	@Override
	public List<Empregado> buscarPorNome(String nome) {
		// TERÁ UM MÉTODO SÓ QUE BUSCARÁ INFORMAÇÕES DIVERSAS
		return null;
	}
}
