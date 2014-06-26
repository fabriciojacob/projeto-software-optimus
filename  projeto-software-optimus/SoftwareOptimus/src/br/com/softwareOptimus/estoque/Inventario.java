package br.com.softwareOptimus.estoque;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.PessoaJuridica;

import softwareOptimus.com.produto.Produto;


@Entity
@Table(name="tbInventario")
public class Inventario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6741368091337990748L;
	
	@Id
	@GeneratedValue
	private Long idInventario;
	
	private String descricao;
	
	@ManyToMany
	private Collection<Produto> produtos;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private Double quantidadeContata;
	
	private Double quantidadeAtual;
	
	@ManyToOne
	private PessoaJuridica empresa;
	
	
	
	public Double getQuantidadeAtual() {
		return quantidadeAtual;
	}
	
	public void setQuantidadeAtual(Double quantidadeAtual) {
		this.quantidadeAtual = quantidadeAtual;
	}
	
	public Double getQuantidadeContata() {
		return quantidadeContata;
	}
	
	public void setQuantidadeContata(Double quantidadeContata) {
		this.quantidadeContata = quantidadeContata;
	}

	public Long getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Long idInventario) {
		this.idInventario = idInventario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idInventario == null) ? 0 : idInventario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventario other = (Inventario) obj;
		if (idInventario == null) {
			if (other.idInventario != null)
				return false;
		} else if (!idInventario.equals(other.idInventario))
			return false;
		return true;
	}
	

}
