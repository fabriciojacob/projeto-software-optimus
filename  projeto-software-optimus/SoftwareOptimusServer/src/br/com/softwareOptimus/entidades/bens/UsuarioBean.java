package br.com.softwareOptimus.entidades.bens;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.RN.UsuarioRN;

@ManagedBean(name = "usuarioBean")
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

	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getPassword();
		if (!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage(
					"A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);

		return "usuarioSucesso";
	}

}
