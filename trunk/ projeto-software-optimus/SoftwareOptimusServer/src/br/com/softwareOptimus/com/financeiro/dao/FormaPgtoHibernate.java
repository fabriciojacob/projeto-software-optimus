package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.softwareOptimus.financeiro.FormaPgto;

public class FormaPgtoHibernate implements FormaPgtoDAO {
	
	private EntityManager session;
	private EntityTransaction transacao;

	@Override
	public void salvar(FormaPgto formaPgto) throws Exception {
		this.session.persist(formaPgto);
		this.transacao.commit();
		
	}

	@Override
	public void excluir(FormaPgto formaPgto) throws Exception {
		this.session.remove(formaPgto);
		this.transacao.commit();
		
	}

	@Override
	public List<FormaPgto> lista(String descricao) throws Exception {
		String jpql = "Select e From FormaPgto e where e.descricao Like :parDesc";
		TypedQuery<FormaPgto> consulta = this.session.createQuery(jpql, FormaPgto.class);
		consulta.setParameter("parDesc","%" + descricao + "%");
		return consulta.getResultList();
	}

	@Override
	public void editar(FormaPgto formaPgto) throws Exception {
		this.session.merge(formaPgto);
		this.transacao.commit();
		
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
	public FormaPgto selecionar(Long id) throws Exception {
		return this.session.find(FormaPgto.class, id);
	}
	
	

}
