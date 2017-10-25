package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import com.meuempregado.model.Empregado;
import com.meuempregado.service.EmpregadoService;

//Hibernate configs
//@ManagedBean(name = "empregadoMB")
//@SessionScoped
public class EmpregadoMB implements Serializable{
	
	//Serial para localizar o objeto na mem�ria
	private static final long serialVersionUID = -8822968212228745684L;
	
	//Criando vari�veis do tipo das Classes necess�rias
	private Empregado empregado;
	private List<Empregado> listaEmpregados;
	private EmpregadoService empregadoService;
	
	
	//RETORNAR � P�GINA PRINCIPAL, OU PADR�O AP�S CADASTRO, ALTERA��O, OU OUTRA A��O
	String index = "index";
	
	
	//Construtor para novas inst�ncias das Classes
	public EmpregadoMB() {
		this.empregado = new Empregado();
		this.empregadoService = new EmpregadoService();
		this.listaEmpregados = this.empregadoService.listarTudo();
	}

	//M�todo de inser��o dos dados do Empregado atr�ves do ManagedBean
	public String inserir() {
		this.empregadoService.inserirEmpregado(this.empregado);
		System.out.println("Empregado Inserido");
		this.empregado = new Empregado();
		return this.index;
	}
	
	//M�todo de altera��o dos dados do Empregado atr�ves do ManagedBean
	//OBS: prov�vel que haja problema com o Hibernate nesse m�todo, por causa da passagem do objeto completo, incluindo o id (o que pode dar conflito), ou n�o.
	public String alterar() {
		this.empregadoService.alterarEmpregado(this.empregado);
		System.out.println("Empregado Alterado");
		this.empregado = new Empregado();
		return this.index;
	}
	
	//M�todo de listagem de todos os dados dos Empregados atr�ves do ManagedBean
	public String listarTudo() {
		this.listaEmpregados = this.empregadoService.listarTudo();
		System.out.println("Empregados na lista");
		return this.index;
	}
	
	//M�todo de listagem da busca dos dados dos Empregados atr�ves de um filtro de pesquisa da tela
	//Usar o campo de busca como #{empregadoMB.empregado.nomeCompleto}
	public String buscarPorAtributos() {
		this.listaEmpregados = this.empregadoService.buscarPorAtributos(this.empregado.getNomeCompleto());
		System.out.println("Empregados filtrados na lista");
		return this.index;
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