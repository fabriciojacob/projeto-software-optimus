package br.com.softwareOptimus.producao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbImpedimento")
public class Impedimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4913332786875763265L;
	
	@Id
	@GeneratedValue
	private Long idImp;
	
	private String descricao;
	
	

}
