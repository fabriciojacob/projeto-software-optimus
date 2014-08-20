package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.Pauta;

public class PautaDAOHibernate implements PautaDAO {
	
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
	public void salvar(Pauta pauta) {
		this.session.persist(pauta);
		this.transaction.commit();
	}
	
	@Override
	public List<Pauta> consultaDesc(String desc) {
		String jpql = "Select p From Pauta p Where p.descricao LIKE :desc";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		listaPauta.setParameter("desc", "%" + desc + "%");
		return listaPauta.getResultList();
	}
	
	public List<Pauta> consulta() {
		String jpql = "Select p From Pauta p ";
		TypedQuery<Pauta> listaPauta = this.session.createQuery(jpql,
				Pauta.class);
		return listaPauta.getResultList();
	}

	@Override
	public Pauta consultaId(Long id) {
		String jpql = "Select p From Pauta p Where p.idPauta = :id ";
		TypedQuery<Pauta> Pauta = this.session.createQuery(jpql,
				Pauta.class);
		Pauta.setParameter("id", id);
		return Pauta.getSingleResult();
	}
	@Override
	public void alterar(Pauta pauta) {
		this.session.merge(pauta);
		this.transaction.commit();
	}
	@Override
	public void remover(Pauta pauta) {
		//this.session.c
		this.transaction.commit();
	}
}
