package com.meuempregado.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.lavieri.modelutil.cep.WebServiceCep;

import com.meuempregado.dao.Conexao;
import com.meuempregado.dao.FactoryDao;
import com.meuempregado.dao.GenericDao;
import com.meuempregado.model.Empregado;

public class EmpregadoService extends GenericDao<Empregado> implements InterfaceService<Empregado>{

	//M�todo de inser��o de um novo Empregado
	@Override
	public void inserir(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).inserir(entity);
	}

	@Override
	public void excluir(Integer id) {
		//N�O SER� EXCLU�DO NENHUM REGISTRO
	}

	//M�todo de altera��o das informa��es do objeto "entity" do tipo Empregado que for passado por par�metro
	@Override
	public void alterar(Empregado entity) {
		FactoryDao.createGenericDao(Empregado.class).alterar(entity);
	}

	//M�todo que busca todos os registros da base de dados
	@Override
	public List<Empregado> listar() {
		return FactoryDao.createGenericDao(Empregado.class).listar();
	}

	//M�todo que busca pelo id o registro da base de dados
	@Override
	public Empregado obter(Integer id) {
		return FactoryDao.createGenericDao(Empregado.class).obter(id);
	}
	
	//M�todo que filtra registros direto da base de dados, atrav�s de um par�metro em um campo de pesquisa. (cidade, bairro, endere�o ou cep);
	public List<Empregado> filtrar(String parametro){
		//Faz uma lista do tipo empregado
		List<Empregado> listaResultado = new ArrayList<Empregado>();
		
		//verifica��o da string que foi passada por par�metro e dependendo vai atribuir na lista o resultado.
		if(parametro != null && parametro.trim().length() > 0) {
			em = Conexao.getInstance().createEntityManager();
			//Query
			String hql = "select e from Empregado e where (e.cidade like :p) or (e.bairro like :p) or (e.enderecoRua like :p) or (e.cep like :p)";
			Query query = em.createQuery(hql);
			query.setParameter("p", "%"+parametro+"%");
			listaResultado = (List<Empregado>) query.getResultList();
		}else {
			listaResultado = null;
		}
		
		//Retorna o que foi atribu�da � lista do tipo Empregado
		return listaResultado;
	}
	
	//M�todo de busca de informa��es de endere�o atrav�s de WebService.
	public Empregado buscarCEP(Empregado e) throws Exception {
		WebServiceCep ws = WebServiceCep.searchCep(e.getCep());
		if(ws.isCepNotFound()==true) {
			throw new Exception("N�o foi encontrado nenhuma informa��o atrav�s deste CEP.");
		}else {
			e.setEnderecoRua(ws.getLogradouroFull());
			e.setBairro(ws.getBairro());
			e.setCidade(ws.getCidade());
			e.setUf(ws.getUf());			
		}
		return e;
	}

	public void desativarConta(Empregado e) {
		// TODO Auto-generated method stub
		
	}
	
}
