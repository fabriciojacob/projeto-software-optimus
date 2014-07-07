package br.com.softwareOptimus.entidades.RN;

import java.util.List;

import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAO;
import br.com.softwareOptimus.entidades.dao.usuario.UsuarioDAOHibernate;
import br.com.softwareOptimus.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criaUsuarioDAO();
	}
	
	public Usuario carregar(Long codigo){
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login){
		return this.usuarioDAO.buscaPorLogin(login);
	}
	
	public void salvar(Usuario usuario){
		Long codigo = usuario.getIdUsuario();
		if(codigo == null || codigo == 0){
			this.usuarioDAO.salvar(usuario);
		}else{
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario){
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar(){
		return this.usuarioDAO.listar();
	}

}
