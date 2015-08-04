package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.FiguraFiscal;
import br.com.softwareOptimus.fiscal.GradeTributaria;
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
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.persist(figura);
		this.transaction.commit();
	}

	@Override
	public void altFigura(FiguraFiscal figura) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.merge(figura);
		this.transaction.commit();
	}

	@Override
	public void remover(FiguraFiscal figura) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.remove(figura);
		this.transaction.commit();
	}

	@Override
	public List<FiguraFiscal> consultaId(long id) {
		String jpql = "Select f From FiguraFiscal f Where f.idFigura = :id ";
		TypedQuery<FiguraFiscal> figura = this.session.createQuery(jpql,FiguraFiscal.class);
		figura.setParameter("id", id);
		return figura.getResultList();
	}

	@Override
	public List<FiguraFiscal> consultaDesc(String desc) {
		String jpql = "Select f From FiguraFiscal f Where f.descricao LIKE :desc";
		TypedQuery<FiguraFiscal> listaFigura = this.session.createQuery(jpql,FiguraFiscal.class);
		listaFigura.setParameter("desc", "%" + desc + "%");
		return listaFigura.getResultList();
	}

	@Override
	public List<FiguraFiscal> listar() {
		String jpql = "Select f From FiguraFiscal f";
		TypedQuery<FiguraFiscal> listaFigura = this.session.createQuery(jpql,FiguraFiscal.class);
		return listaFigura.getResultList();
	}

	@Override
	public FiguraFiscal editFigura(Long id) {
		String jpql = "Select f From FiguraFiscal f Where f.idFigura = :id ";
		TypedQuery<FiguraFiscal> figura = this.session.createQuery(jpql,FiguraFiscal.class);
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

	@Override
	public int countFiguraFiscalPaginacao(FiguraFiscal figuraFiscal,GradeTributaria gradeTributaria) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, figuraFiscal, gradeTributaria);
		Query qryMaximo = this.session.createQuery(" select Count(f) from FiguraFiscal f "
				 								 + " left join f.grades g ".concat(sql.toString()));
		this.defineParametros(qryMaximo, figuraFiscal, gradeTributaria);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FiguraFiscal> buscaFiguraFiscalPaginacao(FiguraFiscal figuraFiscal, GradeTributaria gradeTributaria,int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, figuraFiscal, gradeTributaria);
		Query qry = this.session.createQuery("select f from FiguraFiscal f "
										   + " left join f.grades g ".concat(sql.toString()));
		this.defineParametros(qry, figuraFiscal, gradeTributaria);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<FiguraFiscal> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, FiguraFiscal figuraFiscal, GradeTributaria gradeTributaria){
 		if(figuraFiscal.getIdFigura() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" f.idFigura = :idFigura");
		}
 		if(figuraFiscal.getDescricao() != null && figuraFiscal.getDescricao() != "" && !figuraFiscal.getDescricao().equals("")){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" f.descricao like :descricao");
 		}
 		if(gradeTributaria.getIdGradeTrib() != null){
 			sql.append(sql.length() == 0 ? " where ": " and ").append(" g.idGradeTrib = :idGradeTrib");
 		}
	}
	
	@Override
	public void defineParametros(Query qry, FiguraFiscal figuraFiscal, GradeTributaria gradeTributaria){
 		if(figuraFiscal.getIdFigura() != null){
 			qry.setParameter("idFigura", figuraFiscal.getIdFigura());
		}
 		if(figuraFiscal.getDescricao() != null && figuraFiscal.getDescricao() != "" && !figuraFiscal.getDescricao().equals("")){
 			qry.setParameter("descricao", "%" + figuraFiscal.getDescricao() + "%");
 		}
 		if(gradeTributaria.getIdGradeTrib() != null){
 			qry.setParameter("idGradeTrib", gradeTributaria.getIdGradeTrib());
 		}
	}
}
