package br.com.softwareOptimus.dao.fiscal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.Ncm;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.produto.Produto;

public class TipoProdutoDAOHibernate implements TipoProdutoDAO {

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
	public void salva(TipoProduto tipo) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.persist(tipo);
		this.transaction.commit();
	}

	@Override
	public void altTipo(TipoProduto tipo) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		this.session.merge(tipo);
		this.transaction.commit();
	}

	@Override
	public void remover(TipoProduto tipo) {
		if (!transaction.isActive()) {
			transaction.begin();
		}
		String deleteQuery = "delete from CodTabelaGov c where c.tipoProduto = :tipo";
		Query query = session.createQuery(deleteQuery);
		query.setParameter("tipo", tipo);
		query.executeUpdate();
		this.session.remove(tipo);
		this.transaction.commit();
	}

	@Override
	public List<TipoProduto> lista() {
		String jpql = "select t from TipoProduto t";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql,
				TipoProduto.class);
		return tipo.getResultList();
	}

	@Override
	public List<TipoProduto> consultaId(long id) {
		String jpql = "select t from TipoProduto t where t.idTipoProd = :id";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql,
				TipoProduto.class);
		tipo.setParameter("id", id);
		return tipo.getResultList();
	}

	@Override
	public List<TipoProduto> consultaDesc(String busca) {
		String jpql = "select t from TipoProduto t where t.descricao LIKE :desc";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql,TipoProduto.class);
		tipo.setParameter("desc", "%" + busca + "%");
		return tipo.getResultList();
	}

	@Override
	public TipoProduto editaTipo(Long id) {
		String jpql = "select t from TipoProduto t where t.idTipoProd = :id";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql,TipoProduto.class);
		tipo.setParameter("id", id);
		return tipo.getSingleResult();
	}

	@Override
	public List<Produto> verificaRemocao(TipoProduto tipo) {
		String jpql = "select p from Produto p where p.tipoProd = :tipo";
		TypedQuery<Produto> prod = this.session.createQuery(jpql, Produto.class);
		prod.setParameter("tipo", tipo);
		return prod.getResultList();
	}

	@Override
	public List<Ncm> consultaNCMCod(String busca) {
		String jpql = "select n from Ncm n where n.ncm LIKE :ncm";
		TypedQuery<Ncm> ncm = this.session.createQuery(jpql,Ncm.class);
		ncm.setParameter("ncm", "%" + busca + "%");
		return ncm.getResultList();
	}

	@Override
	public List<Ncm> consultaNCMDesc(String busca) {
		String jpql = "select n from Ncm n where n.descricaoNcm LIKE :ncm";
		TypedQuery<Ncm> ncm = this.session.createQuery(jpql,Ncm.class);
		ncm.setParameter("ncm", "%" + busca + "%");
		return ncm.getResultList();
	}

	@Override
	public List<Ncm> consultaNatDesc(String busca) {
		String jpql = "select n from Ncm n where n.descNatRec LIKE :natrec";
		TypedQuery<Ncm> ncm = this.session.createQuery(jpql,Ncm.class);
		ncm.setParameter("natrec", "%" + busca + "%");
		return ncm.getResultList();
	}

	@Override
	public List<Ncm> consultaNatCod(String busca) {
		String jpql = "select n from Ncm n where n.natRec LIKE :natRec";
		TypedQuery<Ncm> ncm = this.session.createQuery(jpql,Ncm.class);
		ncm.setParameter("natRec", "%" + busca + "%");
		return ncm.getResultList();
	}

	@Override
	public List<Ncm> consultaTbDesc(String busca) {
		String jpql = "select n from Ncm n where n.descTabela LIKE :descTabela";
		TypedQuery<Ncm> ncm = this.session.createQuery(jpql,Ncm.class);
		ncm.setParameter("descTabela", "%" + busca + "%");
		return ncm.getResultList();
	}

	@Override
	public Ncm consultaNCMId(Long idNcm) {
		String jpql = "select n from Ncm n where n.idNcm = :idNcm";
		TypedQuery<Ncm> tipo = this.session.createQuery(jpql,Ncm.class);
		tipo.setParameter("idNcm", idNcm);
		return tipo.getSingleResult();
	}

	@Override
	public List<TipoProduto> listarTipoVig() {
		String jpql = "Select t From TipoProduto t where exists (select c from CodTabelaGov c where c.tipoProduto = t)";
		TypedQuery<TipoProduto> listaTipo = this.session.createQuery(jpql,TipoProduto.class);
		return listaTipo.getResultList();
	}

	@Override
	public int countTipoProdutoPaginacao(TipoProduto tipoProd) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, tipoProd);
		Query qryMaximo = this.session.createQuery("select Count(t) from TipoProduto t ".concat(sql.toString()));
		this.defineParametros(qryMaximo, tipoProd);
		Number count = (Number) qryMaximo.getSingleResult();
		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoProduto> buscaTipoProdutoPaginacao(TipoProduto tipoProd,int first, int pageSize) {
		StringBuilder sql = new StringBuilder();
		this.defineCondicao(sql, tipoProd);
		Query qry = this.session.createQuery("select t from TipoProduto t ".concat(sql.toString()));
		this.defineParametros(qry, tipoProd);
		qry.setFirstResult(first);
		qry.setMaxResults(pageSize);
		List<TipoProduto> result = qry.getResultList();
		return result;
	}
	
	@Override
	public void defineCondicao(StringBuilder sql, TipoProduto tipoProd){
		if(tipoProd.getIdTipoProd() != null){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" t.idTipoProd = :idTipoProd");	
		}
		if(tipoProd.getDescricao() != null && !tipoProd.getDescricao().equals("")){
			sql.append(sql.length() == 0 ? " where ": " and ").append(" t.descricao like :descricao");
		}
	}
	
	@Override
	public void defineParametros(Query qry, TipoProduto tipoProd){
		if(tipoProd.getIdTipoProd() != null){
			qry.setParameter("idTipoProd", tipoProd.getIdTipoProd());
		}
		if(tipoProd.getDescricao() != null && !tipoProd.getDescricao().equals("")){
			qry.setParameter("descricao","%" + tipoProd.getDescricao() + "%");
		}
	}
}
