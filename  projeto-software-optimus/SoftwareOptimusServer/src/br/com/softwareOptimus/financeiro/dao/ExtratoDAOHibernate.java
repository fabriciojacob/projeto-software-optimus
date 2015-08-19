package br.com.softwareOptimus.financeiro.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Caixa;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.Extrato;
import br.com.softwareOptimus.util.JpaUtil;

public class ExtratoDAOHibernate extends JpaUtil implements ExtratoDAO {

	@Override
	public void inclusao(Extrato extrato) throws Exception {
		beginTransaction();
		getEntityManager().persist(extrato);
		commitTransaction();
	}

	@Override
	public Double saldoReg(ContaBancaria contaBancaria, Caixa caixa) throws Exception {
		String jpql = "Select t.saldo from Extrato t "
				+ " where t.idExtrato = (select max(t2.idExtrato) "
				+ " from Extrato t2"
				+ "  where t2.contaBancaria = :parConta or t2.caixa = :parCaixa) ";
		TypedQuery<Double> consulta = getEntityManager()
				.createQuery(jpql, Double.class);
		consulta.setParameter("parConta", contaBancaria);
		consulta.setParameter("parCaixa", caixa);
		return consulta.getSingleResult();
	}

	@Override
	public List<Extrato> pesquisaExtrato(Date dataIni, Date dataFim, ContaBancaria conta, Caixa caixa) throws Exception {
		getEntityManager().clear();

		String jpql = "Select e From Extrato e "
				+ " where e.data between :parDataIni and :parDataFim"
				+ " and e.contaBancaria  = :parContaBancaria"
				+ " or e.caixa = :parCaixa ";

		TypedQuery<Extrato> consulta = getEntityManager().createQuery(jpql,
				Extrato.class);
		consulta.setParameter("parDataIni", dataIni);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parCaixa", caixa);
		consulta.setParameter("parContaBancaria", conta);
		return consulta.getResultList();
	}
}
