package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.produto.Produto;

public class FiguralFiscalDAOHibernate implements FiguraFiscalDAO {
	
	private EntityManager session;
	private EntityTransaction transaction;
	
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
	public void salva(FiguraFiscal figura) {
		this.session.persist(figura);
		this.transaction.commit();
	}

	@Override
	public void altFigura(FiguraFiscal figura) {
		this.session.merge(figura);
		this.transaction.commit();
	}

	@Override
	public void remover(FiguraFiscal figura) {
		this.session.remove(figura);
		this.transaction.commit();
	}

	@Override
	public List<FiguraFiscal> consultaId(long id) {
		String jpql = "Select f From FiguraFiscal f Where f.idFigura = :id ";
		TypedQuery<FiguraFiscal> figura = this.session.createQuery(jpql,
				FiguraFiscal.class);
		figura.setParameter("id", id);
		return figura.getResultList();
	}

	@Override
	public List<FiguraFiscal> consultaDesc(String desc) {
		String jpql = "Select f From FiguraFiscal f Where f.descricao LIKE :desc";
		TypedQuery<FiguraFiscal> listaFigura = this.session.createQuery(jpql,
				FiguraFiscal.class);
		listaFigura.setParameter("desc", "%" + desc + "%");
		return listaFigura.getResultList();
	}

	@Override
	public List<FiguraFiscal> listar() {
		String jpql = "Select f From FiguraFiscal f";
		TypedQuery<FiguraFiscal> listaFigura = this.session.createQuery(jpql,
				FiguraFiscal.class);
		return listaFigura.getResultList();
	}

	@Override
	public FiguraFiscal editFigura(Long id) {
		String jpql = "Select f From FiguraFiscal f Where f.idFigura = :id ";
		TypedQuery<FiguraFiscal> figura = this.session.createQuery(jpql,
				FiguraFiscal.class);
		figura.setParameter("id", id);
		return figura.getSingleResult();
	}

	@Override
	public List<Produto> verificaRemocao(FiguraFiscal figura) {
		String jpql = "select p from Produto p where p.figura = :figura";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("figura", figura);
		return prod.getResultList();
	}
}
