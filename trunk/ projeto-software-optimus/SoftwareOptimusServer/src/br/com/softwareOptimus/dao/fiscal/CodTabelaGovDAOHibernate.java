package br.com.softwareOptimus.dao.fiscal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;



public class CodTabelaGovDAOHibernate implements CodTabelaGovDAO {
	
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
	public List<CodTabelaGov> listaVig(TipoProduto tipo) {
		String jpql = "Select c from CodTabelaGov c where c.tipoProduto = :tipo";
		TypedQuery<CodTabelaGov> consulta = this.session
				.createQuery(jpql, CodTabelaGov.class);
		consulta.setParameter("tipo", tipo);
		return consulta.getResultList();
	}
	@Override
	public void remover(Long idVig) {
		CodTabelaGov tipoVig = this.session.find(
				CodTabelaGov.class, idVig);
		this.session.remove(tipoVig);
		this.transaction.commit();
	}
	@Override
	public void salvar(CodTabelaGov tbGov) {
		this.session.persist(tbGov);
		this.transaction.commit();
	}
	@Override
	public CodTabelaGov editVig(Long idVig) {
		String jpql = "Select c from CodTabelaGov c Where c.idCodGov = :idVig";
		TypedQuery<CodTabelaGov> consulta = this.session.createQuery(jpql, CodTabelaGov.class);
		consulta.setParameter("idVig", idVig);
		return consulta.getSingleResult();
	}
	@Override
	public void salvaVig2(CodTabelaGov tbGov) {
		this.session.merge(tbGov);
		this.transaction.commit();
	}

}
