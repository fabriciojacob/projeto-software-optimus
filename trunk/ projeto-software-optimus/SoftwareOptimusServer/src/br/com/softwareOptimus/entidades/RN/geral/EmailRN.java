package br.com.softwareOptimus.entidades.RN.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.dao.geral.EmailDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class EmailRN {

	private EmailDAO emailDAO;
	private List<Email> listaEmails;

	public EmailRN() {
		this.emailDAO = DAOFactory.criaEmailDAO();
	}

	public void salvar(Email email) throws Exception {
		this.emailDAO.salvar(email);
	}

	public List<Email> listaEmail(Pessoa pessoa) throws Exception {
		return this.emailDAO.listaEmail(pessoa);
	}

	public Integer validaEmailNFE(Pessoa pessoa) throws Exception {
		Integer nfe = 0;
		listaEmails = this.emailDAO.emailNFE(pessoa);
		if(listaEmails.isEmpty()){
			nfe = 0;
		}else{
			nfe = 1;
		}
		
		return nfe;
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

	public List<Email> getListaEmails() {
		return listaEmails;
	}

	public void setListaEmails(List<Email> listaEmails) {
		this.listaEmails = listaEmails;
	}

	public Integer validaCampoNulo(Email emails) {
		if(emails.getEmail().isEmpty()){
			return 1;
		}
		else{
			return 0;
		}
	}

}
