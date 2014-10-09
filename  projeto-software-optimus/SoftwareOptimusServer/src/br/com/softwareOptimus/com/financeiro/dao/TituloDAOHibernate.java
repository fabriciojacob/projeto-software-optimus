package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Titulo;

public class TituloDAOHibernate implements TituloDAO {

	private EntityManager session;

	private EntityTransaction transacao;

	@Override
	public void salvar(Titulo titulo) throws Exception {
		this.session.persist(titulo);
		this.transacao.commit();
	}

	@Override
	public void editar(Titulo titulo) throws Exception {
		this.session.merge(titulo);
		this.transacao.commit();
	}

	@Override
	public List<Titulo> pesquisaPessoa(Pessoa p) throws Exception {
		String jpql = "Select e from Titulo e where e.empresa = :parEmpresa";
		TypedQuery<Titulo> consulta = this.session.createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parEmpresa", p);
		return consulta.getResultList();
	}

	@Override
	public void excluir(Titulo titulo) throws Exception {
		this.session.remove(titulo);
		this.transacao.commit();
	}

	@Override
	public List<Titulo> pesquisaVencimento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo, Integer status)
			throws Exception {
		String jpql = "Select e from Titulo e where e.vencimento between :parDataIni and :parDataFim"
				+ " and e.empresa = :parEmpresa"
				+ " and e.pessoa = :parParticipante"
				+ " and e.tipoTitulo = :parTipo" + " and e.status = :parStatus";
		TypedQuery<Titulo> consulta = this.session.createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		consulta.setParameter("parTipo", tipo);
		consulta.setParameter("parStatus", status);
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
		TypedQuery<Titulo> consulta = this.session.createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		consulta.setParameter("parTipo", tipo);
		consulta.setParameter("parStatus", status);
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
		TypedQuery<Titulo> consulta = this.session.createQuery(jpql,
				Titulo.class);
		consulta.setParameter("parDataIni", dataInicio);
		consulta.setParameter("parDataFim", dataFim);
		consulta.setParameter("parEmpresa", empresa);
		consulta.setParameter("parParticipante", participante);
		consulta.setParameter("parTipo", tipo);
		consulta.setParameter("parStatus", status);
		return consulta.getResultList();
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}
	}

	@Override
	public List<Pessoa> listaParticipante(String nome) throws Exception {
		String jpql = "Select e From Pessoa e where e.fantasia like :parNome";
		TypedQuery<Pessoa> consulta = this.session.createQuery(jpql,
				Pessoa.class);
		consulta.setParameter("parNome", "%" + nome + "%");
		return consulta.getResultList();
	}

	@Override
	public Pessoa participante(Long id) throws Exception {
		return this.session.find(Pessoa.class, id);
	}

}