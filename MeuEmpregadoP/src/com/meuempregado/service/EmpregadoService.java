package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.Empregado;

public class EmpregadoService implements InterfaceService<Empregado>{

	//Método de inserção de um novo Empregado
	@Override
	public void inserir(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).inserir(entity);
	}

	//Método de exclusão de um novo Empregado
	@Override
	public void excluir(Integer id) {
		FactoryDao.createGenericDao(Empregado.class).excluir(id);
	}

	//Método de alteração das informações do objeto "entity" do tipo Empregado que for passado por parâmetro
	@Override
	public void alterar(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).alterar(entity);
	}

	//Método que busca todos os registros da base de dados
	@Override
	public List<Empregado> listar() {
		return FactoryDao.createGenericDao(Empregado.class).listar();
	}

	//Método que busca pelo id o registro da base de dados
	@Override
	public Empregado obter(Integer id) {
		return FactoryDao.createGenericDao(Empregado.class).obter(id);
	}
	
	//Método que filtra registros direto da base de dados, através de um parâmetro.
	/*public List<Empregado> buscarPorAtributos(String parametro){
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
	}*/
}
