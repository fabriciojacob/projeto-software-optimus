package br.com.softwareOptimus.entidades.RN;

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
	private LogradouroDAO logrDAO;

	public ParticipanteRN() {
		this.participanteDAO = DAOFactory.criaParticipanteDAO();
		this.logrDAO = DAOFactory.criaLogrDAO();
	}

	public void salvarPJ(PessoaJuridica pessoa) throws Exception {
		this.participanteDAO.salvarPessoaJuridica(pessoa);

	}

	public void salvarPF(PessoaFisica pessoa) throws Exception {
		this.participanteDAO.salvarPessoaFisica(pessoa);

	}

	public void atualizarPF(PessoaFisica pessoa) throws Exception {
		this.participanteDAO.atualizarPessoaFisica(pessoa);
	}

	public Integer validaCampoNuloPJ(PessoaJuridica pessoa) {
		Integer retorno = 0;

		if (pessoa.getCnpj().isEmpty() || pessoa.getFantasia().isEmpty()
				|| pessoa.getRazaoSocial().isEmpty()
				|| pessoa.getCnae().isEmpty() || pessoa.getIe().isEmpty()
				|| pessoa.getNaturezaPessoa() == null) {
			retorno = 1;
		}

		return retorno;
	}

	public Integer validaCampoNuloPF(PessoaFisica pessoa) {
		Integer retorno = 0;

		if (pessoa.getFantasia().isEmpty() || pessoa.getRg().isEmpty()
				|| pessoa.getCpf().isEmpty() || pessoa.getNaturezaPessoa() == null) {
			retorno = 1;
		}

		return retorno;
	}

	public List<PessoaJuridica> listaPJCNPJ(String CNPJ) throws Exception {
		return this.participanteDAO.buscaCNPJ(CNPJ);
	}

	public List<PessoaJuridica> listaPJNome(String nome) throws Exception {
		return this.participanteDAO.buscaNomePJ(nome);
	}

	public List<PessoaFisica> listaPFCPF(String CPF) throws Exception {
		return this.participanteDAO.buscaCPF(CPF);
	}

	public List<PessoaFisica> listaPFNome(String nome) throws Exception {
		return this.participanteDAO.buscaNomePF(nome);
	}

	public List<Logradouro> listaLogr(Pessoa pessoa) throws Exception {
		return logrDAO.listar(pessoa);
	}

	public PessoaFisica carregaIDPF(Long codigo) throws Exception {
		return this.participanteDAO.carregarPF(codigo);
	}

	public PessoaJuridica carregaIDPJ(Long codigo) throws Exception {
		return this.participanteDAO.carregarPJ(codigo);
	}

	public int countPessoaFisicaPaginacao(PessoaFisica pessoaFisica) {
		return participanteDAO.countPessoaFisicaPaginacao(pessoaFisica);
	}

	public List<PessoaFisica> buscaPessoaFisicaPaginacao(PessoaFisica pessoaFisica, int first, int pageSize) {
		return participanteDAO.buscaPessoaFisicaPaginacao(pessoaFisica, first, pageSize);
	}
	
	public List<PessoaJuridica> buscaPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica, int first, int pageSize) {
		return participanteDAO.buscaPessoaJuridicaPaginacao(pessoaJuridica, first, pageSize);
	}
	
	public int countPessoaJuridicaPaginacao(PessoaJuridica pessoaJuridica) {
		return participanteDAO.countPessoaJuridicaPaginacao(pessoaJuridica);
	}
}
