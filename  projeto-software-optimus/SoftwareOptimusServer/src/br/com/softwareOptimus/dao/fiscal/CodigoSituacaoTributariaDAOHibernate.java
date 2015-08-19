package br.com.softwareOptimus.dao.fiscal;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.fiscal.CodigoSituacaoTributaria;
import br.com.softwareOptimus.fiscal.IO;
import br.com.softwareOptimus.fiscal.TipoCst;
import br.com.softwareOptimus.util.JpaUtil;

public class CodigoSituacaoTributariaDAOHibernate extends JpaUtil implements CodigoSituacaoTributariaDAO {

	@Override
	public List<CodigoSituacaoTributaria> cstListaIcms() {
		String jpql = "Select u From CodigoSituacaoTributaria u Where u.tipoCst = :icms";
		TypedQuery<CodigoSituacaoTributaria> listaCst = getEntityManager()
				.createQuery(jpql, CodigoSituacaoTributaria.class);
		listaCst.setParameter("icms", TipoCst.ICMS.ordinal());
		return listaCst.getResultList();
	}

	@Override
	public List<CodigoSituacaoTributaria> cstListaOut(TipoCst tipo, IO entSai) {
		String jpql = "Select u From CodigoSituacaoTributaria u Where u.tipoCst = :tipo And u.io = :entSai";
		TypedQuery<CodigoSituacaoTributaria> listaCstEnt = getEntityManager()
				.createQuery(jpql, CodigoSituacaoTributaria.class);
		listaCstEnt.setParameter("tipo", tipo.ordinal());
		listaCstEnt.setParameter("entSai", entSai.ordinal());
		return listaCstEnt.getResultList();
	}
}
