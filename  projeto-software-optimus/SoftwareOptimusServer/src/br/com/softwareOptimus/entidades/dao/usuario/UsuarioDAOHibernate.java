package br.com.softwareOptimus.entidades.dao.usuario;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.util.JpaUtil;

public class UsuarioDAOHibernate extends JpaUtil implements UsuarioDAO {

	@Override
	public void salvar(Usuario usuario) {
		beginTransaction();
		usuario.setAtivo(true);
		getEntityManager().persist(usuario);
		commitTransaction();

	}

	@Override
	public void atualizar(Usuario usuario) {
		beginTransaction();
		getEntityManager().merge(usuario);
		commitTransaction();
	}

	@Override
	public void excluir(Usuario usuario) {
		beginTransaction();
		getEntityManager().remove(usuario);
		commitTransaction();
	}

	@Override
	public Usuario carregar(Long codigo) {
		String jpql = "select e from Usuario e where e.idUsuario = :codigo";
		TypedQuery<Usuario> consulta = getEntityManager().createQuery(jpql, Usuario.class);
		consulta.setParameter("codigo", codigo);
		return consulta.getSingleResult();
	}

	@Override
	public Usuario buscaPorLogin(String login, String senha) throws Exception {
		String jpql = "select u From Usuario u where u.login = :login"
				+ " and u.password = :senha";
		TypedQuery<Usuario> consulta = getEntityManager().createQuery(jpql,
				Usuario.class);
		consulta.setParameter("login", login);
		consulta.setParameter("senha", senha);
		return consulta.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		String jpql = "select u From Usuario";
		Query consulta = getEntityManager().createQuery(jpql);
		return consulta.getResultList();
	}

	@Override
	public List<Usuario> pesquisaNome(String nome) throws Exception {
		String sql = "Select e from Usuario e where e.nome like '%" + nome + "%'";
		TypedQuery<Usuario> listaUsuario = getEntityManager().createQuery(sql,
				Usuario.class);
		return listaUsuario.getResultList();
	}

}
