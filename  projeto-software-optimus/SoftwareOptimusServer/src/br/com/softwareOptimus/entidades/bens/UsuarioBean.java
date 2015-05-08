package br.com.softwareOptimus.entidades.bens;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.RN.UsuarioRN;
import br.com.softwareOptimus.util.FacesUtil;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean extends FacesUtil implements Serializable {
	
    private static final long serialVersionUID = -3280128356907200060L;
 
	private Usuario usuario;
	private String confirmarSenha;
	UsuarioRN usuarioRN;

	public Usuario getUsuario() {
		if(this.usuario == null){
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public UsuarioRN getUsuarioRN() {
		if(this.usuarioRN == null){
			this.usuarioRN = new UsuarioRN();
		}
		return usuarioRN;
	}

	public void setUsuarioRN(UsuarioRN usuarioRN) {
		this.usuarioRN = usuarioRN;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		if(this.confirmarSenha == null){
			this.confirmarSenha = new String();
		}
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String novo() {
		this.setUsuario(null);
		this.getUsuario().setAtivo(true);
		return "usuario";
	}
	
	public void cancelar(){
		this.setUsuario(null);
	}

	public void salvar() {

		String senha = this.getUsuario().getPassword();
		if (!senha.equals(this.getConfirmarSenha())) {
			this.warm("A senha nao foi confirmada corretamente");
		}
		
		if (senha.equals(this.getConfirmarSenha())) {
			try {
				this.getUsuarioRN().salvar(this.getUsuario());
				this.info("Usuario salvo com sucesso");
			} catch (Exception ex) {
				this.error("Problemas na gravacao do usuario " + ex.getMessage());
			}
		}
	}

}
