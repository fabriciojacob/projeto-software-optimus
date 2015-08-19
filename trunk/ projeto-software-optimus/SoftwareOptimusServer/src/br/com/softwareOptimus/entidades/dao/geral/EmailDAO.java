package br.com.softwareOptimus.entidades.dao.geral;

import java.util.List;

import br.com.softwareOptimus.entidades.Email;
import br.com.softwareOptimus.entidades.Pessoa;

public interface EmailDAO {
	
	public void salvar(Email email) throws Exception;
	public void excluir(Long idEmail) throws Exception;
	public List<Email> listaEmail(Pessoa pessoa) throws Exception;
	public List<Email> emailNFE(Pessoa pessoa) throws Exception;

}
