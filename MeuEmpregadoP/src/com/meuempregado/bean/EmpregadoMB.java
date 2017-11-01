package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.service.EmpregadoService;


@ManagedBean(name = "empregadoMB")
@SessionScoped
public class EmpregadoMB implements Serializable{
	
	//Serial para localizar o objeto na memória
	private static final long serialVersionUID = -8822968212228745684L;
	
	//Criando variáveis do tipo das Classes necessárias
	private Empregado empregado;
	private List<Empregado> listaEmpregados;
	private EmpregadoService empregadoService;
	
	
	//RETORNAR À PÁGINA PRINCIPAL, OU PADRÃO APÓS CADASTRO, ALTERAÇÃO, OU OUTRA AÇÃO
	String index = "index";
	
	
	//Construtor para novas instâncias das Classes
	public EmpregadoMB() {
		this.empregado = new Empregado();
		this.empregadoService = new EmpregadoService();
		this.listaEmpregados = this.empregadoService.listar();
	}

	//Método de inserção dos dados do Empregado atráves do ManagedBean
	public String inserirAction() {
		this.empregadoService.inserir(this.empregado);
		System.out.println("Empregado Inserido");
		this.empregado = new Empregado();
		return this.index;
	}
	
	//Método de alteração dos dados do Empregado atráves do ManagedBean
	//OBS: provável que haja problema com o Hibernate nesse método, por causa da passagem do objeto completo, incluindo o id (o que pode dar conflito), ou não.
	public String alterarAction() {
		this.empregadoService.alterar(this.empregado);
		System.out.println("Empregado Alterado");
		this.empregado = new Empregado();
		return this.index;
	}
	
	//Método de listagem de todos os dados dos Empregados atráves do ManagedBean
	public String listarTudoAction() {
		this.listaEmpregados = this.empregadoService.listar();
		System.out.println("Empregados na lista");
		return this.index;
	}
	
	//Método de listagem da busca dos dados dos Empregados atráves de um filtro de pesquisa da tela
	//Usar o campo de busca como #{empregadoMB.empregado.nomeCompleto}
	/*public String buscarPorAtributos() {
		this.listaEmpregados = this.empregadoService.buscarPorAtributos(this.empregado.getNomeCompleto());
		System.out.println("Empregados filtrados na lista");
		return this.index;
	}*/
	
	/*Metodo que busca o cep e retorna dados de endereco atraves de WebService*/
	public void buscarCepAction() {
		
	}
	
	public String verEmpregadoAction() {
		return "verEmpregado";
		
	}
	
	//-------------------------------------------
	
	//Getters and Setters

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public List<Empregado> getListaEmpregados() {
		return listaEmpregados;
	}

	public void setListaEmpregados(List<Empregado> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}

	public EmpregadoService getEmpregadoService() {
		return empregadoService;
	}

	public void setEmpregadoService(EmpregadoService empregadoService) {
		this.empregadoService = empregadoService;
	}

}
