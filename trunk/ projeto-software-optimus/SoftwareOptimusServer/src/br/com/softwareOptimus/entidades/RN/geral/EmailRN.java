package br.com.softwareOptimus.entidades.RN.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.dao.geral.EmailDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class EmailRN {
	
	private EmailDAO emailDAO;
	
	public EmailRN(){
		this.emailDAO = DAOFactory.criaEmailDAO();
	}
	
	public void salvar(Email email) throws Exception {
		this.emailDAO.salvar(email);
	}
	
	public List<Email> listaEmail(Pessoa pessoa) throws Exception{
		return this.emailDAO.listaEmail(pessoa);
	}
	
	public EmailDAO getEmailDAO() {
		return emailDAO;
	}
	
	public void setEmailDAO(EmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}
	
	public void excluir(Long idEmail) throws Exception {
		this.emailDAO.excluir(idEmail);
	}

}
