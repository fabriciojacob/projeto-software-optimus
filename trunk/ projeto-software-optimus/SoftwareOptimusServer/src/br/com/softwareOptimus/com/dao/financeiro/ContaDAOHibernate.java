package br.com.softwareOptimus.com.dao.financeiro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;

public class ContaDAOHibernate implements ContaDAO {

	private EntityTransaction transacao;
	private EntityManager session;

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
	public void salvar(Conta conta) throws Exception {
		this.session.persist(conta);
		this.transacao.commit();
	}

	@Override
	public void salvarContaFilha(ContaFilha contaFilha) throws Exception {
		this.session.persist(contaFilha);
		this.transacao.commit();
	}

	@Override
	public void excluirContaFilha(ContaFilha contaFilha) throws Exception {
		this.session.remove(contaFilha);
		this.transacao.commit();

	}

	@Override
	public List<Conta> pesquisaConta(String descricao) throws Exception {
		String jpql = "Select c From Conta c where c.descricao LIKE :parDesc";
		TypedQuery<Conta> consulta = this.session
				.createQuery(jpql, Conta.class);
		consulta.setParameter("parDesc", "%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public List<ContaFilha> listaContaFilha(Conta conta) throws Exception {
		String jpql = "Select c from ContaFilha c where c.conta = :parConta ";
		TypedQuery<ContaFilha> consulta = this.session.createQuery(jpql,
				ContaFilha.class);
		consulta.setParameter("parConta", conta);
		return consulta.getResultList();
	}

	public EntityTransaction getTransacao() {
		return transacao;
	}

	public void setTransacao(EntityTransaction transacao) {
		this.transacao = transacao;
	}

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	@Override
	public void alterarConta(Conta conta) throws Exception {
		this.session.merge(conta);
		this.transacao.commit();
	}

	@Override
	public Conta pesquisaConta(Long id) throws Exception {
		return this.session.find(Conta.class, id);
	}

	@Override
	public ContaFilha localizaContaFilha(Long id) throws Exception {
		return this.session.find(ContaFilha.class, id);
	}

}
