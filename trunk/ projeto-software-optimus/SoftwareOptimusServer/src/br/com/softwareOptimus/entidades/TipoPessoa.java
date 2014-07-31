package br.com.softwareOptimus.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbTipoPessoa")
public class TipoPessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3567131438250695983L;
	
	@Id
	@GeneratedValue
	private Long idTipoPes;
	
	private NaturezaPessoa naturezaPessoa;
	
	public Long getIdTipoPes() {
		return idTipoPes;
	}
	
	public void setIdTipoPes(Long idTipoPes) {
		this.idTipoPes = idTipoPes;
	}
	
	public NaturezaPessoa getNaturezaPessoa() {
		return naturezaPessoa;
	}
	
	public void setNaturezaPessoa(NaturezaPessoa naturezaPessoa) {
		this.naturezaPessoa = naturezaPessoa;
	}

}
