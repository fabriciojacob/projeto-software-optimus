package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.GrupoDAO;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.util.DAOFactory;

public class GrupoRN {
	
	private GrupoDAO grupoDAO;

	public GrupoRN(){
		this.grupoDAO = DAOFactory.criaGrupoDAO();
	}

	public void salvar(Grupo grupo) {
		this.grupoDAO.salvar(grupo);
	}

	public Integer validaCampoNulo(Grupo grupo) {
		Integer retorno = 0;
		if (grupo.getDescricao().equals("")|| grupo.getSubGrupo().isEmpty()){ 
			retorno = 1;
		}
		return retorno;
	}

	public void altGru(Grupo grupo) {
		this.grupoDAO.alterar(grupo);
	}

	public Integer verificaRemocao(Grupo grupo) {
		List<Setor> listaSetor = this.grupoDAO.verificaRemocao(grupo);
		if(listaSetor.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

	public void remover(Grupo grupo) {
		this.grupoDAO.remover(grupo);
	}

	public List<Grupo> consultaId(long parseLong) {
		return this.grupoDAO.consultaId(parseLong);
	}

	public List<Grupo> consultaDesc(String busca) {
		return this.grupoDAO.consultaDesc(busca);
	}

	public List<Grupo> listar() {
		return this.grupoDAO.lista();
	}

	public Grupo editGru(Long id) {
		return this.grupoDAO.editGrupo(id);
	}
}
