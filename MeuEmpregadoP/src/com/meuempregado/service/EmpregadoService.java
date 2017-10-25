package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.EmpregadoDAO;
import com.meuempregado.model.Empregado;

public class EmpregadoService {

	//variável dao do tipo EmpregadoDAO
	private EmpregadoDAO dao;
	
	//Construtor
	public EmpregadoService() {
		//atribui ao dao uma nova instância, cada vez que é chamado uma nova instância "EmpregadoService"
		dao = new EmpregadoDAO();
	}
	
	//Método de inserção de um novo Empregado
	public void inserirEmpregado(Empregado e) {
		dao.inserir(e);
	}
	
	//Método de alteração das informações do objeto "e" do tipo Empregado que for passado por parâmetro
	public void alterarEmpregado(Empregado e) {
		dao.alterar(e);
	}
	
	//Método que busca todos os registros da base de dados
	public List<Empregado> listarTudo(){
		return dao.listarTudo();
	}
	
	//Método que filtra registros direto da base de dados, através de um parâmetro.
	public List<Empregado> buscarPorAtributos(String parametro){
		//Faz uma lista do tipo empregado
		List<Empregado> lista = new ArrayList<Empregado>();
		
		//verificação da string que foi passada por parâmetro
		if(parametro != null && parametro.trim().length() > 0) {
			lista = dao.buscarPorAtributos(parametro);
		}else {
			lista = listarTudo();
		}
		
		//Retorna o que foi atribuída à lista do tipo Empregado
		return lista;
	}
}
