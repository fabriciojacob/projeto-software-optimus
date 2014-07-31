package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
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
	private Long idConta;
	
	private TipoMov tipo;
	
	private String descricao;
	
	@OneToMany(mappedBy = "conta")
	private Collection<Titulo> titulos;

	public Long getCodigo() {
		return idConta;
	}

	public void setCodigo(Long codigo) {
		this.idConta = codigo;
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
