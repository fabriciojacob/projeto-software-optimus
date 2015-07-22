package br.com.softwareOptimus.entidades.RN;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAO;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.entidades.dao.geral.RegimeDAO;
import br.com.softwareOptimus.fiscal.VigenciaRegime;
import br.com.softwareOptimus.util.DAOFactory;

public class EmpresaRN {

	private EmpresaDAO empresaDAO;
	@SuppressWarnings("unused")
	private List<Logradouro> lista = new ArrayList<>();
	private List<VigenciaRegime> vigReg = new ArrayList<>();
	private LogradouroDAO logrDAO = DAOFactory.criaLogrDAO();
	private RegimeDAO regDAO;

	public EmpresaRN() {
		empresaDAO = DAOFactory.criaEmpresaDAO();
		regDAO = DAOFactory.criaVigenciaRegDAO();
	}

	public void salvar(PessoaJuridica empresa) {
		Long codigo = empresa.getIdPessoa();
		if (codigo == null || codigo == 0) {
			this.empresaDAO.salvar(empresa);
		} else {
			this.empresaDAO.atualizar(empresa);
		}
	}

	public List<VigenciaRegime> validaRegime(PessoaJuridica empresa, Date data)
			throws Exception {
		return this.empresaDAO.validaRegime(empresa, data);
	}

	public List<VigenciaRegime> getVigReg() {
		return vigReg;
	}

	public void setVigReg(List<VigenciaRegime> vigReg) {
		this.vigReg = vigReg;
	}

	public List<VigenciaRegime> listaReg(PessoaJuridica pessoaJuridica)
			throws Exception {
		return this.vigReg = regDAO.listaRegime(pessoaJuridica);
	}

	public List<Logradouro> listaLogr(PessoaJuridica pessoaJuridica) {
		return this.lista = logrDAO.listar(pessoaJuridica);
	}

	public void salvarRegime(VigenciaRegime regime) throws Exception {
		this.empresaDAO.salvarRegime(regime);
	}

	public List<PessoaJuridica> pesquisaCNPJ(String cnpj) throws Exception {
		return this.empresaDAO.buscaCNPJ(cnpj);
	}

	public List<PessoaJuridica> pesquisaNome(String nome) throws Exception {
		return this.empresaDAO.buscaNome(nome);
	}

	public PessoaJuridica pesquisaId(Long id) {
		return this.empresaDAO.carregar(id);
	}

	public void excluirVigReg(Long idVig) throws Exception {
		this.regDAO.excluirRegime(idVig);
	}
	
	public Integer validaCampoNulo(PessoaJuridica pessoa){
		Integer retorno = 0;
		
		if(pessoa.getCnpj().isEmpty() || pessoa.getFantasia().isEmpty() || pessoa.getRazaoSocial().isEmpty() || 
				pessoa.getCnae().isEmpty() || pessoa.getIe().isEmpty()){
			retorno = 1;
		}
		
		return retorno;
	}

	public int countEmpresaPaginacao(Pessoa empresa) {
		return 0;
	}

	public List<Pessoa> buscaEmpresaPaginacao(Pessoa empresa, int first,int pageSize) {
		return null;
	}

}
