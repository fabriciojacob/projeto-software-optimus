package br.com.softwareOptimus.entidades.dao.usuario;

import java.util.List;

import br.com.softwareOptimus.entidades.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario carregar(Long codigo);
	public Usuario buscaPorLogin(String login, String senha) throws Exception;
	public List<Usuario> listar();

}
