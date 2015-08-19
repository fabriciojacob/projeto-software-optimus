package br.com.softwareOptimus.dao.produto;

import java.util.List;

import javax.persistence.Query;

import br.com.softwareOptimus.produto.Grupo;
import br.com.softwareOptimus.produto.Produto;
import br.com.softwareOptimus.produto.Setor;

public interface SetorDAO {

	public void salvar(Setor setor);
	public void altSet(Setor setor);
	public List<Produto> verProdSet(Setor setor);
	public void remove(Setor setor);
	public List<Setor> listar();
	public List<Setor> consultaId(long parseLong);
	public List<Setor> consultaDesc(String busca);
	public List<Produto> verRemRelGrup(Setor setor, Long idGrup);
	public Setor editSet(Long id);
	public List<Setor> consultaDescGrup(String busca);
	public List<Setor> consultaIdGrup(long idGrup);
	public int countSetorPaginacao(Setor setor, Grupo grupo);
	public List<Setor> buscaSetorPaginacao(Setor setor, Grupo grupo, int first,int pageSize);
	public void defineCondicao(StringBuilder sql, Setor setor, Grupo grupo);
	public void defineParametros(Query qry, Setor setor, Grupo grupo);

}
