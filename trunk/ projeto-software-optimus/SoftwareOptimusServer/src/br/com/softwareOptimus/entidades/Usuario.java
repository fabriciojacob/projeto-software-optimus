package br.com.softwareOptimus.entidades;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.softwareOptimus.comercial.Requisicao;



@Entity
@Table(name="tbUsuario")
public class Usuario {

	@Id
	@GeneratedValue
	private Long idUsuario;
	
	private String Nome;
	
	private String Senha;
	
	private String Email;
	
	//public Void UsuarioView(Long idUsuario, String Nome){
	//	this.idUsuario = idUsuario;
	//	this.Nome = Nome;
	//	return null;
	//}
	
	public void setEmail(String email) {
		Email = email;
	}

	@OneToMany(mappedBy ="UsuRequisita")
	private Collection<Requisicao> requisicao;	

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getEmail() {
		return Email;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idUsuario == null) ? 0 : idUsuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
}
