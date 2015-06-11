package br.com.softwareOptimus.com.comercial.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.com.softwareOptimus.comercial.Requisicao;

public class RequisicaoHibernate implements RequisicaoDAO{
	
	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void begin() throws IOException, SQLException {
		this.transacao = this.session.getTransaction();
		if(!this.transacao.isActive()){
			this.transacao.begin();
		}
		
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Requisicao> lista() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Requisicao requisicao(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
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

}
