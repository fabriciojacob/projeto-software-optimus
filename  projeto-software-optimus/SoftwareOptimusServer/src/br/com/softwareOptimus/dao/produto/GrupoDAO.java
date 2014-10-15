package br.com.softwareOptimus.dao.produto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;

public interface GrupoDAO {

	public void begin() throws IOException, SQLException;
	public void close() throws Exception;
	public void salvar(Grupo grupo);
	public void alterar(Grupo grupo);
	public List<Setor> verificaRemocao(Grupo grupo);
	public void remover(Grupo grupo);
	public List<Grupo> consultaId(long parseLong);
	public List<Grupo> consultaDesc(String busca);
	public List<Grupo> lista();
	public Grupo editGrupo(Long id);
	public List<Grupo> listaGrupo();
	public List<Produto> VerificaRemGrupoProd(Grupo grupo);
	public List<Produto> verificaRemSubGrupo(Grupo grupo, Long idSub);
	public List<Grupo> listaGrupoVincSet(Setor setor);
	public List<Grupo> listaGrupoIdSub(long idSub);
	public List<Grupo> listaGrupoDescSub(String busca);
}
