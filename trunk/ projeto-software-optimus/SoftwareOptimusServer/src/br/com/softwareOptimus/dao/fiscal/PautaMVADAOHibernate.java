package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.Pauta;
import br.com.softwareOptimus.fiscal.PautaMVA;

public class PautaMVADAOHibernate implements PautaMVADAO {

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
	public void salva(PautaMVA pauta) {
		this.session.persist(pauta);
		this.transaction.commit();
	}

	@Override
	public void alterar(PautaMVA pauta) {
		this.session.merge(pauta);
		this.transaction.commit();
	}

	@Override
	public void remover(PautaMVA pauta) {
		this.session.remove(pauta);
		this.transaction.commit();
	}

	@Override
	public List<PautaMVA> lista() {
		String jpql = "Select p From PautaMVA p";
		TypedQuery<PautaMVA> listaPauta = this.session.createQuery(jpql,
				PautaMVA.class);
		return listaPauta.getResultList();
	}

	@Override
	public List<PautaMVA> consultaId(long id) {
		String jpql = "Select p From PautaMVA p Where p.idPautaMVA = :id ";
		TypedQuery<PautaMVA> listaPauta = this.session.createQuery(jpql,
				PautaMVA.class);
		listaPauta.setParameter("id", id);
		return listaPauta.getResultList();
	}

	@Override
	public List<PautaMVA> consultaDesc(String desc) {
		String jpql = "Select p From PautaMVA p Where p.descricao LIKE :desc";
		TypedQuery<PautaMVA> listaPauta = this.session.createQuery(jpql,
				PautaMVA.class);
		listaPauta.setParameter("desc", "%" + desc + "%");
		return listaPauta.getResultList();
	}

	@Override
	public List<PautaMVA> consultaValP(double valP) {
		Double minimo, maximo;
		minimo = valP - 0.5;
		maximo = valP + 0.5;
		String jpql = "Select p From PautaMVA p Where p.valorPauta BETWEEN :minimo And :maximo";
		TypedQuery<PautaMVA> listaPauta = this.session.createQuery(jpql,
				PautaMVA.class);
		listaPauta.setParameter("minimo", minimo);
		listaPauta.setParameter("maximo", maximo);
		return listaPauta.getResultList();
	}

	@Override
	public List<PautaMVA> consultaMva(double valMva) {
		Double minimo, maximo;
		minimo = valMva - 0.5;
		maximo = valMva + 0.5;
		String jpql = "Select p From PautaMVA p Where p.valorMVa BETWEEN :minimo And :maximo";
		TypedQuery<PautaMVA> listaPauta = this.session.createQuery(jpql,
				PautaMVA.class);
		listaPauta.setParameter("minimo", minimo);
		listaPauta.setParameter("maximo", maximo);
		return listaPauta.getResultList();
	}

	@Override
	public PautaMVA editPauta(Long id) {
		String jpql = "Select p From PautaMVA p Where p.idPautaMVA = :id ";
		TypedQuery<PautaMVA> Pauta = this.session.createQuery(jpql,
				PautaMVA.class);
		Pauta.setParameter("id", id);
		return Pauta.getSingleResult();
	}

	@Override
	public List<PautaMVA> listar(Pauta pauta) throws Exception {
		String jpql = "Select p from PautaMVA p where p.pauta = :parPauta";
		TypedQuery<PautaMVA> consulta = this.session.createQuery(jpql,
				PautaMVA.class);
		consulta.setParameter("parPauta", pauta);
		return consulta.getResultList();
	}
}
