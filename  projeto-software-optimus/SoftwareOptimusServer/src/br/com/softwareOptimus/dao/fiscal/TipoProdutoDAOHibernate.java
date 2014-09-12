package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
		this.session.persist(tipo);
		this.transaction.commit();
	}
	@Override
	public void altTipo(TipoProduto tipo) {
		this.session.merge(tipo);
		this.transaction.commit();
	}
	@Override
	public void remover(TipoProduto tipo) {
		
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
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql, TipoProduto.class);
		return tipo.getResultList();
	}
	@Override
	public List<TipoProduto> consultaId(long id) {
		String jpql = "select t from TipoProduto t where t.idTipoProd = :id";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql, TipoProduto.class);
		tipo.setParameter("id", id);
		return tipo.getResultList();
	}
	@Override
	public List<TipoProduto> consultaDesc(String busca) {
		String jpql = "select t from TipoProduto t where t.descricao LIKE :desc";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql, TipoProduto.class);
		tipo.setParameter("desc", "%" + busca + "%");
		return tipo.getResultList();
	}
	@Override
	public TipoProduto editaTipo(Long id) {
		String jpql = "select t from TipoProduto t where t.idTipoProd = :id";
		TypedQuery<TipoProduto> tipo = this.session.createQuery(jpql, TipoProduto.class);
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
}
