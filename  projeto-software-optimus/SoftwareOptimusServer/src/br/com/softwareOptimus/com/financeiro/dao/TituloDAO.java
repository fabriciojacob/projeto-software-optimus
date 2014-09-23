package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.financeiro.StatusConta;
import br.com.softwareOptimus.financeiro.TipoTitulo;
import br.com.softwareOptimus.financeiro.Titulo;

public interface TituloDAO {

	public void salvar(Titulo titulo) throws Exception;

	public void editar(Titulo titulo) throws Exception;

	public List<Titulo> pesquisaVencimento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;

	public List<Titulo> pesquisaPagamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;

	public List<Titulo> pesquisaLancamento(Date dataInicio, Date dataFim,
			Pessoa empresa, Pessoa participante, Integer tipo,
			Integer status) throws Exception;

	public List<Titulo> pesquisaPessoa(Pessoa p) throws Exception;

	public void excluir(Titulo titulo) throws Exception;

	public void begin() throws IOException, SQLException;

}
