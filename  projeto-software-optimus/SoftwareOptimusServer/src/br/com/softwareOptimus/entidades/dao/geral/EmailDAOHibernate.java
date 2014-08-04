package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Pessoa;

public class EmailDAOHibernate implements EmailDAO {

	private EntityManager session;
	private EntityTransaction transacao;

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
	public void salvar(Email email) throws Exception {
		this.session.persist(email);
		this.transacao.commit();

	}

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
	public void excluir(Long idEmail) throws Exception {
		this.session.remove(this.session.getReference(Email.class, idEmail));
		this.transacao.commit();

	}

	@Override
	public List<Email> listaEmail(Pessoa pessoa) throws Exception {
		String jpql = "Select e from Email e where e.pessoa = :parPessoa";
		TypedQuery<Email> consulta = this.session
				.createQuery(jpql, Email.class);
		consulta.setParameter("parPessoa", pessoa);
		return consulta.getResultList();
	}

	@Override
	public List<Email> emailNFE(Pessoa pessoa) throws Exception {
		Integer nfe = 1;
		String jpql = "Select e From Email e where e.pessoa = :parPessoa" +
				" and e.padraoNFe = :parNFe";
		TypedQuery<Email> consulta = this.session
				.createQuery(jpql, Email.class);
		consulta.setParameter("parPessoa", pessoa);
		consulta.setParameter("parNFe", nfe);
		return consulta.getResultList();
	}

}
