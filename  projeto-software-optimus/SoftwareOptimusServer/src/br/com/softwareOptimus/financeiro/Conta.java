package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbConta")
public class Conta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6555942808769494213L;

	@Id
	@GeneratedValue
	private Long idConta;
	
	private TipoMov tipo;
	
	private TipoMov tipoMov;
	
	private String descricao;
	
	private TipoContaBancaria tipoContaBancaria;
	
	@OneToMany(mappedBy = "conta")
	private Collection<Titulo> titulos;
	
	private boolean desmembrada;
	
	private boolean inativa;
	
	
	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public Collection<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(Collection<Titulo> titulos) {
		this.titulos = titulos;
	}

	public boolean isDesmembrada() {
		return desmembrada;
	}

	public void setDesmembrada(boolean desmembrada) {
		this.desmembrada = desmembrada;
	}

	public boolean isInativa() {
		return inativa;
	}

	public void setInativa(boolean inativa) {
		this.inativa = inativa;
	}

	public TipoMov getTipoMov() {
		return tipoMov;
	}
	
	public void setTipoMov(TipoMov tipoMov) {
		this.tipoMov = tipoMov;
	}

	public TipoMov getTipo() {
		return tipo;
	}

	public void setTipo(TipoMov tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoContaBancaria getTipoContaBancaria() {
		return tipoContaBancaria;
	}
	
	public void setTipoContaBancaria(TipoContaBancaria tipoContaBancaria) {
		this.tipoContaBancaria = tipoContaBancaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
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
		Conta other = (Conta) obj;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		return true;
	}
	
}
