package br.com.softwareOptimus.entidades.bens;

import javax.faces.bean.ManagedBean;

import br.com.softwareOptimus.entidades.Usuario;


@ManagedBean(name="usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
