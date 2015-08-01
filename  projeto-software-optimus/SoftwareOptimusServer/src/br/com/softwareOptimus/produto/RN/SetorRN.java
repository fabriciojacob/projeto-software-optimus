package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.SetorDAO;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.util.DAOFactory;

public class SetorRN {

	private SetorDAO setorDAO;

	public SetorRN() {
		this.setorDAO = DAOFactory.criaSetorDAO();
	}

	public Integer validaCampoNulo(Setor setor, List<Grupo> listaGrupoExib) {
		Integer retorno = 0;
		if(setor.getDescricao().equals("") || listaGrupoExib.size() == 0){
			retorno =1;
		}
		return retorno;
	}

	public void salvar(Setor setor) {
		this.setorDAO.salvar(setor);
	}

	public void altSet(Setor setor) {
		this.setorDAO.altSet(setor);
	}

	public Integer verificaRemocao(Setor setor) {
		List<Produto> prod = this.setorDAO.verProdSet(setor);
		if (prod.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

	public void remover(Setor setor) {
		this.setorDAO.remove(setor);
	}

	public List<Setor> consultaId(long parseLong) {
		return this.setorDAO.consultaId(parseLong);
	}

	public List<Setor> consultaDesc(String busca) {
		return this.setorDAO.consultaDesc(busca);
	}

	public List<Setor> listar() {
		return this.setorDAO.listar();
	}

	public Setor editSet(Long id) {
		return this.setorDAO.editSet(id);
	}

	public Integer verificaRemocaoRelGrupo(Setor setor, Long idGrup) {
		List<Produto> prod = this.setorDAO.verRemRelGrup(setor, idGrup);
		if(prod.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

	public List<Setor> consultaIdGrup(long idGrup) {
		return this.setorDAO.consultaIdGrup(idGrup);
	}

	public List<Setor> consultaDescGrup(String busca) {
		return this.setorDAO.consultaDescGrup(busca);
	}

	public int countSetorPaginacao(Setor setor, Grupo grupo) {
		return this.setorDAO.countSetorPaginacao(setor, grupo);
	}

	public List<Setor> buscaSetorPaginacao(Setor setor, Grupo grupo, int first, int pageSize) {
		return this.setorDAO.buscaSetorPaginacao(setor, grupo, first, pageSize);
	}

}
