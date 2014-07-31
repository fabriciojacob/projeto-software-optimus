package br.com.softwareOptimus.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.softwareOptimus.comercial.Requisicao;

@Entity
@Table(name="tbPessoa")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3916788649027925253L;

	@Id
	@GeneratedValue
	private Long idPessoa;
	
	private String fantasia;
	
	private String razaoSocial;
	
	@OneToMany(mappedBy ="empresa")
	private Collection<Requisicao> requisicao;
	
	private NaturezaPessoa naturezaPessoa;
	
	private boolean status;
	
	//quando natureza for contador
	private String Crc;
	
	@OneToMany
	@JoinTable(name="TbLogradouroPessoa")
	private Collection<Logradouro> logradouro;
	
	public String getCrc() {
		return Crc;
	}

	public void setCrc(String crc) {
		Crc = crc;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public NaturezaPessoa getNaturezaPessoa() {
		return naturezaPessoa;
	}
	
	public void setNaturezaPessoa(NaturezaPessoa naturezaPessoa) {
		this.naturezaPessoa = naturezaPessoa;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}
	
	public Collection<Logradouro> getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(Collection<Logradouro> logradouro) {
		this.logradouro = logradouro;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPessoa == null) ? 0 : idPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}
	

}
