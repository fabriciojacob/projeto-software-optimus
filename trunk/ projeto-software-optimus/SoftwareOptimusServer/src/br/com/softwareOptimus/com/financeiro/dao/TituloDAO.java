package br.com.softwareOptimus.com.financeiro.dao;

import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.Titulo;

public interface TituloDAO {
	
	public void salvar(Titulo titulo) throws Exception;
	
	public void editar(Titulo titulo) throws Exception;
	
	public List<Titulo> pesquisaPeriodo(Date dataInicio, Date dataFim) throws Exception;
	
	public List<Titulo> pesquisaPessoa(Pessoa p) throws Exception;
	
	public void excluir(Titulo titulo) throws Exception;

}
