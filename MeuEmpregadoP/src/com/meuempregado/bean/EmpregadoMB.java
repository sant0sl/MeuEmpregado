package com.meuempregado.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.service.EmpregadoService;

@ManagedBean(name = "empregadoMB")
@SessionScoped
public class EmpregadoMB implements Serializable{
	
	//Serial para localizar o objeto na mem�ria
	private static final long serialVersionUID = -8822968212228745684L;
	
	//Criando vari�veis do tipo das Classes necess�rias
	private String filtroEmpregado;
	private String confirmarSenha;
	private String novaSenha;
	private String senhaAtual;
	private Empregado empregado;
	private List<Empregado> listaEmpregados;
	private EmpregadoService empregadoService;
	private Empregado empregadologado;
	
	//Construtor para novas inst�ncias das Classes
	public EmpregadoMB() {
		this.empregado = new Empregado();
		this.empregadologado = new Empregado();
		this.empregadoService = new EmpregadoService();
		this.listaEmpregados = this.empregadoService.listar();
	}

	//M�todo de inser��o dos dados do Empregado atr�ves do ManagedBean
	public String inserirEmpregadoAction() {
		this.empregado.setAtivo(true);
		this.empregadoService.inserir(this.empregado);
		System.out.println("Empregado Inserido");
		this.empregado = new Empregado();
		return "login";
	}
	
	//M�todo de altera��o dos dados do Empregado atr�ves do ManagedBean
	//OBS: prov�vel que haja problema com o Hibernate nesse m�todo, por causa da passagem do objeto completo, incluindo o id (o que pode dar conflito), ou n�o.
	public String alterarEmpregadoAction() {
		this.empregadoService.alterar(this.empregadologado);
		System.out.println("Empregado Alterado");
		return "painelAdministrativo";
	}
	
	//M�todo de listagem de todos os dados dos Empregados atr�ves do ManagedBean
	public void listarEmpregadoAction() {
		this.listaEmpregados = this.empregadoService.listar();
		System.out.println("Empregados na lista");
	}
	
	//M�todo de listagem da busca dos dados dos Empregados atr�ves de um filtro de pesquisa da tela
	//Filtra Empregados a partir de (cidade, bairro, endere�o e cep);
	public void filtrarEmpregadoAction() {
		this.listaEmpregados = this.empregadoService.filtrar(filtroEmpregado);
		System.out.println("Empregados filtrados na lista");
	}
	
	/*Metodo que busca o cep e retorna dados de endereco atraves de WebService*/
	public void buscarCepAlterarAction() throws Exception {
		System.out.println("Buscando Cep e dados de endere�o");
		this.empregado = this.empregadoService.buscarCEP(empregadologado);
	}
	
	/*Metodo que busca o cep e retorna dados de endereco atraves de WebService*/
	public void buscarCepAction() throws Exception {
		System.out.println("Buscando Cep e dados de endere�o");
		this.empregado = this.empregadoService.buscarCEP(empregado);
	}
	
	public String voltarRealizarCadastroAction() {
		this.empregado = new Empregado();
		return "login";
	}
	
	public String voltarBuscarEmpregadoAction() {
		this.empregado = new Empregado();
		return "pesquisarEmpregados";
	}
	
	public String voltarPainelAction() {
		this.empregado = new Empregado();
		return "painelAdministrativo";
	}
	
	public void limparCep() {
		this.empregado.setCep("");
		this.empregado.setEnderecoRua("");
		this.empregado.setBairro("");
		this.empregado.setCidade("");
		this.empregado.setUf("");
	}
	
	public String desativarConta() {
		this.empregadologado.setAtivo(false);
		this.empregadoService.alterar(empregadologado);
		this.empregadologado = new Empregado();
		return "login";
	}
		
	//-------------------------------------------
	
	//Getters and Setters

	public String getFiltroEmpregado() {
		return filtroEmpregado;
	}

	public void setFiltroEmpregado(String filtroEmpregado) {
		this.filtroEmpregado = filtroEmpregado;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

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

	public Empregado getEmpregadologado() {
		return empregadologado;
	}

	public void setEmpregadologado(Empregado empregadologado) {
		this.empregadologado = empregadologado;
	}
	
}
