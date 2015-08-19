package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;
import br.com.softwareOptimus.produto.SubGrupo;

public interface GrupoDAO {

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
	public int countGrupoPaginacao(Grupo grupo, SubGrupo subGrupo);
	public List<Grupo> buscaGrupoPaginacao(Grupo grupo, SubGrupo subGrupo,int first, int pageSize);
	public void defineCondicao(StringBuilder sql, Grupo grupo, SubGrupo subGrupo);
	public void defineParametros(Query qry, Grupo grupo, SubGrupo subGrupo);
}
