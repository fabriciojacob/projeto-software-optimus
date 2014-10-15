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

public class SetorDAOHibernate implements SetorDAO {
	
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

	@Override
	public void salvar(Setor setor) {
		this.session.persist(setor);
		this.transaction.commit();
	}

	@Override
	public void altSet(Setor setor) {
		this.session.merge(setor);
		this.transaction.commit();
	}

	@Override
	public List<Produto> verProdSet(Setor setor) {
		String jpql = "select p from Produto p where p.setor = :setor";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("setor", setor);
		return prod.getResultList();
	}

	@Override
	public void remove(Setor setor) {
		this.session.remove(setor);
		this.transaction.commit();
	}

	@Override
	public List<Setor> listar() {
		String jpql = "select s from Setor s";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaId(long setor) {
		String jpql = "Select s from Setor s where s.idSetor = :setor";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("setor", setor);
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaDesc(String setor) {
		String jpql = "Select s from Setor s where s.descricao LIKE :setor";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("setor","%" +  setor + "%");
		return set.getResultList();
	}

	@Override
	public List<Produto> verRemRelGrup(Setor setor, Long idGrup) {
		Grupo grupo = this.session.find(Grupo.class, idGrup);		
		String jpql = "select p from Produto p where p.setor = :setor and p.grupo = :grupo";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("setor", setor);
		prod.setParameter("grupo", grupo);
		return prod.getResultList();
	}

	@Override
	public Setor editSet(Long id) {
		Setor set = this.session.find(Setor.class, id);
		return set;
	}

	@Override
	public List<Setor> consultaDescGrup(String busca) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.descricao LIKE :busca";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("busca", "%" + busca + "%");
		return set.getResultList();
	}

	@Override
	public List<Setor> consultaIdGrup(long idGrup) {
		String jpql = "Select Distinct s From Setor s, IN(s.grupo) AS g Where g.idGrupo = :idGrup";
		TypedQuery<Setor> set = this.session.createQuery(jpql, Setor.class);
		set.setParameter("idGrup", idGrup);
		return set.getResultList();
	}
}
