package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.SubGrupo;

public class GrupoDAOHibernate implements GrupoDAO {

	private EntityManager session;
	private EntityTransaction transaction;

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = session.getTransaction();
		if (!transaction.isActive()) {
			transaction.begin();
		}
	}

	@Override
	public void close() throws Exception {
		this.session.close();
	}

	public void salvar(Grupo grupo) {
		this.session.persist(grupo);
		this.transaction.commit();
	}

	public void alterar(Grupo grupo) {
		this.session.merge(grupo);
		this.transaction.commit();

	}

	@Override
	public List<Setor> verificaRemocao(Grupo grupo) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.idGrupo = :grupo";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("grupo", grupo.getIdGrupo());
		return set.getResultList();
	}

	@Override
	public void remover(Grupo grupo) {
		this.session.remove(grupo);
		this.transaction.commit();
	}

	@Override
	public List<Grupo> consultaId(long parseLong) {
		String jpql = "Select g From Grupo g Where g.idGrupo = :grupo";
		TypedQuery<Grupo> gru = this.session.createQuery(jpql, Grupo.class);
		gru.setParameter("grupo", parseLong);
		return gru.getResultList();
	}

	@Override
	public List<Grupo> consultaDesc(String busca) {
		String jpql = "Select g From Grupo g Where g.descricao LIKE :grupo";
		TypedQuery<Grupo> gru = this.session.createQuery(jpql, Grupo.class);
		gru.setParameter("grupo", "%" + busca + "%");
		return gru.getResultList();
	}

	@Override
	public List<Grupo> lista() {
		String jpql = "Select g From Grupo g ";
		TypedQuery<Grupo> gru = this.session.createQuery(jpql, Grupo.class);
		return gru.getResultList();
	}

	@Override
	public Grupo editGrupo(Long id) {
		Grupo gru = this.session.find(Grupo.class, id);
		return gru;
	}

	@Override
	public List<Grupo> listaGrupo() {
		String jpql = "Select g From Grupo g ";
		TypedQuery<Grupo> gru = this.session.createQuery(jpql,
				Grupo.class);
		return gru.getResultList();
	}

	@Override
	public List<Produto> VerificaRemGrupoProd(Grupo grupo) {
		String jpql = "select p from Produto p where p.grupo = :grupo";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("grupo", grupo);
		return prod.getResultList();
	}

	@Override
	public List<Produto> verificaRemSubGrupo(Grupo grupo, Long idSub) {
		SubGrupo subGru = this.session.find(SubGrupo.class, idSub);		
		String jpql = "select p from Produto p where p.grupo = :grupo and p.subGrupo = :subGru";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("grupo", grupo);
		prod.setParameter("subGru", subGru);
		return prod.getResultList();
	}
}
