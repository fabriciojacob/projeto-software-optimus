package br.com.softwareOptimus.fiscal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Estado;
import br.com.softwareOptimus.entidades.TipoPessoaJuridica;

@Entity
@Table(name = "tbGradeTributariaVigencia")
public class GradeTributariaVigencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8394772242132907486L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String descricao;

	@ManyToOne
	private Estado origem;

	@ManyToOne
	private Estado destino;

	@OneToOne
	private Aliquota aliquota;

	private IO io;

	private TipoPessoaJuridica tipoGrade;

	@Temporal(TemporalType.DATE)
	private Date vigencia;

	@ManyToOne
	private Pauta pauta;
	
	@ManyToOne
	private GradeTributaria grade;
	
	public GradeTributaria getGrade() {
		return grade;
	}
	
	public void setGrade(GradeTributaria grade) {
		this.grade = grade;
	}
	
	public Date getVigencia() {
		return vigencia;
	}
	
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public TipoPessoaJuridica getTipoGrade() {
		return tipoGrade;
	}

	public void setTipoGrade(TipoPessoaJuridica tipoGrade) {
		this.tipoGrade = tipoGrade;
	}
	
	public Pauta getPauta() {
		return pauta;
	}
	
	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
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
		GradeTributariaVigencia other = (GradeTributariaVigencia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
