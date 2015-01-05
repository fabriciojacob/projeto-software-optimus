package br.com.softwareOptimus.contabilidade;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.softwareOptimus.entidades.CenCusto;


@Entity
@Table(name ="tbSaldoContasCC")
public class SaldoContasCC extends SaldoContas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6191461201037988298L;
	
	@ManyToOne
	@JoinColumn(name = "idCenCusto", nullable = false, foreignKey = @ForeignKey(name = "fk_tbCCusto"))
	private CenCusto cCusto;

	public CenCusto getcCusto() {
		return cCusto;
	}
	
	public void setcCusto(CenCusto cCusto) {
		this.cCusto = cCusto;
	}
}
