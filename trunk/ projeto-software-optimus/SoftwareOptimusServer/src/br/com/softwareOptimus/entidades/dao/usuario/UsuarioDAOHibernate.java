package br.com.softwareOptimus.entidades.dao.usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import br.com.softwareOptimus.entidades.Usuario;
import br.com.softwareOptimus.util.JpaUtil;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private EntityManager session;
	private EntityTransaction transaction;

	@Override
	public void salvar(Usuario usuario) {
		this.session.persist(usuario);
		this.transaction.commit();

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
		String jpql = "select u From Usuario u where u.login = :login";
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

	public void begin() throws IOException, SQLException {

		this.transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}
	}

}
