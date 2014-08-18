package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;

@Entity
@Table(name="tbGradeTributaria")
public class GradeTributaria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394772242132907486L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Estado origem;
	
	@ManyToOne
	private Estado destino;
	
	@OneToOne
	private Aliquota aliquota;
	
	private IO io;
	
	private TipoPessoaJuridica tipoGrade;
	
	@ManyToOne
	private PautaMVA pautaMva;
	
	@ManyToMany
	private Collection<FiguraFiscal> figura;
	
	public Collection<FiguraFiscal> getFigura() {
		return figura;
	}

	public void setFigura(Collection<FiguraFiscal> figura) {
		this.figura = figura;
	}

	public TipoPessoaJuridica getTipoGrade() {
		return tipoGrade;
	}
	
	public void setTipoGrade(TipoPessoaJuridica tipoGrade) {
		this.tipoGrade = tipoGrade;
	}

	public PautaMVA getPautaMva() {
		return pautaMva;
	}
	
	public void setPautaMva(PautaMVA pautaMva) {
		this.pautaMva = pautaMva;
	}
	
	public Estado getOrigem() {
		return origem;
	}

	public void setOrigem(Estado origem) {
		this.origem = origem;
	}

	public Estado getDestino() {
		return destino;
	}

	public void setDestino(Estado destino) {
		this.destino = destino;
	}
	
	public IO getIo() {
		return io;
	}
	
	public void setIo(IO io) {
		this.io = io;
	}
	
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aliquota getAliquota() {
		return aliquota;
	}

	public void setAliquota(Aliquota aliquota) {
		this.aliquota = aliquota;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		GradeTributaria other = (GradeTributaria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
