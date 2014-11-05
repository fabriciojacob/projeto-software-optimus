package br.com.softwareOptimus.entidades.RN.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Telefone;
import br.com.softwareOptimus.entidades.dao.geral.TelefoneDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class TelefoneRN {

	private TelefoneDAO telefoneDAO;

	public TelefoneRN() {
		this.telefoneDAO = DAOFactory.criaTelefoneDAO();
	}

	public void salvar(Telefone telefone) throws Exception {
		this.telefoneDAO.salvar(telefone);
	}

	public void excluir(Long idTel) throws Exception {
		this.telefoneDAO.excluir(idTel);
	}

	public List<Telefone> listaTelefone(Pessoa pessoa) throws Exception {
		return this.telefoneDAO.listaTelefone(pessoa);
	}

	public Integer validaCampoNulo(Telefone tel, String dddTel) {
		if (tel.getNumero().isEmpty() || dddTel.equals("")
				|| tel.getTipoFone() == null) {
			return 1;
		} else {
			return 0;
		}
	}

}
