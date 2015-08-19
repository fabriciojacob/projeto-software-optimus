package br.com.softwareOptimus.financeiro.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.StatusConta;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;
import br.com.softwareOptimus.util.JpaUtil;

public class TituloDAOHibernate extends JpaUtil implements TituloDAO {

	@Override
	public void salvar(Titulo titulo) throws Exception {
		beginTransaction();
		getEntityManager().persist(titulo);
		commitTransaction();
		getEntityManager().clear();
	}

	public void salvarParcelas(Long titulo) throws Exception {
		StoredProcedureQuery proc = getEntityManager()
				.createStoredProcedureQuery("pkg_financeiro.addparcelas");
		proc.registerStoredProcedureParameter("idTitulo", Long.class,
				ParameterMode.IN);
		proc.registerStoredProcedureParameter("operacao", Integer.class,
				ParameterMode.IN);
		proc.setParameter("idTitulo", titulo);
		proc.setParameter("operacao", 0);
		proc.executeUpdate();
	}

	@Override
	public void editar(Titulo titulo) throws Exception {
		beginTransaction();
		getEntityManager().merge(titulo);
		commitTransaction();
		getEntityManager().clear();
	}

	@Override
	public List<Titulo> pesquisaPessoa(Pessoa p) throws Exception {
		String jpql = "Select e from Titulo e where e.empresa = :parEmpresa";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parEmpresa", p);
		return consulta.getResultList();
	}

	@Override
	public void excluir(Titulo titulo) throws Exception {
		beginTransaction();
		getEntityManager().remove(titulo);
		commitTransaction();
	}

	@Override
	public List<Titulo> pesquisaVencimento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		String jpql = "Select e from Titulo e where e.vencimento between :parDataIni and :parDataFim"
				+ " and e.empresa = :parEmpresa"
				+ " and e.pessoa = :parParticipante"
				+ " and e.tipoTitulo = :parTipo" + " and e.status = :parStatus";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		if (tipo == 0) {
			consulta.setParameter("parTipo", TipoTitulo.PAGAR.ordinal());
		} else {
			consulta.setParameter("parTipo", TipoTitulo.RECEBER.ordinal());
		}
		if (status == 0) {
			consulta.setParameter("parStatus", StatusConta.BAIXADA.ordinal());
		} else if (status == 1) {
			consulta.setParameter("parStatus", StatusConta.PENDENTE.ordinal());
		} else {
			consulta.setParameter("parStatus", StatusConta.CANCELADA.ordinal());
		}
		return consulta.getResultList();
	}

	@Override
	public List<Titulo> pesquisaPagamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		String jpql = "Select e from Titulo e where e.dataPagamento between :parDataIni and :parDataFim"
				+ " and e.empresa = :parEmpresa "
				+ " and e.pessoa = :parParticipante"
				+ " and e.tipoTitulo = :parTipo" + " and e.status = :parStatus";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		if (tipo == 0) {
			consulta.setParameter("parTipo", TipoTitulo.PAGAR.ordinal());
		} else {
			consulta.setParameter("parTipo", TipoTitulo.RECEBER.ordinal());
		}
		if (status == 0) {
			consulta.setParameter("parStatus", StatusConta.BAIXADA.ordinal());
		} else if (status == 1) {
			consulta.setParameter("parStatus", StatusConta.PENDENTE.ordinal());
		} else {
			consulta.setParameter("parStatus", StatusConta.CANCELADA.ordinal());
		}
		return consulta.getResultList();
	}

	@Override
	public List<Titulo> pesquisaLancamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		String jpql = "Select e from Titulo e where e.dataLancamento between :parDataIni and :parDataFim"
				+ " and e.empresa = :parEmpresa"
				+ " and e.pessoa = :parParticipante"
				+ " and e.tipoTitulo = :parTipo" + " and e.status = :parStatus";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		if (tipo == 0) {
			consulta.setParameter("parTipo", TipoTitulo.PAGAR.ordinal());
		} else {
			consulta.setParameter("parTipo", TipoTitulo.RECEBER.ordinal());
		}
		if (status == 0) {
			consulta.setParameter("parStatus", StatusConta.BAIXADA.ordinal());
		} else if (status == 1) {
			consulta.setParameter("parStatus", StatusConta.PENDENTE.ordinal());
		} else {
			consulta.setParameter("parStatus", StatusConta.CANCELADA.ordinal());
		}
		return consulta.getResultList();
	}

	@Override
	public List<Pessoa> listaParticipante(String nome) throws Exception {
		String jpql = "Select e From Pessoa e where e.fantasia like :parNome";
		TypedQuery<Pessoa> consulta = getEntityManager().createQuery(jpql,
				Pessoa.class);
		consulta.setParameter("parNome", "%" + nome + "%");
		return consulta.getResultList();
	}

	@Override
	public Pessoa participante(Long id) throws Exception {
		return getEntityManager().find(Pessoa.class, id);
	}

	@Override
	public Titulo retornaTitulo(Long id) throws Exception {
		String jpql = "Select t from Titulo t where t.idTitulo = :id";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("id", id);
		return consulta.getSingleResult();
	}

	@Override
	public void checkStatusBaixaTitulo(Long id) throws Exception {
		String jpql = "Select t from Titulo t where t.idTitulo = :id"
				+ " and t.status = 0";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("id", id);
		consulta.getSingleResult();
	}

	@Override
	public Titulo retornaTituloBaixado(Long id) throws Exception {
		String jpql = "Select t from Titulo t where t.idTitulo = :id"
				+ " and t.status = 0";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("id", id);
		return consulta.getSingleResult();
	}

	@Override
	public Titulo retornaTituloGeral(Long id) throws Exception {
		String jpql = "Select t from Titulo t where t.idTitulo = :id";
		TypedQuery<Titulo> consulta = getEntityManager().createQuery(jpql,
				Titulo.class);
		consulta.setParameter("id", id);
		return consulta.getSingleResult();
	}
}
