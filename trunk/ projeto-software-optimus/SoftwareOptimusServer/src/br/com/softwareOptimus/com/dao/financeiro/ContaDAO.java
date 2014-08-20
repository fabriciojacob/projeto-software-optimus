package br.com.softwareOptimus.com.dao.financeiro;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import br.com.softwareOptimus.financeiro.Conta;
import br.com.softwareOptimus.financeiro.ContaFilha;

public interface ContaDAO {
	
	public void begin()  throws IOException, SQLException;
	
	public void close() throws Exception;

	public void salvar(Conta conta) throws Exception;

	public void salvarContaFilha(ContaFilha contaFilha) throws Exception;

	public void excluirContaFilha(ContaFilha contaFilha) throws Exception;

	public List<Conta> pesquisaConta(String descricao) throws Exception;

	public List<ContaFilha> listaContaFilha(Conta conta) throws Exception;
	
	public ContaFilha localizaContaFilha(Long id) throws Exception;
	
	public void alterarConta(Conta conta) throws Exception;
	
	public Conta pesquisaConta(Long id) throws Exception;

}
