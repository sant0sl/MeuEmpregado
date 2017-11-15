package com.meuempregado.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 3325543356230603111L;
	
	private Integer id;
	private Long idFacebook;
	private Empregador empregador;
	private Empregado empregado;
	private TipoUsuario tipoUsuario;
	private String nomeCompleto;
	private String email;
	private String senha;
	private String foto;
	
	//Construtor vazio
	public Usuario(){
		
	}

	//Construtor qualificado
	public Usuario(Integer id, Long idFacebook, Empregador empregador, Empregado empregado, TipoUsuario tipoUsuario,
			String nomeCompleto, String email, String senha, String foto) {
		super();
		this.id = id;
		this.idFacebook = idFacebook;
		this.empregador = empregador;
		this.empregado = empregado;
		this.tipoUsuario = tipoUsuario;
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}

	// Getters and setters

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	@OneToOne
	public Empregador getEmpregador() {
		return empregador == null ? new Empregador() : empregador;
	}

	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}

	@OneToOne
	public Empregado getEmpregado() {
		return empregado == null ? new Empregado() : empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	@Enumerated
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Long getIdFacebook() {
		return idFacebook;
	}

	public void setIdFacebook(Long idFacebook) {
		this.idFacebook = idFacebook;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public TipoUsuario[] getTiposUsuarios() {
		return TipoUsuario.values();
	}

	// hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// equals personalizado
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
