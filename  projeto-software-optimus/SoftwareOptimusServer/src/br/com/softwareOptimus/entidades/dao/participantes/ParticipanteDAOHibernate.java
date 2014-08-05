package br.com.softwareOptimus.entidades.dao.participantes;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public class ParticipanteDAOHibernate implements ParticipanteDAO {

	private EntityManager session;
	private EntityTransaction transaction;

	public EntityManager getSession() {
		return session;
	}

	public void setSession(EntityManager session) {
		this.session = session;
	}

	public EntityTransaction getTransaction() {
		return transaction;
	}

	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
	}

	@Override
	public void salvarPessoaJuridica(PessoaJuridica pessoa) throws Exception {
		this.session.persist(pessoa);
		this.transaction.commit();
	}

	@Override
	public void salvarPessoaFisica(PessoaFisica pessoa) throws Exception {
		this.session.persist(pessoa);
		this.transaction.commit();
	}

	@Override
	public void atualizarPessoaJuridica(PessoaJuridica pessoa) throws Exception {
		this.session.merge(pessoa);
		this.transaction.commit();
	}

	@Override
	public void atualizarPessoaFisica(PessoaFisica pessoa) throws Exception {
		this.session.merge(pessoa);
		this.transaction.commit();
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = this.session.getTransaction();
		if (!this.transaction.isActive()) {
			this.transaction.begin();
		}

	}

	@Override
	public void close() throws Exception {
		this.session.close();
	}

	@Override
	public Pessoa carregar(Long codigo) throws Exception {
		return this.session.find(Pessoa.class, codigo);
	}

	@Override
	public List<PessoaJuridica> buscaCNPJ(String cnpj) throws Exception {
		String jpql = "Select p From PessoaJuridica p "
				+ " where p.fantasia = :parCnpj " + " and p.naturezaPessoa = 1";
		TypedQuery<PessoaJuridica> consulta = this.session.createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parCnpj", cnpj);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaJuridica> buscaNomePJ(String nome) throws Exception {
		String jpql = "Select p From PessoaJuridica p "
				+ " where p.fantasia = :parNome" + " and p.naturezaPessoa = 1";
		TypedQuery<PessoaJuridica> consulta = this.session.createQuery(jpql,
				PessoaJuridica.class);
		consulta.setParameter("parNome","%" + nome + "%");
		return consulta.getResultList();
	}

	@Override
	public List<PessoaFisica> buscaCPF(String CPF) throws Exception {
		String jpql = "Select p From PessoaFisica p "
				+ " where p.cpf = :parCPF " + " and p.naturezaPessoa = 0";
		TypedQuery<PessoaFisica> consulta = this.session.createQuery(jpql,
				PessoaFisica.class);
		consulta.setParameter("parCPF",CPF);
		return consulta.getResultList();
	}

	@Override
	public List<PessoaFisica> buscaNomePF(String nome) throws Exception {
		String jpql = "Select p From PessoaFisica p"
				+ " where p.fantasia = :parPessoa"
				+ " and p.naturezaPessoa = 0";
		TypedQuery<PessoaFisica> consulta = this.session.createQuery(jpql,
				PessoaFisica.class);
		consulta.setParameter("parPessoa","%" + nome + "%");
		return consulta.getResultList();
	}


}
