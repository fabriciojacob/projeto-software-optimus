package br.com.softwareOptimus.estoque.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.estoque.ProdutoEstoque;
import br.com.softwareOptimus.estoque.bens.PesquisaEstoquePojo;
import br.com.softwareOptimus.util.JpaUtil;

public class ProdutoEstoqueDAOHibernate extends JpaUtil implements ProdutoEstoqueDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoEstoque> retCustoMedioProduto(ProdutoEstoque produtoEstoque) {
		Calendar data = Calendar.getInstance();
		Date dataHoje = data.getTime();
		String jpql = "Select max(p) From ProdutoEstoque p "
				+ " where p.empresa = :empresa " + " and p.produto = :produto "
				+ " and p.data <= :dataHoje " + " and p.tipoMovEst = :compra "
				+ " order by p.data desc ";
		Query qry = getEntityManager().createQuery(jpql);
		qry.setParameter("empresa", produtoEstoque.getEmpresa());
		qry.setParameter("produto", produtoEstoque.getProduto());
		qry.setParameter("dataHoje", dataHoje);
		qry.setParameter("compra", TipoMovEst.COMPRA.ordinal());

		List<ProdutoEstoque> lista = qry.getResultList();

		return lista;
	}

	@Override
	public void salvarProdEstoque(ProdutoEstoque produtoEstoque,Integer Situacao, Long tipoMovEst) {
		StoredProcedureQuery proc = getEntityManager().createStoredProcedureQuery("pkg_estoque.processaProdutoEstoque");
		proc.registerStoredProcedureParameter("varCustoMedio", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varData", Date.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varJustificativa", String.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varQuantEntrada", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varQuantSaida", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varTipoMovEst", Long.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varProduto", Long.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varEmpresa", Long.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varCustoNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varTotalNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varOrigem", Long.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varPisCofinsNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varFreteNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varIpiNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varIcmsNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varDespesaNota", Double.class,ParameterMode.IN);
		proc.registerStoredProcedureParameter("varSituacao", Integer.class,ParameterMode.IN);

		proc.setParameter("varCustoMedio", produtoEstoque.getCustoMedio());
		proc.setParameter("varData", produtoEstoque.getData());
		proc.setParameter("varJustificativa", produtoEstoque.getJustificativa());
		proc.setParameter("varQuantEntrada", produtoEstoque.getQuantEntrada());
		proc.setParameter("varQuantSaida", produtoEstoque.getQuantSaida());
		proc.setParameter("varTipoMovEst", tipoMovEst);
		proc.setParameter("varProduto", produtoEstoque.getProduto().getIdProduto());
		proc.setParameter("varEmpresa", produtoEstoque.getEmpresa().getIdPessoa());
		proc.setParameter("varCustoNota", produtoEstoque.getCustoNota());
		proc.setParameter("varTotalNota", produtoEstoque.getTotalNota());
		proc.setParameter("varOrigem", produtoEstoque.getOrigem().getIdComercial());
		proc.setParameter("varPisCofinsNota", produtoEstoque.getPisCofinsNota());
		proc.setParameter("varFreteNota", produtoEstoque.getFreteNota());
		proc.setParameter("varIpiNota", produtoEstoque.getIpiNota());
		proc.setParameter("varIcmsNota", produtoEstoque.getIcmsNota());
		proc.setParameter("varDespesaNota", produtoEstoque.getDespesaNota());
		proc.setParameter("varSituacao", Situacao);
		proc.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoEstoque> buscaMovProdutoEstoque(PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select p From ProdutoEstoque p ");
		this.definiCondicoes(sql, dadosPesquisaEstoquePojo);
		sql.append(" order by p.data, p.idProdEst");
		Query qry = getEntityManager().createQuery(sql.toString());
		this.definiParametros(qry, dadosPesquisaEstoquePojo);
		qry.setFirstResult(dadosPesquisaEstoquePojo.getPrimeiroRegistro());
		qry.setMaxResults(dadosPesquisaEstoquePojo.getQuantidadeRegistros());
		List<ProdutoEstoque> lista = qry.getResultList();
		return lista;
	}

	private void definiParametros(Query qry, PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		qry.setParameter("empresa", dadosPesquisaEstoquePojo.getEmpresa());
		qry.setParameter("produto", dadosPesquisaEstoquePojo.getProduto());
		qry.setParameter("dataIni", dadosPesquisaEstoquePojo.getDataIni());
		qry.setParameter("dataFim", dadosPesquisaEstoquePojo.getDataFim());
		if (dadosPesquisaEstoquePojo.getTipoMovEst() != null) {
			qry.setParameter("tipoMovEst",
					dadosPesquisaEstoquePojo.getTipoMovEst().ordinal());
		}
	}

	private void definiCondicoes(StringBuilder sql, PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		sql.append(" where p.empresa = :empresa")
				.append(" and p.produto = :produto")
				.append(" and p.data between :dataIni").append(" and :dataFim");
		if (dadosPesquisaEstoquePojo.getTipoMovEst() != null) {
			sql.append(" and tipoMovEst = :tipoMovEst");
		}
	}

	@Override
	public int countMovProdutoEstoque(PesquisaEstoquePojo dadosPesquisaEstoquePojo) {
		StringBuilder sql = new StringBuilder();
		sql.append("Select count(p) From ProdutoEstoque p ");
		this.definiCondicoes(sql, dadosPesquisaEstoquePojo);
		Query qry = getEntityManager().createQuery(sql.toString());
		this.definiParametros(qry, dadosPesquisaEstoquePojo);
		Number count = (Number) qry.getSingleResult();
		return count.intValue();
	}

}
