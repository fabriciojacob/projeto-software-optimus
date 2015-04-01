package br.com.softwareOptimus.financeiro;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.softwareOptimus.entidades.Pessoa;

@Entity
@Table(name="tbTitulo")
public class Titulo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6269276424422686896L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="TITULO_SEQ")
	@SequenceGenerator(name="TITULO_SEQ",sequenceName="TITULO_SEQ", allocationSize=1) 
	private Long idTitulo;
	
	private String descricao;
	
	private String descEstorno;
	
	@ManyToOne
	private FormaPgto formaPgto;
	
	@ManyToOne
	private CondPgto condPgto;
	
	private Long idTituloPai;
	
	private Double valor;
	
	private Double valorTitulo;

	private TipoTitulo tipoTitulo;
	
	@Temporal(TemporalType.DATE)
	private Date dataLancamento;
	
	@Temporal(TemporalType.DATE)
	private Date vencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	private StatusConta status;
	
	private TipoBaixa tipoBaixa;

	@ManyToOne
	private Conta conta;
	
	private Rubrica rubrica;
	
	@ManyToOne
	private Pessoa pessoa;
	
	@ManyToOne
	private Pessoa empresa;

	public Rubrica getRubrica() {
		return rubrica;
	}
	
	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	public TipoBaixa getTipoBaixa() {
		return tipoBaixa;
	}
	
	public void setTipoBaixa(TipoBaixa tipoBaixa) {
		this.tipoBaixa = tipoBaixa;
	}
	
	public Conta getConta() {
		return conta;
	}
	
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	
	public StatusConta getStatus() {
		return status;
	}
	
	public void setStatus(StatusConta status) {
		this.status = status;
	}

	public Long getIdTitulo() {
		return idTitulo;
	}

	public void setIdConta(Long idTitulo) {
		this.idTitulo = idTitulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}

	public CondPgto getCondPgto() {
		return condPgto;
	}

	public void setCondPgto(CondPgto condPgto) {
		this.condPgto = condPgto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setIdTitulo(Long idTitulo) {
		this.idTitulo = idTitulo;
	}

	public Pessoa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Pessoa empresa) {
		this.empresa = empresa;
	}
	
	public TipoTitulo getTipoTitulo() {
		return tipoTitulo;
	}
	
	public void setTipoTitulo(TipoTitulo tipoTitulo) {
		this.tipoTitulo = tipoTitulo;
	}	

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(Double valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public Long getIdTituloPai() {
		return idTituloPai;
	}

	public void setIdTituloPai(Long idTituloPai) {
		this.idTituloPai = idTituloPai;
	}

	public String getDescEstorno() {
		return descEstorno;
	}

	public void setDescEstorno(String descEstorno) {
		this.descEstorno = descEstorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idTitulo == null) ? 0 : idTitulo.hashCode());
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
		Titulo other = (Titulo) obj;
		if (idTitulo == null) {
			if (other.idTitulo != null)
				return false;
		} else if (!idTitulo.equals(other.idTitulo))
			return false;
		return true;
	}

}
