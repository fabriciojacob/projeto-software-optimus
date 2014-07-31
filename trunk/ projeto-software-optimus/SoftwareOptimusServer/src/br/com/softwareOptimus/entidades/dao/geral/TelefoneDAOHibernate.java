package br.com.softwareOptimus.entidades.dao.geral;

import java.io.IOException;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import br.com.softwareOptimus.entidades.Telefone;

public class TelefoneDAOHibernate implements TelefoneDAO {
	
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
	public void salvar(Telefone telefone) throws Exception {
		this.session.persist(telefone);
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

	@Override
	public void excluir(Telefone telefone) throws Exception {
		this.session.remove(telefone);
		this.transacao.commit();
		
	}

}
