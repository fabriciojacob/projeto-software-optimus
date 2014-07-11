package br.com.softwareOptimus.entidades.bens;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.RN.UsuarioRN;

@ManagedBean(name = "loginBean")
public class LoginBean {

	public String login(Usuario usuario) {
		int check;
		UsuarioRN usuarioRN = new UsuarioRN();
		check = usuarioRN.buscarPorLogin(usuario.getLogin(),
				usuario.getPassword());
		if (check == 1) {
			return "/privado/menu.xhtml";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info",
							"Dados incorretos"));
			return null;
		}

	}

}