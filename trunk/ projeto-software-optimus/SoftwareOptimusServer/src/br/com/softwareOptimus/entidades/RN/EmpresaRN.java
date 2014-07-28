package br.com.softwareOptimus.entidades.RN;

import java.util.ArrayList;
import java.util.List;

import br.com.softwareOptimus.entidades.Logradouro;
import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAO;
import br.com.softwareOptimus.entidades.dao.geral.LogradouroDAO;
import br.com.softwareOptimus.fiscal.VigenciaRegime;
import br.com.softwareOptimus.util.DAOFactory;

public class EmpresaRN {

	private EmpresaDAO empresaDAO;
	private List<Logradouro> lista = new ArrayList<>();
	private LogradouroDAO logrDAO = DAOFactory.criaLogrDAO();

	public EmpresaRN() {
		empresaDAO = DAOFactory.criaEmpresaDAO();
	}

	public void salvar(PessoaJuridica empresa) {
		Long codigo = empresa.getIdPessoa();
		if (codigo == null || codigo == 0) {
			this.empresaDAO.salvar(empresa);
		} else {
			this.empresaDAO.atualizar(empresa);
		}
	}
	
	public List<Logradouro> listaLogr(){
		 return this.lista = logrDAO.listar();
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

}
