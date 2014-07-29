package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.produto.UnidMed;

public class UnidMedDAOHibernate implements UnidMedDAO {

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
	public void salvar(UnidMed unid) {
		this.session.persist(unid);
		this.transaction.commit();
	}
	
	public void remover(Long unid) throws Exception{
		UnidMed unidMed = this.session.find(UnidMed.class, unid);
		this.session.remove(unidMed);
		this.transaction.commit();
	}

	public List<UnidMed> consultarId(Long id) {
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarUnid(String unid) {
		String jpql = "Select u From UnidMed u Where u.unid LIKE :unid";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("unid", "%" + unid + "%");
		return listaUnidade.getResultList();
	}

	public List<UnidMed> consultarDesc(String desc) {
		String jpql = "Select u From UnidMed u Where u.descUnid LIKE :desc";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("desc", "%" + desc + "%");
		return listaUnidade.getResultList();
	}
	
	public List<UnidMed> lista() {
		String jpql = "Select u From UnidMed u";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		return listaUnidade.getResultList();
	}
	
	public UnidMed editBusc(Long id){
		String jpql = "Select u From UnidMed u Where u.idUnidMed = :id ";
		TypedQuery<UnidMed> listaUnidade = this.session.createQuery(jpql,
				UnidMed.class);
		listaUnidade.setParameter("id", id);
		return listaUnidade.getSingleResult();
	}
	
	public void altUnid(UnidMed unidMed) throws Exception{
		this.session.merge(unidMed);
		this.transaction.commit();
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
}
