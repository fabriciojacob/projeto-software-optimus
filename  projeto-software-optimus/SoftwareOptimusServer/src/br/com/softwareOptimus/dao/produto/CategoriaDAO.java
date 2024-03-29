package br.com.softwareOptimus.dao.produto;

import java.util.List;

import br.com.softwareOptimus.produto.Categoria;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;

public interface CategoriaDAO {
	
	public void remover(Long idCateg);
	public List<Categoria> listarCatg(SubGrupo subGrupo);
	public void salvarCategoria(Categoria categoria);
	public List<Produto> verificaRemCat(SubGrupo subGrupo, Long idCateg);
}
