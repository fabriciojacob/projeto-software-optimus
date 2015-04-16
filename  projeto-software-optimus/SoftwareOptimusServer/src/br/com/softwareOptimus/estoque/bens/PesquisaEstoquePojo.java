package br.com.softwareOptimus.estoque.bens;

import java.io.Serializable;
import java.util.Date;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.TipoMovEst;
import br.com.softwareOptimus.produto.Produto;

public class PesquisaEstoquePojo implements Serializable {

	private static final long serialVersionUID = -5224368552214826643L;
	
	private Produto produto;
	private Pessoa empresa;
	private Date dataIni;
	private Date dataFim;
	private TipoMovEst tipoMovEst;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public TipoMovEst getTipoMovEst() {
		return tipoMovEst;
	}

	public void setTipoMovEst(TipoMovEst tipoMovEst) {
		this.tipoMovEst = tipoMovEst;
	}
}
