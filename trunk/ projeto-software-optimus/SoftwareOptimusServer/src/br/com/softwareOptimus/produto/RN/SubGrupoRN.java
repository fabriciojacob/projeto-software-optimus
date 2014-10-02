package br.com.softwareOptimus.produto.RN;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.dao.produto.CategoriaDAO;
import br.com.softwareOptimus.dao.produto.SubGrupoDAO;
import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;
import br.com.softwareOptimus.util.DAOFactory;

public class SubGrupoRN {
	
	private SubGrupoDAO subGrupoDAO;
	private CategoriaDAO categoriaDAO;
	
	public SubGrupoRN(){
		this.subGrupoDAO = DAOFactory.criaSubGrupoDAO();
		this.categoriaDAO = DAOFactory.criaCategoriaDAO();
	}

	public Integer validaCampoNulo(SubGrupo subGrupo) {
		Integer retorno = 0;
		if (subGrupo.getDescricao().equals("")){
			retorno = 1;
		}
		return retorno;
	}

	public void altSub(SubGrupo subGrupo) {
		this.subGrupoDAO.altSub(subGrupo);
	}

	public void salvar(SubGrupo subGrupo) {
		this.subGrupoDAO.salvar(subGrupo);
	}

	public Integer verificaRemocao(SubGrupo subGrupo) {
		List<Grupo> listaGrupo = this.subGrupoDAO.verificaRemocao(subGrupo);
		List<Produto> listProd = this.subGrupoDAO.verificaRemocaoSubProd(subGrupo);
		if(listaGrupo.size() == 0 && listProd.size() ==0){
			return 0;
		}else{
			return 1;
		}
	}

	public void remover(SubGrupo subGrupo) throws IOException, SQLException {
		this.subGrupoDAO.remover(subGrupo);
	}

	public List<SubGrupo> consultaId(long parseLong) {
		return this.subGrupoDAO.consultaId(parseLong);
	}

	public List<SubGrupo> consultaDesc(String busca) {		
		return this.subGrupoDAO.consultaDesc(busca);
	}

	public List<SubGrupo> listar() {
		return this.subGrupoDAO.listar();
	}

	public List<Categoria> listarCatg(SubGrupo subGrupo) {
		return this.categoriaDAO.listarCatg(subGrupo);
	}

	public void removerCat(Long idCateg) {
		this.categoriaDAO.remover(idCateg);
	}

	public SubGrupo editSub(Long id) {
		return this.subGrupoDAO.editSub(id);
	}

	public Integer validaCampoNuloCategoria(Categoria categoria) {
		Integer retorno = 0;
		if (categoria.getDescricao().equals("")){
			retorno = 1;
		}
		return retorno;
	}

	public void salvarCategoria(Categoria categoria) {
		this.categoriaDAO.salvarCategoria(categoria);
	}

	public List<SubGrupo> listaSubGrupo() {
		return this.subGrupoDAO.listaSubGrupo();
	}

	public List<SubGrupo> listaSubGru(Long id) {
		return this.subGrupoDAO.listaSubGru(id);
	}

	public Integer VerificaRemCatSub(SubGrupo subGrupo, Long idCateg) {
		List<Produto> listProd = this.categoriaDAO.verificaRemCat(subGrupo, idCateg);
		if (listProd.size() == 0){
			return 0;
		}else{
			return 1;
		}
	}

}
