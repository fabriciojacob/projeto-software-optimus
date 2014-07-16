package br.com.softwareOptimus.entidades.dao.empresa;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.com.softwareOptimus.entidades.NaturezaPessoa;
import br.com.softwareOptimus.entidades.PessoaJuridica;

public class EmpresaDAOHibernate implements EmpresaDAO {

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
	public void salvar(PessoaJuridica empresa) {
		empresa.setNaturezaPessoa(NaturezaPessoa.EMPRESA);
		this.session.persist(empresa);
		this.transaction.commit();

	}

	@Override
	public void atualizar(PessoaJuridica empresa) {
		this.session.merge(empresa);
		this.transaction.commit();
	}

	@Override
	public void excluir(PessoaJuridica empresa) {
		this.session.remove(empresa);
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
	public PessoaJuridica carregar(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaJuridica> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
