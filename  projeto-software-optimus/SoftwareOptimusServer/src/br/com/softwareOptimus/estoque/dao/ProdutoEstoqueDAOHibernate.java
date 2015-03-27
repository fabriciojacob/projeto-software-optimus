package br.com.softwareOptimus.estoque.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.estoque.ProdutoEstoque;

public class ProdutoEstoqueDAOHibernate implements ProdutoEstoqueDAO{
	
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> retCustoMedioProduto(ProdutoEstoque produtoEstoque) {
		Calendar dataHoje = Calendar.getInstance();
		
		String jpql = "Select max(p.data), p.custoMedio From ProdutoEstoque p "
				   + " where p.empresa = :empresa " 
				   + " and p.produto = :produto "
				   + " and p.data <= :dataHoje "
				   + " and p.tipoMovEst = :compra ";
		Query qry = this.session.createQuery(jpql);
		qry.setParameter("empresa", produtoEstoque.getEmpresa());
		qry.setParameter("produto", produtoEstoque.getProduto());
		qry.setParameter("dataHoje", dataHoje.DATE);
		qry.setParameter("compra", TipoMovEst.COMPRA);
		
		List<Object[]> result = qry.getResultList();
	
		return result;
	}

}
