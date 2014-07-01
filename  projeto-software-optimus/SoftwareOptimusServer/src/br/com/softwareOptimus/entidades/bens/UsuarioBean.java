package br.com.softwareOptimus.entidades.bens;

import javax.faces.bean.ManagedBean;

import br.com.softwareOptimus.entidades.Usuario;


@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	private String confirmarSenha;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	public String salvar(){
		
		
		return "usuarioSucesso";
	}

}
