package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.SubGrupo;

public interface SubGrupoDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(SubGrupo subGrupo);
	public void altSub(SubGrupo subGrupo);
	public List<Grupo> verificaRemocao(SubGrupo subGrupo);
	public void remover(SubGrupo subGrupo) throws IOException, SQLException;
	public List<SubGrupo> listar();
	public List<SubGrupo> consultaId(long parseLong);
	public List<SubGrupo> consultaDesc(String busca);
	public SubGrupo editSub(Long id);
	public List<SubGrupo> listaSubGrupo();
	public List<SubGrupo> listaSubGru(Long id);
	public List<Produto> verificaRemocaoSubProd(SubGrupo subGrupo);
	public List<SubGrupo> listaSubGrupoVincGrupo(Grupo grupo);
}
