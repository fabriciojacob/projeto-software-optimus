package br.com.softwareOptimus.dao.fiscal;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.CodTabelaGov;
import br.com.softwareOptimus.fiscal.TipoProduto;
import br.com.softwareOptimus.util.JpaUtil;

public class CodTabelaGovDAOHibernate extends JpaUtil implements CodTabelaGovDAO {
	
	@Override
	public List<CodTabelaGov> listaVig(TipoProduto tipo) {
		String jpql = "Select c from CodTabelaGov c where c.tipoProduto = :tipo";
		TypedQuery<CodTabelaGov> consulta = getEntityManager().createQuery(jpql, CodTabelaGov.class);
		consulta.setParameter("tipo", tipo);
		return consulta.getResultList();
	}
	@Override
	public void remover(Long idVig) {
		beginTransaction();
		CodTabelaGov tipoVig = getEntityManager().find(CodTabelaGov.class, idVig);
		getEntityManager().remove(tipoVig);
		commitTransaction();
	}
	@Override
	public void salvar(CodTabelaGov tbGov) {
		beginTransaction();
		getEntityManager().persist(tbGov);
		commitTransaction();
	}
	@Override
	public CodTabelaGov editVig(Long idVig) {
		String jpql = "Select c from CodTabelaGov c Where c.idCodGov = :idVig";
		TypedQuery<CodTabelaGov> consulta = getEntityManager().createQuery(jpql, CodTabelaGov.class);
		consulta.setParameter("idVig", idVig);
		return consulta.getSingleResult();
	}
	@Override
	public void salvaVig2(CodTabelaGov tbGov) {
		beginTransaction();
		getEntityManager().merge(tbGov);
		commitTransaction();
	}

}
