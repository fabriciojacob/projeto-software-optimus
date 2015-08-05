package br.com.softwareOptimus.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.comercial.Requisicao;

public class RequisicaoHibernate implements RequisicaoDAO {

	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

	}

	@Override
	public void close() throws Exception {
		this.session.close();
	}

	@Override
	public List<Requisicao> lista() throws Exception {
		String jpql = "Select r From Requisicao";
		TypedQuery<Requisicao> consulta = this.session.createQuery(jpql,
				Requisicao.class);

		return consulta.getResultList();
	}

	@Override
	public Requisicao requisicao(Long id) throws Exception {
		String jpql = "Select r From Requisicao r where r.idRequisicao = :parId";
		TypedQuery<Requisicao> consulta = this.session.createQuery(jpql,
				Requisicao.class);
		consulta.setParameter("parId", id);
		return consulta.getSingleResult();
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
	public void salvar(Requisicao requisicao) throws Exception {
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

		this.session.persist(requisicao);
		this.transacao.commit();
	}

	@Override
	public void editar(Requisicao requisicao) throws Exception {
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

		this.session.merge(requisicao);
		this.transacao.commit();

	}

	@Override
	public void excluir(Requisicao requisicao) throws Exception {
		if (!this.transacao.isActive()) {
			this.transacao.begin();
		}

		this.session.remove(requisicao);
		this.transacao.commit();
	}

	@Override
	public List<Requisicao> pesquisaDescricao(String descricao)
			throws Exception {
		String jpql = "Select e From Requisicao where descricao like '%"
				+ descricao + "'%";
		TypedQuery<Requisicao> listaRequisicao = this.session.createQuery(jpql,
				Requisicao.class);
		return listaRequisicao.getResultList();
	}

	@Override
	public List<Requisicao> pesquisaPeriodo(Date dataIni, Date dataFim,
			String desc) throws Exception {
		String jpql = "Select e From Requisicao e where e.dataReq between :parDataIni and :parDataFim and e.descricao like '%"
				+ desc + "%'";
		TypedQuery<Requisicao> listaRequisicao = this.session.createQuery(jpql,
				Requisicao.class);
		listaRequisicao.setParameter("parDataIni", dataIni);
		listaRequisicao.setParameter("parDataFim", dataFim);
		return listaRequisicao.getResultList();
	}

	@Override
	public Long countProdutos(Requisicao requisicao) throws Exception {
		String jpql = "Select count(r) from RequisicaoItens r where r.requisicao = :parRequisicao";
		TypedQuery<Long> consulta = this.session.createQuery(jpql,
				Long.class);
		consulta.setParameter("parRequisicao", requisicao);
		return consulta.getSingleResult();
	}

}
