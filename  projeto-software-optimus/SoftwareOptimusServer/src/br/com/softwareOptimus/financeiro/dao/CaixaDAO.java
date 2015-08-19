package br.com.softwareOptimus.financeiro.dao;

import java.util.List;

import br.com.softwareOptimus.financeiro.Caixa;

public interface CaixaDAO {

	public void salvar(Caixa caixa) throws Exception;
	public void excluir(Caixa caixa) throws Exception;
	public List<Caixa> pesquisaCaixa(String descricao) throws Exception;
	public void editar(Caixa caixa) throws Exception;
	public Caixa pesquisaID(Long id) throws Exception;
	public List<Caixa> listaCaixa() throws Exception;
}
