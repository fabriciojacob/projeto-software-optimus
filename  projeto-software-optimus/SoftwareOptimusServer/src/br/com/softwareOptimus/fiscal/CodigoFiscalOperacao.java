package br.com.softwareOptimus.fiscal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbCFOP")
public class CodigoFiscalOperacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2164192404596076223L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 350, nullable = true, unique = false)
	private String descricao;

	private IO io;

	private String cfop;

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public IO getIo() {
		return io;
	}

	public void setIo(IO io) {
		this.io = io;
	}
}
