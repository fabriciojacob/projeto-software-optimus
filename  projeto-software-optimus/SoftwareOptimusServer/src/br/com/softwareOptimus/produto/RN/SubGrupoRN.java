package br.com.softwareOptimus.produto.RN;

import br.com.softwareOptimus.dao.produto.CategoriaDAO;
import br.com.softwareOptimus.dao.produto.SubGrupoDAO;
import br.com.softwareOptimus.util.DAOFactory;

public class SubGrupoRN {
	
	private SubGrupoDAO subGrupoDAO;
	private CategoriaDAO categoriaDAO;
	
	public SubGrupoRN(){
		this.subGrupoDAO = DAOFactory.criaSubGrupoDAO();
		this.categoriaDAO = DAOFactory.criaCategoriaDAO();
	}

}
