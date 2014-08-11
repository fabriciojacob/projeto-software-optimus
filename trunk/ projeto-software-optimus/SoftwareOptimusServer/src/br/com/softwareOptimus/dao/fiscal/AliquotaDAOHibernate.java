package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.Aliquota;

public class AliquotaDAOHibernate implements AliquotaDAO {

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
	public void altAliq(Aliquota aliquota) throws Exception {
		this.session.merge(aliquota);
		this.transaction.commit();
	}

	@Override
	public Aliquota editBusc(Long id) {
		String jpql = "Select a From Aliquota a Where a.idAliq = :id ";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("id", id);
		return listaAliquota.getSingleResult();
	}

	@Override
	public void remover(Long id) throws Exception {
		Aliquota aliq = this.session.find(Aliquota.class, id);
		this.session.remove(aliq);
		this.transaction.commit();
	}

	@Override
	public List<Aliquota> lista() {
		String jpql = "Select a From Aliquota a";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		return listaAliquota.getResultList();
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
	public void salva(Aliquota aliquota) throws Exception {
		this.session.persist(aliquota);
		this.transaction.commit();
	}

	@Override
	public List<Aliquota> consultaId(long id) {
		String jpql = "Select a From Aliquota a Where a.idAliq = :id ";
		TypedQuery<Aliquota> listaUnidade = this.session.createQuery(jpql,
				Aliquota.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getResultList();
	}

	@Override
	public List<Aliquota> consultaAliq(Double aliquota) {
		Double minimo, maximo;
		minimo = aliquota - 2;
		maximo = aliquota + 2;
		String jpql = "Select a From Aliquota a Where a.aliquota BETWEEN :minimo And :maximo";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("minimo", minimo);
		listaAliquota.setParameter("maximo", maximo);
		return listaAliquota.getResultList();
	}

	@Override
	public List<Aliquota> consultaRed(Double reducao) {
		Double minimo, maximo;
		minimo = reducao - 10;
		maximo = reducao + 10;
		String jpql = "Select a From Aliquota a Where a.reducao BETWEEN :minimo And :maximo";
		TypedQuery<Aliquota> listaAliquota = this.session.createQuery(jpql,
				Aliquota.class);
		listaAliquota.setParameter("minimo", minimo);
		listaAliquota.setParameter("maximo", maximo);
		return listaAliquota.getResultList();
	}
}
