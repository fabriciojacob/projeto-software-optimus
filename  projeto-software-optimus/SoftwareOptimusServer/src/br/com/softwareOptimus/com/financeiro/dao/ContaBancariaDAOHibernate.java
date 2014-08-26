package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.TipoContaBancaria;

public class ContaBancariaDAOHibernate implements ContaBancariaDAO {

	private EntityTransaction transacao;
	private EntityManager session;

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
	public void excluirConta(ContaBancaria conta) throws Exception {
		this.session.remove(conta);
		this.transacao.commit();
	}

	@Override
	public void salvarConta(ContaBancaria conta) throws Exception {
		this.session.persist(conta);
		this.transacao.commit();
	}

	@Override
	public List<ContaBancaria> pesquisarConta(String titular, Integer agencia,
			Integer conta, TipoContaBancaria tipoConta) throws Exception {
		String jpql = null;
		TypedQuery<ContaBancaria> consulta;
		if (titular == null) {
			jpql = "Select c from ContaBancaria c where c.agencia = :parAgencia"
					+ " and c.conta = :parConta"
					+ " and c.tipoContaBancaria = :parTipoConta";
			consulta = this.session.createQuery(jpql,
					ContaBancaria.class);
			consulta.setParameter("parAgencia", agencia);
			consulta.setParameter("parConta", conta);
			consulta.setParameter("parTipoConta", tipoConta);
		} else {
			jpql = "Select c from ContaBancaria c where c.titular LIKE :parTitular";
			consulta = this.session.createQuery(jpql,
					ContaBancaria.class); 
			consulta.setParameter("parTitular", "%" + titular + "%");
			
		}
		return consulta.getResultList();
	}

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if(!this.transacao.isActive()){
			this.transacao.begin();
		}
		
	}

	@Override
	public void close() throws Exception {
		this.session.close();
		
	}

	@Override
	public void alterar(ContaBancaria conta) throws Exception {
		this.session.merge(conta);
		
	}

}
