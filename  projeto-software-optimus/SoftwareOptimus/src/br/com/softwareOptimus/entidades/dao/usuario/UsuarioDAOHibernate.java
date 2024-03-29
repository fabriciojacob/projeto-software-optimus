package br.com.softwareOptimus.entidades.dao.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.softwareOptimus.entidades.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private EntityManager session;

	@Override
	public void salvar(Usuario usuario) {
		this.session.persist(usuario);

	}

	@Override
	public void atualizar(Usuario usuario) {
		this.session.merge(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.remove(usuario);
	}

	@Override
	public Usuario carregar(Long codigo) {
		String jpql = "select e from Usuario e where e.codigo = :codigo";
		Query consulta = this.session.createQuery(jpql, Usuario.class);
		consulta.setParameter("codigo", codigo);
		return (Usuario) consulta.getSingleResult();
	}

	@Override
	public Usuario buscaPorLogin(String login) {
		String jpql = "select u From Usuario where u.login = :login";
		Query consulta = this.session.createQuery(jpql);
		consulta.setParameter("login", login);
		return (Usuario) consulta.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		String jpql = "select u From Usuario";
		Query consulta = this.session.createQuery(jpql);
		return consulta.getResultList();
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

}
