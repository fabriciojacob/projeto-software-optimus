package br.com.softwareOptimus.entidades.RN;

import java.util.List;

import br.com.softwareOptimus.entidades.PessoaJuridica;
import br.com.softwareOptimus.entidades.dao.empresa.EmpresaDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class EmpresaRN {
	
	private EmpresaDAO empresaDAO;
	
	public EmpresaRN(){
		empresaDAO = DAOFactory.criaEmpresaDAO();
	}
	
	public void salvar(PessoaJuridica empresa){
		Long codigo = empresa.getIdPessoa();
		if(codigo == null || codigo == 0){
			this.empresaDAO.salvar(empresa);
		}else{
			this.empresaDAO.atualizar(empresa);
		}
	}
	
	public List<PessoaJuridica> pesquisaCNPJ(String cnpj) throws Exception{
		return this.empresaDAO.buscaCNPJ(cnpj);
	}
	
	public List<PessoaJuridica> pesquisaNome(String nome) throws Exception{
		return this.empresaDAO.buscaNome(nome);
	}
	
	public PessoaJuridica pesquisaId(Long id){
		return this.empresaDAO.carregar(id);
	}

}
