package br.com.softwareOptimus.com.financeiro.dao;

import java.io.IOException;
import java.sql.SQLException;
import br.com.softwareOptimus.financeiro.ContaBancaria;
import br.com.softwareOptimus.financeiro.ExtratoContaBancaria;

public interface ExtratoContaDAO {

	public void begin() throws IOException, SQLException;

	public void close() throws Exception;

	public void inclusao(ExtratoContaBancaria extrato) throws Exception;

	public Double saldoReg(ContaBancaria contaBancaria) throws Exception;

}
