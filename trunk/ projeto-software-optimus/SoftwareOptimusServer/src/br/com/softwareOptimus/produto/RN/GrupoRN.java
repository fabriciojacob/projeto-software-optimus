package br.com.softwareOptimus.produto.RN;

import java.util.List;

import br.com.softwareOptimus.dao.produto.GrupoDAO;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.util.DAOFactory;

public class GrupoRN {
	
	private GrupoDAO grupoDAO;

	public GrupoRN(){
		this.grupoDAO = DAOFactory.criaGrupoDAO();
	}

	public void salvar(Grupo grupo) {
		this.grupoDAO.salvar(grupo);
	}

	public Integer validaCampoNulo(Grupo grupo, List<SubGrupo> listaSubGrupoExib) {
		Integer retorno = 0;
		if (grupo.getDescricao().equals("")|| listaSubGrupoExib.size() == 0){ 
			retorno = 1;
		}
		return retorno;
	}

	public void altGru(Grupo grupo) {
		this.grupoDAO.alterar(grupo);
	}

	public Integer verificaRemocao(Grupo grupo) {
		List<Setor> listaSetor = this.grupoDAO.verificaRemocao(grupo);
		List<Produto> lisProd = this.grupoDAO.VerificaRemGrupoProd(grupo);
		if(listaSetor.size() == 0 && lisProd.size() == 0){
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

	public List<Grupo> listaGrupo() {
		return this.grupoDAO.listaGrupo();
	}

	public Integer verificaRemSubPro(Grupo grupo, Long idSub) {
		List<Produto> lisProd = this.grupoDAO.verificaRemSubGrupo(grupo, idSub);
		if(lisProd.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

	public List<Grupo> listaGrupoVincSet(Setor setor) {
		return this.grupoDAO.listaGrupoVincSet(setor);
	}

	public List<Grupo> consultaIdSub(long idSub) {
		return this.grupoDAO.listaGrupoIdSub(idSub);
	}

	public List<Grupo> consultaDescSub(String busca) {
		return this.grupoDAO.listaGrupoDescSub(busca);
	}

	public int countGrupoPaginacao(Grupo grupo, SubGrupo subGrupo) {
		return this.grupoDAO.countGrupoPaginacao(grupo, subGrupo);
	}

	public List<Grupo> buscaGrupoPaginacao(Grupo grupo, SubGrupo subGrupo,int first, int pageSize) {
		return this.grupoDAO.buscaGrupoPaginacao(grupo, subGrupo, first, pageSize);
	}
}
