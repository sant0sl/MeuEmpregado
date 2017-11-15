package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Usuario;
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
	private Usuario usuario;
	private List<Usuario> listaEmpregados;
	private EmpregadoService empregadoService;
	
	//Construtor para novas inst�ncias das Classes
	public EmpregadoMB() {
		this.usuario = new Usuario();
		this.empregadoService = new EmpregadoService();
		//this.listaEmpregados = this.empregadoService.listar();
	}

	//M�todo de inser��o dos dados do Empregado atr�ves do ManagedBean
	public void inserirEmpregadoAction() {
		//this.empregadoService.inserir(this.usuario);
		System.out.println("Empregado Inserido");
		this.usuario = new Usuario();
	}
	
	//M�todo de altera��o dos dados do Empregado atr�ves do ManagedBean
	//OBS: prov�vel que haja problema com o Hibernate nesse m�todo, por causa da passagem do objeto completo, incluindo o id (o que pode dar conflito), ou n�o.
	public void alterarEmpregadoAction() {
		//this.empregadoService.alterar(this.empregado);
		System.out.println("Empregado Alterado");
		this.usuario = new Usuario();
	}
	
	//M�todo de listagem de todos os dados dos Empregados atr�ves do ManagedBean
	public void listarEmpregadoAction() {
	//	this.listaEmpregados = this.empregadoService.listar();
		System.out.println("Empregados na lista");
	}
	
	//M�todo de listagem da busca dos dados dos Empregados atr�ves de um filtro de pesquisa da tela
	//Filtra Empregados a partir de (cidade, bairro, endere�o e cep);
	//Usar o campo de busca como #{empregadoMB.empregado.nomeCompleto}
	public void filtrarEmpregadoAction() {
	//	this.listaEmpregados = this.empregadoService.filtrar(filtroEmpregado);
		System.out.println("Empregados filtrados na lista");
		filtroEmpregado ="";
	}
	
	/*Metodo que busca o cep e retorna dados de endereco atraves de WebService*/
	public void buscarCepAction() throws Exception {
		System.out.println("Buscando Cep e dados de endere�o");
		//this.usuario = this.empregadoService.buscarCEP(usuario);
	}
	
	public String verEmpregadoAction() {
		return "verEmpregado";
	}
	
	//-------------------------------------------
	
	//Getters and Setters

	

	public List<Usuario> getListaEmpregados() {
		return listaEmpregados;
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

	public String getFiltroEmpregado() {
		return filtroEmpregado;
	}

	public void setFiltroEmpregado(String filtroEmpregado) {
		this.filtroEmpregado = filtroEmpregado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setListaEmpregados(List<Usuario> listaEmpregados) {
		this.listaEmpregados = listaEmpregados;
	}
}
