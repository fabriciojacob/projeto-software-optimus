package br.com.softwareOptimus.comercial;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;
import br.com.softwareOptimus.entidades.Usuario;


@Entity
@Table(name = "tbRequisicao")
public class Requisicao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5415867454032662585L;

	@Id
	@GeneratedValue
	private Long idRequisicao;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "usuRequisita", nullable = false, foreignKey = @ForeignKey(name = "fk_tbUsuario"))
	private Usuario UsuRequisita;
	
	@ManyToOne
	private Pessoa empresa;
	
	@OneToMany(mappedBy = "Requisicao")
	private Collection<RequisicaoItens> requisicaoItens;
	
	private String observacoes;
	
	@Temporal(TemporalType.DATE)
	private Date dataReq;
	
	private TipoOrigem tipoOrigem;
	
	private StatusGeral statusGeral;

	public Date getDataReq() {
		return dataReq;
	}

	public void setDataReq(Date dataReq) {
		this.dataReq = dataReq;
	}

	public Long getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(Long idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public Usuario getIdUsuRequisita() {
		return UsuRequisita;
	}

	public void setIdUsuRequisita(Usuario idUsuRequisita) {
		this.UsuRequisita = idUsuRequisita;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public TipoOrigem getTipoOrigem() {
		return tipoOrigem;
	}

	public void setTipoOrigem(TipoOrigem tipoOrigem) {
		this.tipoOrigem = tipoOrigem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getUsuRequisita() {
		return UsuRequisita;
	}

	public void setUsuRequisita(Usuario usuRequisita) {
		UsuRequisita = usuRequisita;
	}

	public Collection<RequisicaoItens> getRequisicaoItens() {
		return requisicaoItens;
	}

	public void setRequisicaoItens(Collection<RequisicaoItens> requisicaoItens) {
		this.requisicaoItens = requisicaoItens;
	}

	public StatusGeral getStatusGeral() {
		return statusGeral;
	}

	public void setStatusGeral(StatusGeral statusGeral) {
		this.statusGeral = statusGeral;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRequisicao == null) ? 0 : idRequisicao.hashCode());
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
		Requisicao other = (Requisicao) obj;
		if (idRequisicao == null) {
			if (other.idRequisicao != null)
				return false;
		} else if (!idRequisicao.equals(other.idRequisicao))
			return false;
		return true;
	}
}
