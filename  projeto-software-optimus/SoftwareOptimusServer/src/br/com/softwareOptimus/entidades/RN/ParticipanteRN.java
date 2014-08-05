package br.com.softwareOptimus.entidades.RN;

import java.util.ArrayList;
import java.util.List;
import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaFisica;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.entidades.dao.participantes.ParticipanteDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class ParticipanteRN {

	private ParticipanteDAO participanteDAO;
	private List<Logradouro> listaLogr = new ArrayList<>();
	private LogradouroDAO logrDAO;

	public ParticipanteRN() {
		this.participanteDAO = DAOFactory.criaParticipanteDAO();
		this.logrDAO = DAOFactory.criaLogrDAO();
	}

	public void salvarPJ(PessoaJuridica pessoa) throws Exception {
		Long codigo = pessoa.getIdPessoa();
		if (codigo == 0 || codigo == null) {
			this.participanteDAO.salvarPessoaJuridica(pessoa);
		} else {
			this.participanteDAO.atualizarPessoaJuridica(pessoa);
		}

	}

	public void salvarPF(PessoaFisica pessoa) throws Exception {
		this.participanteDAO.salvarPessoaFisica(pessoa);

	}
	
	public void atualizarPF(PessoaFisica pessoa) throws Exception{
		this.participanteDAO.atualizarPessoaFisica(pessoa);
	}

	public Integer validaCampoNuloPJ(PessoaJuridica pessoa) {
		Integer retorno = 0;

		if (pessoa.getCnpj().isEmpty() || pessoa.getFantasia().isEmpty()
				|| pessoa.getRazaoSocial().isEmpty()
				|| pessoa.getCnae().isEmpty() || pessoa.getIe().isEmpty()) {
			retorno = 1;
		}

		return retorno;
	}

	public Integer validaCampoNuloPF(PessoaFisica pessoa) {
		Integer retorno = 0;

		if (pessoa.getFantasia().isEmpty() || pessoa.getRazaoSocial().isEmpty()
				|| pessoa.getRg().isEmpty() || pessoa.getCpf().isEmpty()) {
			retorno = 1;
		}

		return retorno;
	}

	public List<PessoaFisica> listaPFCPF(String CPF) throws Exception {
		return this.participanteDAO.buscaCPF(CPF);
	}

	public List<PessoaFisica> listaPFNome(String nome) throws Exception {
		return this.participanteDAO.buscaNomePF(nome);
	}

	public List<Logradouro> listaLogr(Pessoa pessoa)
			throws Exception {
		return this.listaLogr = logrDAO.listar(pessoa);
	}



}
