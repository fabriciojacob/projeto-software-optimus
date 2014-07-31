package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public class LogradouroDAOHibernate implements LogradouroDAO {

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
	public void salvar(Logradouro logradouro) {
		this.session.persist(logradouro);
		this.transaction.commit();

	}

	public void refresh() {

	}

	@Override
	public void atualizar(Logradouro logradouro) {
		this.session.merge(logradouro);
		this.transaction.commit();

	}

	@Override
	public void excluir(Long idLogr) {
		if(!this.transaction.isActive()){
			this.transaction.begin();
		}
		this.session.remove(this.session.getReference(Logradouro.class, idLogr));
		this.transaction.commit();

	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transaction = session.getTransaction();

		if (!transaction.isActive()) {
			transaction.begin();
		}

	}

	@Override
	public void close() throws Exception {
		this.session.close();

	}

	@Override
	public void consultar() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public Logradouro carregar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Logradouro> listar(PessoaJuridica pessoaJuridica) {
		String jpql = "Select l From Logradouro l inner join l.municipio c inner join c.uf "
				+ " where l.pessoa = :parPessoa";
		Query consulta = this.session.createQuery(jpql);
		consulta.setParameter("parPessoa", pessoaJuridica);
		return consulta.getResultList();
	}

}
