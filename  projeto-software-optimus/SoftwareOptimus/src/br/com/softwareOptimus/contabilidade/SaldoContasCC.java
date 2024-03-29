package br.com.softwareOptimus.contabilidade;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.softwareOptimus.entidades.CenCusto;


@Entity
@Table(name ="tbSaldoContasCC")
public class SaldoContasCC extends SaldoContas {

	@ManyToMany
	private Collection<CenCusto> cCusto;

	public Collection<CenCusto> getcCusto() {
		return cCusto;
	}

	public void setcCusto(Collection<CenCusto> cCusto) {
		this.cCusto = cCusto;
	}
}
