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

	public void salvar() {
		
		String senha = this.usuario.getPassword();
		if (!senha.equals(this.confirmarSenha)) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Info",
							"A senha não foi confirmada corretamente"));
		}

		try {
			UsuarioRN usuarioRN = new UsuarioRN();
			usuarioRN.salvar(this.usuario);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Info",
							"Usuário salvo com sucesso"));
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Problemas na gravação do usuário "
									+ ex.getMessage()));
		}

	}

}
