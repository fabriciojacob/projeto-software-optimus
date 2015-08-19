package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Banco;
import br.com.softwareOptimus.util.JpaUtil;

public class BancoDAOHibernate extends JpaUtil implements BancoDAO{
	
	@Override
	public List<Banco> pesquisa() throws Exception {
		String jpql = "Select c from Banco c";
		TypedQuery<Banco> consulta = getEntityManager().createQuery(jpql,Banco.class);
		return consulta.getResultList();
	}

	@Override
	public Banco banco(String id) throws Exception {
		return getEntityManager().find(Banco.class, id);
	}
}
